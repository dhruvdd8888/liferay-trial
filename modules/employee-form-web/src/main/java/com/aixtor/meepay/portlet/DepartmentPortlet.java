package com.aixtor.meepay.portlet;



import com.aixtor.meepay.constants.EmployeeFormConstants;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
		"javax.portlet.display-name=Department",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/department/departmentView.jsp",
		"javax.portlet.name=" + EmployeeFormConstants.DEPARTMENT_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DepartmentPortlet extends MVCPortlet {
	
	
	@Reference
	DepartmentLocalService departmentLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<User> userList= UserLocalServiceUtil.getUsers(-1, -1);
		renderRequest.setAttribute(EmployeeFormConstants.USER_LIST,userList);
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		renderRequest.setAttribute(EmployeeFormConstants.DEPARTMENT_LIST, departmentList);

		super.render(renderRequest, renderResponse);

	
		
		
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String Name = ParamUtil.getString(actionRequest, "departmentName");
		String hod = ParamUtil.getString(actionRequest, "hod");
		Department department = departmentLocalService
				.createDepartment(CounterLocalServiceUtil.increment(Department.class.getName()));
//
		department.setName(Name);
		department.setGroupId(themeDisplay.getSiteGroupId());
		department.setCompanyId(themeDisplay.getCompanyId());
		department.setUserId(themeDisplay.getUserId());
		department.setUserName(themeDisplay.getUser().getFullName());
		department.setDepartmentHead(hod);
		departmentLocalService.addDepartment(department);


	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		super.serveResource(resourceRequest, resourceResponse);
	}
}