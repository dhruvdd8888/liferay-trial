package com.aixtor.meepay.employee.headless.internal.resource.v1_0;

import com.aixtor.meepay.employee.headless.dto.v1_0.Branch;
import com.aixtor.meepay.employee.headless.dto.v1_0.Employee;
import com.aixtor.meepay.employee.headless.dto.v1_0.EmployeeByBranchRequest;
import com.aixtor.meepay.employee.headless.dto.v1_0.EmployeeByBranchResponse;
import com.aixtor.meepay.employee.headless.dto.v1_0.Status;
import com.aixtor.meepay.employee.headless.resource.v1_0.GetEmployeesByBranchResource;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.CityLocalService;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.aixtor.meepay.service.StateLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author dhruv.dhana
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/get-employees-by-branch.properties",
	scope = ServiceScope.PROTOTYPE, service = GetEmployeesByBranchResource.class
)
public class GetEmployeesByBranchResourceImpl
	extends BaseGetEmployeesByBranchResourceImpl {
	
	
		@Reference
		UserLocalService userLocalService;
		
		@Reference
		EmployeeLocalService employeeLocalService;
	
		@Reference
		DepartmentLocalService departmentLocalService;
		
		@Reference
		BranchLocalService branchLocalService;
		
		@Reference
		CountryLocalService countryLocalService;
		
		@Reference
		StateLocalService stateLocalService;
		
		@Reference
		CityLocalService cityLocalService;
	
	@Override
	public EmployeeByBranchResponse postGetEmployeesByBranch(
			EmployeeByBranchRequest employeeByBranchRequest)
		throws Exception {
		long branchId = -1;
		String branchName = StringPool.BLANK;
		try {
			branchName = employeeByBranchRequest.getBranchName();
			if (branchName == null || branchName.equals(StringPool.BLANK))
				branchName = StringPool.BLANK;
			branchId = employeeByBranchRequest.getBranchId();
		}
		catch(Exception ignored){}
		List <com.aixtor.meepay.model.Employee> employeeList = null;
		com.aixtor.meepay.model.Branch branch = null;
		try {
			if (branchId != -1 && branchName.equals(StringPool.BLANK)) {
				employeeList = employeeLocalService.findByBranchId(branchId);
				branch = branchLocalService.getBranch(branchId);
			}
			if (branchId == -1 && !branchName.equals(StringPool.BLANK)) {
				branch = branchLocalService.findByName(branchName).get(0);
				employeeList = employeeLocalService.findByBranchId(branch.getBranchId());
			}
			if (branchId != -1 && !branchName.equals(StringPool.BLANK)) {
				branch = branchLocalService.getBranch(branchId);
				if (branch.getName().equals(branchName)){
					employeeList = employeeLocalService.findByBranchId(branchId);
				}
				else {
					return responseGenerator("Failure","Name and Id Do not match");
				}
			}
	
		}catch (Exception e) {
			if (branchId != -1 && !branchName.equals(StringPool.BLANK))
				return responseGenerator("Failure","Name and Id Do not match");
			else 
				return responseGenerator("Failure","No Such branch Exist");
		}
		
		
		EmployeeByBranchResponse response= new EmployeeByBranchResponse();
		Status status = new Status();
		if (branchId == -1 && branchName.equals("default")) {
			return responseGenerator("Failure","Send atleast one parameter");
		}
		else if (employeeList == null || employeeList.isEmpty()) {
			return responseGenerator("Success","Got zero rows");
		}
		else {
			status.setCode("Success");
			status.setMessage("Data retrieved scuccessfully");
			
			Employee[] employees = new Employee[employeeList.size()];
			Branch[] branches = new Branch[1];
			branches[0] = new Branch();
			branches[0].setBranchId(branch.getPrimaryKey());
			branches[0].setBranchName(branch.getName());
			branches[0].setCountry(countryLocalService.getCountry((
					branch.getCountryId())).getName());
			branches[0].setState(stateLocalService.getState(
					branch.getStateId()).getStateName());
			branches[0].setCity(cityLocalService.getCity(
					branch.getCityId()).getCityName());
			response.setBranches(branches);
			int i = 0;
			for (com.aixtor.meepay.model.Employee employee:employeeList) {
				employees[i] = new Employee();
				employees[i].setBranchName(branch.getName());
				employees[i].setMobile(StringPool.BLANK+employee.getMobileNumber());
				employees[i].setDepartmentName(departmentLocalService.getDepartment(
						employee.getDepartmentId()).getName());
				employees[i].setFirstName(employee.getFirstName());
				employees[i].setLastName(employee.getLastName());
				employees[i].setEmployeeId(employee.getPrimaryKey());
				employees[i++].setEmail(employee.getEmail()); 
			}
			response.setTotalEmployee((long)employeeList.size());
			response.setEmployees(employees);
		}
		
		response.setStatus(status);
		return response;
	}
	
	private EmployeeByBranchResponse responseGenerator(String code,String message) {
		EmployeeByBranchResponse response= new EmployeeByBranchResponse();
		Status status = new Status();
		
		status.setCode(code);
		status.setMessage(message);
		
		response.setStatus(status);
		return response;
	}

}