package com.aixtor.meepay.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.constants.MeepayEmployeeConstants;
import com.aixtor.meepay.constants.MeepayEmployeePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = {
        "javax.portlet.name=" + MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE,
        "mvc.command.name=/deleteEmployee"

}, service = MVCActionCommand.class)

public class DeleteEmployeeMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    AixtorCommonApi aixtorCommonApi;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        boolean done = aixtorCommonApi.deleteEmployee(employeeId, themeDisplay, MeepayEmployeePortletKeys.MEEPAY_EMPLOYEE);
        if (done)SessionMessages.add(actionRequest, "delete-employee-success" );
        else SessionErrors.add(actionRequest, "delete-employee-fail");

        actionResponse.sendRedirect(MeepayEmployeeConstants.ROOT_URL);
    }
}
