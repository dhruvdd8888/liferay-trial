package com.aixtor.meepay.custom.authenticator.portlet.action;


import com.aixtor.meepay.custom.authenticator.constants.CustomAuthenticatorPortletConstants;
import com.aixtor.meepay.custom.authenticator.constants.CustomAuthenticatorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + CustomAuthenticatorPortletKeys.CUSTOM_AUTHENTICATOR,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)
public class ViewCustomAuthenticatorMVCRenderCommand  implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return CustomAuthenticatorPortletConstants.VIEW_JSP;
	}

}
