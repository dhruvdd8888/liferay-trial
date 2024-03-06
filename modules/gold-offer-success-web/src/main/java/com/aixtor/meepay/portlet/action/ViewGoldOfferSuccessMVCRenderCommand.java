package com.aixtor.meepay.portlet.action;


import com.aixtor.meepay.constants.GoldOfferSuccessPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;



@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+ GoldOfferSuccessPortletKeys.GOLDOFFERSUCCESS,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ViewGoldOfferSuccessMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		return "";
	}
	
	
}
