/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.aixtor.meepay.audit.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditLogsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogsLocalService
 * @generated
 */
public class AuditLogsLocalServiceWrapper
	implements AuditLogsLocalService, ServiceWrapper<AuditLogsLocalService> {

	public AuditLogsLocalServiceWrapper() {
		this(null);
	}

	public AuditLogsLocalServiceWrapper(
		AuditLogsLocalService auditLogsLocalService) {

		_auditLogsLocalService = auditLogsLocalService;
	}

	/**
	 * Adds the audit logs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLogs the audit logs
	 * @return the audit logs that was added
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs addAuditLogs(
		com.aixtor.meepay.audit.management.model.AuditLogs auditLogs) {

		return _auditLogsLocalService.addAuditLogs(auditLogs);
	}

	/**
	 * Creates a new audit logs with the primary key. Does not add the audit logs to the database.
	 *
	 * @param auditLogsId the primary key for the new audit logs
	 * @return the new audit logs
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs createAuditLogs(
		long auditLogsId) {

		return _auditLogsLocalService.createAuditLogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the audit logs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLogs the audit logs
	 * @return the audit logs that was removed
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs deleteAuditLogs(
		com.aixtor.meepay.audit.management.model.AuditLogs auditLogs) {

		return _auditLogsLocalService.deleteAuditLogs(auditLogs);
	}

	/**
	 * Deletes the audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs that was removed
	 * @throws PortalException if a audit logs with the primary key could not be found
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs deleteAuditLogs(
			long auditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.deleteAuditLogs(auditLogsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _auditLogsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _auditLogsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditLogsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _auditLogsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.meepay.audit.management.model.impl.AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _auditLogsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.meepay.audit.management.model.impl.AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _auditLogsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _auditLogsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _auditLogsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs fetchAuditLogs(
		long auditLogsId) {

		return _auditLogsLocalService.fetchAuditLogs(auditLogsId);
	}

	/**
	 * Returns the audit logs matching the UUID and group.
	 *
	 * @param uuid the audit logs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs
		fetchAuditLogsByUuidAndGroupId(String uuid, long groupId) {

		return _auditLogsLocalService.fetchAuditLogsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _auditLogsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the audit logs with the primary key.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs
	 * @throws PortalException if a audit logs with the primary key could not be found
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs getAuditLogs(
			long auditLogsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.getAuditLogs(auditLogsId);
	}

	/**
	 * Returns the audit logs matching the UUID and group.
	 *
	 * @param uuid the audit logs's UUID
	 * @param groupId the primary key of the group
	 * @return the matching audit logs
	 * @throws PortalException if a matching audit logs could not be found
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs
			getAuditLogsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.getAuditLogsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.meepay.audit.management.model.impl.AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of audit logses
	 */
	@Override
	public java.util.List<com.aixtor.meepay.audit.management.model.AuditLogs>
		getAuditLogses(int start, int end) {

		return _auditLogsLocalService.getAuditLogses(start, end);
	}

	/**
	 * Returns all the audit logses matching the UUID and company.
	 *
	 * @param uuid the UUID of the audit logses
	 * @param companyId the primary key of the company
	 * @return the matching audit logses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.meepay.audit.management.model.AuditLogs>
		getAuditLogsesByUuidAndCompanyId(String uuid, long companyId) {

		return _auditLogsLocalService.getAuditLogsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of audit logses matching the UUID and company.
	 *
	 * @param uuid the UUID of the audit logses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching audit logses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.meepay.audit.management.model.AuditLogs>
		getAuditLogsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.aixtor.meepay.audit.management.model.AuditLogs>
					orderByComparator) {

		return _auditLogsLocalService.getAuditLogsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of audit logses.
	 *
	 * @return the number of audit logses
	 */
	@Override
	public int getAuditLogsesCount() {
		return _auditLogsLocalService.getAuditLogsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _auditLogsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _auditLogsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditLogsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _auditLogsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the audit logs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLogs the audit logs
	 * @return the audit logs that was updated
	 */
	@Override
	public com.aixtor.meepay.audit.management.model.AuditLogs updateAuditLogs(
		com.aixtor.meepay.audit.management.model.AuditLogs auditLogs) {

		return _auditLogsLocalService.updateAuditLogs(auditLogs);
	}

	@Override
	public AuditLogsLocalService getWrappedService() {
		return _auditLogsLocalService;
	}

	@Override
	public void setWrappedService(AuditLogsLocalService auditLogsLocalService) {
		_auditLogsLocalService = auditLogsLocalService;
	}

	private AuditLogsLocalService _auditLogsLocalService;

}