package com.aixtor.meepay;

import com.aixtor.meepay.audit.management.model.AuditLogs;
import com.aixtor.meepay.audit.management.service.AuditLogsLocalService;

import com.aixtor.meepay.common.api.AixtorCommonApi;
import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dhruv.dhana
 */
@Component(immediate = true, property = {
}, service = AixtorCommonApi.class)
public class AixtorCommonService implements AixtorCommonApi {
	@Reference
	EmployeeLocalService employeeLocalService;

	@Reference
	AuditLogsLocalService auditLogsLocalService;

	
	@Override
	public boolean addEmployee(Employee employee, ThemeDisplay themeDisplay, String PortletName) {
		try {
			employeeLocalService.addEmployee(employee);
			AuditLogs auditlogs = auditLogsLocalService
					.createAuditLogs(CounterLocalServiceUtil.increment(AuditLogs.class.getName()));
			auditlogs.setAction("Add");
			auditlogs.setCreatedBy(themeDisplay.getUserId());
			auditlogs.setModifiedBy(themeDisplay.getUserId());
			auditlogs.setModuleName(PortletName);
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setGroupId(themeDisplay.getSiteGroupId());
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setUserId(themeDisplay.getUserId());
			auditlogs.setUserName(themeDisplay.getUser().getFullName());
			auditLogsLocalService.addAuditLogs(auditlogs);
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;			
		}
		return true;

	}

	@Override
	public boolean updateEmployee(Employee employee, ThemeDisplay themeDisplay, String PortletName) {
		try{
			employeeLocalService.updateEmployee(employee);
			AuditLogs auditlogs = auditLogsLocalService
			.createAuditLogs(CounterLocalServiceUtil.increment(AuditLogs.class.getName()));
			auditlogs.setAction("Update");
			auditlogs.setCreatedBy(themeDisplay.getUserId());
			auditlogs.setModifiedBy(themeDisplay.getUserId());
			auditlogs.setModuleName(PortletName);
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setGroupId(themeDisplay.getSiteGroupId());
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setUserId(themeDisplay.getUserId());
			auditlogs.setUserName(themeDisplay.getUser().getFullName());
			auditLogsLocalService.addAuditLogs(auditlogs);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	
	@Override
	public boolean deleteEmployee(long employeeId, ThemeDisplay themeDisplay, String PortletName) {
		try {
			employeeLocalService.deleteEmployee(employeeId);
			AuditLogs auditlogs = auditLogsLocalService
					.createAuditLogs(CounterLocalServiceUtil.increment(AuditLogs.class.getName()));
			auditlogs.setAction("Delete");
			auditlogs.setCreatedBy(themeDisplay.getUserId());
			auditlogs.setModifiedBy(themeDisplay.getUserId());
			auditlogs.setModuleName(PortletName);
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setGroupId(themeDisplay.getSiteGroupId());
			auditlogs.setCompanyId(themeDisplay.getCompanyId());
			auditlogs.setUserId(themeDisplay.getUserId());
			auditlogs.setUserName(themeDisplay.getUser().getFullName());
			auditLogsLocalService.addAuditLogs(auditlogs);
		} catch (PortalException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
}