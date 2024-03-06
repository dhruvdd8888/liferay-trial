package com.aixtor.meepay.portlet.action;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.constants.MeepayEmployeeConstants;
import com.aixtor.meepay.constants.MeepayEmployeePortletKeys;
import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.model.Designation;
import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.models.EmployeeMapper;
import com.aixtor.meepay.models.EmployeeWebModel;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.aixtor.meepay.service.DesignationLocalService;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)
public class ViewEmployeeMVCRenderCommand implements MVCRenderCommand{
	
	@Reference
	AixtorCommonApi aixtorCommonApi;
	@Reference
	DepartmentLocalService departmentLocalService;
	@Reference
	BranchLocalService branchLocalService;
	@Reference
	DesignationLocalService designationLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;
	

	public static List<Branch> branchList ;
	public static List<Department> departmentList;
	public static List<Designation> designationList;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		branchList = branchLocalService.getBranches(-1, -1);
		departmentList = departmentLocalService.getDepartments(-1, -1);
		designationList = designationLocalService.getDesignations(-1, -1);
		new EmployeeMapper(branchList,departmentList,designationList);
		
		List<Employee> employeeList = employeeLocalService.getEmployees(-1, -1);
		List<EmployeeWebModel> filteredList = new ArrayList<EmployeeWebModel>();
		for(Employee employee:employeeList) {
        	EmployeeWebModel employeeWebModel = new EmployeeWebModel(employee);
        	filteredList.add(employeeWebModel);				
		}
		renderRequest.setAttribute(MeepayEmployeeConstants.EMPLOYEE_LIST,filteredList);
		renderRequest.setAttribute(MeepayEmployeeConstants.DEPARTMENT_LIST,departmentList);
		renderRequest.setAttribute(MeepayEmployeeConstants.BRANCH_LIST,branchList);
		renderRequest.setAttribute(MeepayEmployeeConstants.DESIGNATION_LIST,designationList);						
	
		return MeepayEmployeeConstants.VIEW_JSP;
	}
}
