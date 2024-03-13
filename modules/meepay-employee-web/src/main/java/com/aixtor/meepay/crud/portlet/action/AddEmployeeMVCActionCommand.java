package com.aixtor.meepay.crud.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.crud.constants.MeepayEmployeeConstants;
import com.aixtor.meepay.crud.constants.MeepayEmployeePortletKeys;
import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE,
        "mvc.command.name=/addEmployee"

}, service = MVCActionCommand.class)


public class AddEmployeeMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    EmployeeLocalService employeeLocalService;

    @Reference
    AixtorCommonApi aixtorCommonApi;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        Employee employee = employeeLocalService.createEmployee(
                CounterLocalServiceUtil.increment(Employee.class.getName()));
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        employee.setFirstName(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.FIRST_NAME));
        employee.setLastName(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.LAST_NAME));
        employee.setEmail(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.EMAIL));
        employee.setMobileNumber(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.MOBILE));
        employee.setDepartmentId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.DEPARTMENT));
        employee.setBranchId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.BRANCH));
        employee.setDesignationId(ParamUtil.getLong(actionRequest, MeepayEmployeeConstants.DESIGNATION));
        employee.setAddress(ParamUtil.getString(actionRequest, MeepayEmployeeConstants.ADDRESS));
             
        employee.setCompanyId(themeDisplay.getCompanyId());
        employee.setGroupId(themeDisplay.getSiteGroupId());
        employee.setCompanyId(themeDisplay.getCompanyId());
        employee.setUserId(themeDisplay.getUserId());
        employee.setUserName(themeDisplay.getUser().getFullName());

        aixtorCommonApi.addEmployee(employee, themeDisplay,  MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE);

        actionResponse.sendRedirect(MeepayEmployeeConstants.ROOT_URL);
    }
}
