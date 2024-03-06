package com.aixtor.meepay.portlet.action;


import com.aixtor.meepay.constants.GoldOfferFormConstants;
import com.aixtor.meepay.model.Country;
import com.aixtor.meepay.constants.GoldOfferFormPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GoldOfferFormPortletKeys.GOLD_OFFER_FORM_PORTLET,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)
public class ViewGoldOfferFormMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		renderRequest.setAttribute("countries", Country.COUNTRY_LIST);
		return GoldOfferFormConstants.VIEW_JSP;
	}
	


}
