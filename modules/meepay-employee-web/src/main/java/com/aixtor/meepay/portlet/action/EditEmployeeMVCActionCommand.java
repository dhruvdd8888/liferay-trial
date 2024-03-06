package com.aixtor.meepay.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.constants.MeepayEmployeePortletKeys;
import com.aixtor.meepay.constants.MeepayEmployeeConstants;
import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;


@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE,
        "mvc.command.name=/editEmployee"

}, service = MVCActionCommand.class)
public class EditEmployeeMVCActionCommand extends BaseMVCActionCommand{
    @Reference
    EmployeeLocalService employeeLocalService;

    @Reference
    AixtorCommonApi aixtorCommonApi;

    
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        long employeeId = ParamUtil.getLong(actionRequest,MeepayEmployeeConstants.EMPLOYEE_ID);
		Employee employee = employeeLocalService.getEmployee(employeeId);
		
        employee.setFirstName(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.FIRST_NAME));
		employee.setLastName(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.LAST_NAME));
		employee.setEmail(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.EMAIL));
		employee.setMobileNumber(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.MOBILE));
		employee.setDepartmentId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.DEPARTMENT));
		employee.setBranchId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.BRANCH));
		employee.setDesignationId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.DESIGNATION));
		employee.setAddress(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.ADDRESS));
        aixtorCommonApi.updateEmployee(employee, themeDisplay, MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE);
        actionResponse.sendRedirect(MeepayEmployeeConstants.ROOT_URL);
    }

}
