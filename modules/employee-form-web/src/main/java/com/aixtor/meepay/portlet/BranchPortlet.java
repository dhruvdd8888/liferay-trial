
package com.aixtor.meepay.portlet;

import com.aixtor.meepay.constants.EmployeeFormConstants;
import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.City;
import com.aixtor.meepay.model.State;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.CityLocalService;
import com.aixtor.meepay.service.StateLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
		"javax.portlet.display-name=Branch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/branch/branchView.jsp",
		"javax.portlet.name=" + EmployeeFormConstants.BRANCH_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BranchPortlet extends MVCPortlet {
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	StateLocalService stateLocalService;

	@Reference
	CityLocalService cityLocalService;
	
	@Reference
	CountryLocalService countryLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Country> countryList = countryLocalService.getCountries(-1,-1);
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		renderRequest.setAttribute(EmployeeFormConstants.COUNTRIES,countryList);
		renderRequest.setAttribute(EmployeeFormConstants.BRANCH_LIST, branchList);
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
//		accessing values From jsp
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String Name = ParamUtil.getString(actionRequest, EmployeeFormConstants.BRANCH_NAME);
		long country = ParamUtil.getLong(actionRequest, EmployeeFormConstants.COUNTRY);
		long state = ParamUtil.getLong(actionRequest, EmployeeFormConstants.STATE);
		long city = ParamUtil.getLong(actionRequest, EmployeeFormConstants.CITY);
		
//		creating new branch
		Branch branch = branchLocalService
				.createBranch(CounterLocalServiceUtil.increment(Branch.class.getName()));

		branch.setName(Name);
		branch.setCountryId(country);
		branch.setStateId(state);
		branch.setCityId(city);
		branch.setGroupId(themeDisplay.getSiteGroupId());
		branch.setCompanyId(themeDisplay.getCompanyId());
		branch.setUserId(themeDisplay.getUserId());
		branch.setUserName(themeDisplay.getUser().getFullName());
		
//		pushing branch
		branchLocalService.addBranch(branch);
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String requestFrom = ParamUtil.getString(resourceRequest, EmployeeFormConstants.REQUEST_FROM);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
			
			if (requestFrom.equals(EmployeeFormConstants.COUNTRY_DROPDOWN)){
				long country = ParamUtil.getLong(resourceRequest, EmployeeFormConstants.COUNTRY);
				List<State> stateList = stateLocalService.findBycountryId(country);
				responseObj.put(EmployeeFormConstants.STATE_LIST, stateList);

			}else if(requestFrom.equals(EmployeeFormConstants.STATE_DROPDOWN)){
				long state = ParamUtil.getLong(resourceRequest, EmployeeFormConstants.STATE);
				List<City> cityList = cityLocalService.findBystateId(state);
				responseObj.put(EmployeeFormConstants.CITY_LIST, cityList);
			}		
			
			responseObj.put(EmployeeFormConstants.STATUS, EmployeeFormConstants.SUCCESS);
			
		} catch (IOException e) {
			responseObj.put(EmployeeFormConstants.STATUS, EmployeeFormConstants.ERROR);
			responseObj.put(EmployeeFormConstants.ERROR, EmployeeFormConstants.ERROR_MESSAGE);
		} finally {
			writer.write(responseObj.toString());
			writer.close();
		}

		super.serveResource(resourceRequest, resourceResponse);
	}
	
}