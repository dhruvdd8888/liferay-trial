package com.aixtor.training.actions;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.training.constants.BasicFormPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;



@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + BasicFormPortletKeys.BASICFORM,
	        "mvc.command.name=/submithandle",
	    }, 
	    service = MVCActionCommand.class
)
public class SubmitHandler extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("reaches -======----==-=--=");
		String name = ParamUtil.getString(actionRequest, "name");
		String number = ParamUtil.getString(actionRequest,"number");
		String email = ParamUtil.getString(actionRequest,"email");
		String dob = ParamUtil.getString(actionRequest,"dob");
		String country = ParamUtil.getString(actionRequest,"country");
		String state = ParamUtil.getString(actionRequest,"state");
		String city = ParamUtil.getString(actionRequest,"city");
		
		
		String tosend = name + "#"+ number + "#" + email + "#" +dob + "#" + country + "#" +state + "#" +city ;
		PortletSession session = actionRequest.getPortletSession();

		session.setAttribute("formbowl",tosend, PortletSession.APPLICATION_SCOPE);
		actionResponse.sendRedirect("http://localhost:8080/web/meepay/basic-form-success");
	}

}
