package com.aixtor.meepay.employee.headless.internal.resource.v1_0;

import com.aixtor.meepay.employee.headless.dto.v1_0.Department;
import com.aixtor.meepay.employee.headless.dto.v1_0.Employee;
import com.aixtor.meepay.employee.headless.dto.v1_0.EmployeeByDepartmentRequest;
import com.aixtor.meepay.employee.headless.dto.v1_0.EmployeeByDepartmentResponse;
import com.aixtor.meepay.employee.headless.dto.v1_0.Status;
import com.aixtor.meepay.employee.headless.resource.v1_0.GetEmployeesByDepartmentResource;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author dhruv.dhana
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/get-employees-by-department.properties",
	scope = ServiceScope.PROTOTYPE,
	service = GetEmployeesByDepartmentResource.class
)
public class GetEmployeesByDepartmentResourceImpl
	extends BaseGetEmployeesByDepartmentResourceImpl {

	@Reference
	UserLocalService userLocalService;

	@Reference
	EmployeeLocalService employeeLocalService;

	@Reference
	DepartmentLocalService departmentLocalService;
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Override
	public EmployeeByDepartmentResponse postGetEmployeesByDepartment(
			EmployeeByDepartmentRequest employeeByDepartmentRequest)
		throws Exception {
		long departmentId = -1;

		String departmentName = StringPool.BLANK;

		try {
			departmentName = employeeByDepartmentRequest.getDepartmentName();
			if (departmentName == null || departmentName.equals(StringPool.BLANK))
				departmentName = StringPool.BLANK;
			departmentId = employeeByDepartmentRequest.getDepartmentId();

		}
		catch(Exception ignored){}
		
		List <com.aixtor.meepay.model.Employee> employeeList = null;
		com.aixtor.meepay.model.Department department = null;
		
		try {
			if (departmentId != -1 && departmentName.equals(StringPool.BLANK)) {
				employeeList = employeeLocalService.findByDepartmentId(departmentId);
				department = departmentLocalService.getDepartment(departmentId);
			}
			if (departmentId == -1 && !departmentName.equals(StringPool.BLANK)) {
				department = departmentLocalService.findByName(departmentName).get(0);
				employeeList = employeeLocalService.findByDepartmentId(
						department.getDepartmentId());
				
			}
			if (departmentId != -1 && !departmentName.equals(StringPool.BLANK)) {
				department = departmentLocalService.getDepartment(departmentId);
				if (department.getName().equals(departmentName)){
					employeeList = employeeLocalService.findByDepartmentId(departmentId);
				}
				else {
					return responseGenerator("Failure","Name and Id Do not match");
				}
			}
		} catch (Exception e) {
			if (departmentId != -1 && !departmentName.equals("default"))
				return responseGenerator("Failure","Name and Id Do not match");
			else 
				return responseGenerator("Failure","No Such Department Exist");
		}
		EmployeeByDepartmentResponse response= new EmployeeByDepartmentResponse();
		Status status = new Status();
		if (departmentId == -1 && departmentName.equals(StringPool.BLANK)) {
			return responseGenerator("Failure","Send atleast one parameter");
		}
		else if (employeeList == null || employeeList.isEmpty()) {
			return responseGenerator("Success","Got zero rows");
		}
		else {
			status.setCode("Success");
			status.setMessage("Data retrieved scuccessfully");
			
			Employee[] employees = new Employee[employeeList.size()];
			Department[] departments = new Department[1];

			departments[0] = new Department();
			departments[0].setDepartmentId(department.getPrimaryKey());
			departments[0].setDepartmentName(department.getName());
			departments[0].setDepartmentHead(userLocalService.getUser(Long.parseLong(
					department.getDepartmentHead())).getFullName());
			response.setDepartments(departments);
			int i = 0;
			for (com.aixtor.meepay.model.Employee employee:employeeList) {
				employees[i] = new Employee();
				employees[i].setBranchName(branchLocalService.getBranch(
						employee.getBranchId()).getName());
				employees[i].setMobile(StringPool.BLANK+employee.getMobileNumber());
				employees[i].setDepartmentName(department.getName());
				employees[i].setFirstName(employee.getFirstName());
				employees[i].setLastName(employee.getLastName());
				employees[i].setEmployeeId(employee.getPrimaryKey());
				employees[i++].setEmail(employee.getEmail()); 
			}
			
			response.setEmployees(employees);
		}
		response.setTotalEmployee((long)employeeList.size());
		response.setStatus(status);
		return response;
	}
	
	private EmployeeByDepartmentResponse responseGenerator(String code,String message) {
		EmployeeByDepartmentResponse response= new EmployeeByDepartmentResponse();
		Status status = new Status();
		
		status.setCode(code);
		status.setMessage(message);
		
		response.setStatus(status);
		return response;
	}
}