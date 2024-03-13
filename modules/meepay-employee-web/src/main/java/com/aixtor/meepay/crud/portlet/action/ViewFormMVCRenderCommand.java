package com.aixtor.meepay.crud.portlet.action;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.crud.constants.MeepayEmployeeConstants;
import com.aixtor.meepay.crud.constants.MeepayEmployeePortletKeys;
import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.model.Designation;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.aixtor.meepay.service.DesignationLocalService;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE,
			"mvc.command.name=/renderEmployeeForm"
		},
		service = MVCRenderCommand.class
	)

public class ViewFormMVCRenderCommand implements MVCRenderCommand  {
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
		
        renderRequest.setAttribute(MeepayEmployeeConstants.DEPARTMENT_LIST,departmentList);
		renderRequest.setAttribute(MeepayEmployeeConstants.BRANCH_LIST,branchList);
		renderRequest.setAttribute(MeepayEmployeeConstants.DESIGNATION_LIST,designationList);						
        
        return MeepayEmployeeConstants.FORM_JSP;
    }
    
}
