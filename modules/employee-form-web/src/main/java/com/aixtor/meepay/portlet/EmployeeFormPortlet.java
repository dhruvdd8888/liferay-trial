package com.aixtor.meepay.portlet;

import com.aixtor.meepay.constants.EmployeeFormConstants;
import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.model.Designation;
import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.model.EmployeeModel;
import com.aixtor.meepay.models.EmployeeList;
import com.aixtor.meepay.models.EmployeeWebModel;
import com.aixtor.meepay.service.BranchLocalService;
import com.aixtor.meepay.service.DepartmentLocalService;
import com.aixtor.meepay.service.DesignationLocalService;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.aixtor.meepay.service.persistence.EmployeeFinder;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.OldServiceComponentException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.omg.CORBA.COMM_FAILURE;
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
		"javax.portlet.display-name=EmployeeForm",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/employee/employeeView.jsp",
		"javax.portlet.name=" + EmployeeFormConstants.EMPLOYEE_FORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeeFormPortlet extends MVCPortlet {
	@Reference
	DepartmentLocalService departmentLocalService;
	@Reference
	BranchLocalService branchLocalService;
	@Reference
	DesignationLocalService designationLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;
	
	@Reference
	EmployeeFinder employeeFinder;

	public static List<Branch> branchList ;
	public static List<Department> departmentList;
	public static List<Designation> designationList;
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String commandValue = ParamUtil.getString(renderRequest,"command","");
		
		
		if (commandValue.equals("updateEmployee")) {
			long employeeId = ParamUtil.getLong(renderRequest, "employeeId");

			Employee employee = null;
			try {
				employee = employeeLocalService.getEmployee(employeeId);
			} catch (PortalException e) { e.printStackTrace(); }
			EmployeeWebModel employeeWebModel = new EmployeeWebModel(employee);
			renderRequest.setAttribute("employeePrefill", employeeWebModel);
			
		}
		
		branchList = branchLocalService.getBranches(-1, -1);
		departmentList = departmentLocalService.getDepartments(-1, -1);
		designationList = designationLocalService.getDesignations(-1, -1);
		new EmployeeList(branchList,departmentList,designationList);
		renderRequest.setAttribute(EmployeeFormConstants.DEPARTMENT_LIST,
				departmentList);
		renderRequest.setAttribute(EmployeeFormConstants.BRANCH_LIST,
				branchList);
		renderRequest.setAttribute(EmployeeFormConstants.DESIGNATION_LIST,
				designationList);
		
//		accessing dates
		String startDateString = ParamUtil.getString(renderRequest, EmployeeFormConstants.START_DATE);
		String endDateString = ParamUtil.getString(renderRequest, EmployeeFormConstants.END_DATE);
		String keyWord = ParamUtil.getString(renderRequest, EmployeeFormConstants.KEYWORD);

		if (!keyWord.equals(StringPool.BLANK)) {
			List<Object> resultObjList = employeeLocalService.findByEmployeeContents(StringPool.PERCENT + keyWord + StringPool.PERCENT);
			List<EmployeeWebModel> filteredList = new ArrayList<EmployeeWebModel>();
	        for(int i = 0;i < resultObjList.size(); i++) {
	        	EmployeeWebModel employeeWebModel = new EmployeeWebModel(resultObjList.get(i));
	        	filteredList.add(employeeWebModel);
	        }
	        renderRequest.setAttribute(EmployeeFormConstants.EMPLOYEE_LIST,
					filteredList);
					
		}
//		validating dates are not empty
		else if (!(endDateString.equals(StringPool.BLANK)) && !(startDateString.equals(StringPool.BLANK))) {
			
//			typecasting dates to sql supported format
	        SimpleDateFormat dateFormat = new SimpleDateFormat(EmployeeFormConstants.DATE_FORMAT);
	        Date startDate = null;
	        Date endDate = null;
	        try {
	        	
	        	startDate = dateFormat.parse(startDateString+ EmployeeFormConstants.DATE_ZEROES);
	        	endDate = dateFormat.parse(endDateString+ EmployeeFormConstants.DATE_ZEROES);
	        }
	        catch (Exception e) {}
	        
//	        creating query
	    	DynamicQuery dynamicQuery = employeeLocalService.dynamicQuery();
			dynamicQuery.add(RestrictionsFactoryUtil.between(EmployeeFormConstants.CREATE_DATE, startDate, endDate));
			List<Employee> employeeList = employeeLocalService.dynamicQuery(dynamicQuery);
			List<EmployeeWebModel> filteredList = new ArrayList<EmployeeWebModel>();
			for(Employee employee:employeeList) {
	        	EmployeeWebModel employeeWebModel = new EmployeeWebModel(employee);
	        	filteredList.add(employeeWebModel);				
			}
			
			
			renderRequest.setAttribute(EmployeeFormConstants.EMPLOYEE_LIST,
					filteredList);
			
		}
		else {
			List<Employee> employeeList = employeeLocalService.getEmployees(-1, -1);
			List<EmployeeWebModel> filteredList = new ArrayList<EmployeeWebModel>();
			
			for(Employee employee:employeeList) {
				EmployeeWebModel employeeWebModel = new EmployeeWebModel(employee);
	        	filteredList.add(employeeWebModel);				
			}
			renderRequest.setAttribute(EmployeeFormConstants.EMPLOYEE_LIST,
					filteredList);
		}
		renderRequest.setAttribute(EmployeeFormConstants.STORED_KEYWORD, keyWord);
		renderRequest.setAttribute(EmployeeFormConstants.STORED_START_DATE, startDateString);
		renderRequest.setAttribute(EmployeeFormConstants.STORED_END_DATE, endDateString);
		super.render(renderRequest, renderResponse);
		
	}
	

	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		

		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");

		employeeLocalService.deleteEmployee(employeeId);

		
	}
	public void editEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		long employeeId = ParamUtil.getLong(actionRequest,"employeeId");
		Employee employee = employeeLocalService.getEmployee(employeeId);
		employee.setFirstName(ParamUtil.getString(actionRequest, EmployeeFormConstants.FIRST_NAME));
		employee.setLastName(ParamUtil.getString(actionRequest, EmployeeFormConstants.LAST_NAME));
		employee.setEmail(ParamUtil.getString(actionRequest, EmployeeFormConstants.EMAIL));
		employee.setMobileNumber(ParamUtil.getLong(actionRequest, EmployeeFormConstants.MOBILE));
		employee.setDepartmentId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.DEPARTMENT));
		employee.setBranchId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.BRANCH));
		employee.setDesignationId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.DESIGNATION));
		employee.setAddress(ParamUtil.getString(actionRequest, EmployeeFormConstants.ADDRESS));
		employeeLocalService.updateEmployee(employee);
	}
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		Employee employee = employeeLocalService.createEmployee(
				CounterLocalServiceUtil.increment(Employee.class.getName()));
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		employee.setFirstName(ParamUtil.getString(actionRequest, EmployeeFormConstants.FIRST_NAME));
		employee.setLastName(ParamUtil.getString(actionRequest, EmployeeFormConstants.LAST_NAME));
		employee.setEmail(ParamUtil.getString(actionRequest, EmployeeFormConstants.EMAIL));
		employee.setMobileNumber(ParamUtil.getLong(actionRequest, EmployeeFormConstants.MOBILE));
		employee.setDepartmentId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.DEPARTMENT));
		employee.setBranchId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.BRANCH));
		employee.setDesignationId(ParamUtil.getLong(actionRequest, EmployeeFormConstants.DESIGNATION));
		employee.setAddress(ParamUtil.getString(actionRequest, EmployeeFormConstants.ADDRESS));
		
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setGroupId(themeDisplay.getSiteGroupId());
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setUserId(themeDisplay.getUserId());
		employee.setUserName(themeDisplay.getUser().getFullName());
		employeeLocalService.addEmployee(employee);
		
	}

	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}
}