package com.aixtor.meepay.common.api;

import com.aixtor.meepay.model.Employee;
import com.liferay.portal.kernel.theme.ThemeDisplay;
/**
 * @author dhruv.dhana
 */
public interface AixtorCommonApi {	
	
	public boolean addEmployee(Employee employee, ThemeDisplay themeDisplay, String PortletName);

	public boolean deleteEmployee(long employeeId, ThemeDisplay themeDisplay, String PortletName);		
			
	public boolean updateEmployee(Employee employee, ThemeDisplay themeDisplay, String PortletName);
}