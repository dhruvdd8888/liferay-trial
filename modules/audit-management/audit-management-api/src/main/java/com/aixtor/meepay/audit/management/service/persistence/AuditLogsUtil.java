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

package com.aixtor.meepay.audit.management.service.persistence;

import com.aixtor.meepay.audit.management.model.AuditLogs;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the audit logs service. This utility wraps <code>com.aixtor.meepay.audit.management.service.persistence.impl.AuditLogsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogsPersistence
 * @generated
 */
public class AuditLogsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AuditLogs auditLogs) {
		getPersistence().clearCache(auditLogs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AuditLogs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuditLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditLogs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AuditLogs update(AuditLogs auditLogs) {
		return getPersistence().update(auditLogs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AuditLogs update(
		AuditLogs auditLogs, ServiceContext serviceContext) {

		return getPersistence().update(auditLogs, serviceContext);
	}

	/**
	 * Returns all the audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching audit logses
	 */
	public static List<AuditLogs> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the audit logses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByUuid_First(
			String uuid, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUuid_First(
		String uuid, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByUuid_Last(
			String uuid, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUuid_Last(
		String uuid, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs[] findByUuid_PrevAndNext(
			long auditLogsId, String uuid,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_PrevAndNext(
			auditLogsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the audit logses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching audit logses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByUUID_G(String uuid, long groupId)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the audit logs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the audit logs that was removed
	 */
	public static AuditLogs removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of audit logses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching audit logses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching audit logses
	 */
	public static List<AuditLogs> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs[] findByUuid_C_PrevAndNext(
			long auditLogsId, String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			auditLogsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the audit logses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching audit logses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId) {

		return getPersistence().findByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns a range of all the audit logses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses where auditLogsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param auditLogsId the audit logs ID
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByAuditLogId(
			auditLogsId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByAuditLogId_First(
			long auditLogsId, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByAuditLogId_First(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByAuditLogId_First(
		long auditLogsId, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAuditLogId_First(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByAuditLogId_Last(
			long auditLogsId, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByAuditLogId_Last(
			auditLogsId, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByAuditLogId_Last(
		long auditLogsId, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAuditLogId_Last(
			auditLogsId, orderByComparator);
	}

	/**
	 * Removes all the audit logses where auditLogsId = &#63; from the database.
	 *
	 * @param auditLogsId the audit logs ID
	 */
	public static void removeByGetAuditDataByAuditLogId(long auditLogsId) {
		getPersistence().removeByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns the number of audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the number of matching audit logses
	 */
	public static int countByGetAuditDataByAuditLogId(long auditLogsId) {
		return getPersistence().countByGetAuditDataByAuditLogId(auditLogsId);
	}

	/**
	 * Returns all the audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAction(String action) {
		return getPersistence().findByGetAuditDataByAction(action);
	}

	/**
	 * Returns a range of all the audit logses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end) {

		return getPersistence().findByGetAuditDataByAction(action, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByAction(
			action, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses where action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param action the action
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByAction(
			action, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByAction_First(
			String action, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByAction_First(
			action, orderByComparator);
	}

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByAction_First(
		String action, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAction_First(
			action, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByAction_Last(
			String action, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByAction_Last(
			action, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByAction_Last(
		String action, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByAction_Last(
			action, orderByComparator);
	}

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where action = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs[] findByGetAuditDataByAction_PrevAndNext(
			long auditLogsId, String action,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByAction_PrevAndNext(
			auditLogsId, action, orderByComparator);
	}

	/**
	 * Removes all the audit logses where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	public static void removeByGetAuditDataByAction(String action) {
		getPersistence().removeByGetAuditDataByAction(action);
	}

	/**
	 * Returns the number of audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching audit logses
	 */
	public static int countByGetAuditDataByAction(String action) {
		return getPersistence().countByGetAuditDataByAction(action);
	}

	/**
	 * Returns all the audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName) {

		return getPersistence().findByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Returns a range of all the audit logses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logses
	 */
	public static List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetAuditDataByModuleName(
			moduleName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByModuleName_First(
			String moduleName, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByModuleName_First(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByModuleName_First(
		String moduleName, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByModuleName_First(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public static AuditLogs findByGetAuditDataByModuleName_Last(
			String moduleName, OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByModuleName_Last(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public static AuditLogs fetchByGetAuditDataByModuleName_Last(
		String moduleName, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().fetchByGetAuditDataByModuleName_Last(
			moduleName, orderByComparator);
	}

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs[] findByGetAuditDataByModuleName_PrevAndNext(
			long auditLogsId, String moduleName,
			OrderByComparator<AuditLogs> orderByComparator)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByGetAuditDataByModuleName_PrevAndNext(
			auditLogsId, moduleName, orderByComparator);
	}

	/**
	 * Removes all the audit logses where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 */
	public static void removeByGetAuditDataByModuleName(String moduleName) {
		getPersistence().removeByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Returns the number of audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching audit logses
	 */
	public static int countByGetAuditDataByModuleName(String moduleName) {
		return getPersistence().countByGetAuditDataByModuleName(moduleName);
	}

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	public static void cacheResult(AuditLogs auditLogs) {
		getPersistence().cacheResult(auditLogs);
	}

	/**
	 * Caches the audit logses in the entity cache if it is enabled.
	 *
	 * @param auditLogses the audit logses
	 */
	public static void cacheResult(List<AuditLogs> auditLogses) {
		getPersistence().cacheResult(auditLogses);
	}

	/**
	 * Creates a new audit logs with the primary key. Does not add the audit logs to the database.
	 *
	 * @param auditLogsId the primary key for the new audit logs
	 * @return the new audit logs
	 */
	public static AuditLogs create(long auditLogsId) {
		return getPersistence().create(auditLogsId);
	}

	/**
	 * Removes the audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs that was removed
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs remove(long auditLogsId)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().remove(auditLogsId);
	}

	public static AuditLogs updateImpl(AuditLogs auditLogs) {
		return getPersistence().updateImpl(auditLogs);
	}

	/**
	 * Returns the audit logs with the primary key or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public static AuditLogs findByPrimaryKey(long auditLogsId)
		throws com.aixtor.meepay.audit.management.exception.
			NoSuchAuditLogsException {

		return getPersistence().findByPrimaryKey(auditLogsId);
	}

	/**
	 * Returns the audit logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs, or <code>null</code> if a audit logs with the primary key could not be found
	 */
	public static AuditLogs fetchByPrimaryKey(long auditLogsId) {
		return getPersistence().fetchByPrimaryKey(auditLogsId);
	}

	/**
	 * Returns all the audit logses.
	 *
	 * @return the audit logses
	 */
	public static List<AuditLogs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @return the range of audit logses
	 */
	public static List<AuditLogs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit logses
	 */
	public static List<AuditLogs> findAll(
		int start, int end, OrderByComparator<AuditLogs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logses
	 * @param end the upper bound of the range of audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of audit logses
	 */
	public static List<AuditLogs> findAll(
		int start, int end, OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the audit logses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of audit logses.
	 *
	 * @return the number of audit logses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditLogsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AuditLogsPersistence _persistence;

}