package com.aixtor.training.success.portlet;

import com.aixtor.training.success.constants.BasicFormSuccessPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author dhruv.dhana
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BasicFormSuccess",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BasicFormSuccessPortletKeys.BASICFORMSUCCESS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class BasicFormSuccessPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletSession session = renderRequest.getPortletSession();
		String receiveString = (String) session.getAttribute("formbowl", PortletSession.APPLICATION_SCOPE);
		String[] words = receiveString.split("#");
		
		if (words.length >= 7){
			
			String name = words[0];
			String number = words[1];
			String email = words[2];
			String dob = words[3];
			String country = words[4];
			String state = words[5];
			String city = words[6];
			
			renderRequest.setAttribute("name", name);
			renderRequest.setAttribute("number", number);
			renderRequest.setAttribute("email", email);
			renderRequest.setAttribute("dob", dob);
			renderRequest.setAttribute("country", country);
			renderRequest.setAttribute("state", state);
			renderRequest.setAttribute("city", city);

		}
		
		super.render(renderRequest, renderResponse);
	}

}

