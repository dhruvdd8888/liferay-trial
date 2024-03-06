package com.aixtor.meepay.portlet;

import com.aixtor.meepay.constants.EmployeeFormConstants;
import com.aixtor.meepay.model.Designation;
import com.aixtor.meepay.service.DesignationLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dhruv.dhana
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Designation",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/designation/designationView.jsp",
		"javax.portlet.name=" +EmployeeFormConstants.DESIGNATION_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DesignationPortlet extends MVCPortlet {
	
	
	@Reference
	DesignationLocalService designationLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		renderRequest.setAttribute(EmployeeFormConstants.DESIGNATION_LIST,designationList);
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		String Name = ParamUtil.getString(actionRequest, EmployeeFormConstants.NAME);
		
		Designation designation = designationLocalService
				.createDesignation(CounterLocalServiceUtil.increment(Designation.class.getName()));

		designation.setName(Name);
		
		
		designationLocalService.addDesignation(designation);

		
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}
}