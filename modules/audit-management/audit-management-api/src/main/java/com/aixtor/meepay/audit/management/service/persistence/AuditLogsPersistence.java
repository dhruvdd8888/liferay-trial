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

import com.aixtor.meepay.audit.management.exception.NoSuchAuditLogsException;
import com.aixtor.meepay.audit.management.model.AuditLogs;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the audit logs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogsUtil
 * @generated
 */
@ProviderType
public interface AuditLogsPersistence extends BasePersistence<AuditLogs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditLogsUtil} to access the audit logs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching audit logses
	 */
	public java.util.List<AuditLogs> findByUuid(String uuid);

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
	public java.util.List<AuditLogs> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public AuditLogs[] findByUuid_PrevAndNext(
			long auditLogsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Removes all the audit logses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching audit logses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the audit logs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the audit logs that was removed
	 */
	public AuditLogs removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the number of audit logses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching audit logses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching audit logses
	 */
	public java.util.List<AuditLogs> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public AuditLogs[] findByUuid_C_PrevAndNext(
			long auditLogsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Removes all the audit logses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching audit logses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the matching audit logses
	 */
	public java.util.List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByAuditLogId_First(
			long auditLogsId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByAuditLogId_First(
		long auditLogsId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByAuditLogId_Last(
			long auditLogsId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByAuditLogId_Last(
		long auditLogsId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Removes all the audit logses where auditLogsId = &#63; from the database.
	 *
	 * @param auditLogsId the audit logs ID
	 */
	public void removeByGetAuditDataByAuditLogId(long auditLogsId);

	/**
	 * Returns the number of audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the number of matching audit logses
	 */
	public int countByGetAuditDataByAuditLogId(long auditLogsId);

	/**
	 * Returns all the audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching audit logses
	 */
	public java.util.List<AuditLogs> findByGetAuditDataByAction(String action);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByAction_First(
			String action,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByAction_First(
		String action,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByAction_Last(
			String action,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByAction_Last(
		String action,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where action = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public AuditLogs[] findByGetAuditDataByAction_PrevAndNext(
			long auditLogsId, String action,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Removes all the audit logses where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	public void removeByGetAuditDataByAction(String action);

	/**
	 * Returns the number of audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching audit logses
	 */
	public int countByGetAuditDataByAction(String action);

	/**
	 * Returns all the audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching audit logses
	 */
	public java.util.List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName);

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
	public java.util.List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end);

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
	public java.util.List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByModuleName_First(
			String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByModuleName_First(
		String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	public AuditLogs findByGetAuditDataByModuleName_Last(
			String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	public AuditLogs fetchByGetAuditDataByModuleName_Last(
		String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

	/**
	 * Returns the audit logses before and after the current audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param auditLogsId the primary key of the current audit logs
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public AuditLogs[] findByGetAuditDataByModuleName_PrevAndNext(
			long auditLogsId, String moduleName,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
				orderByComparator)
		throws NoSuchAuditLogsException;

	/**
	 * Removes all the audit logses where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 */
	public void removeByGetAuditDataByModuleName(String moduleName);

	/**
	 * Returns the number of audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching audit logses
	 */
	public int countByGetAuditDataByModuleName(String moduleName);

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	public void cacheResult(AuditLogs auditLogs);

	/**
	 * Caches the audit logses in the entity cache if it is enabled.
	 *
	 * @param auditLogses the audit logses
	 */
	public void cacheResult(java.util.List<AuditLogs> auditLogses);

	/**
	 * Creates a new audit logs with the primary key. Does not add the audit logs to the database.
	 *
	 * @param auditLogsId the primary key for the new audit logs
	 * @return the new audit logs
	 */
	public AuditLogs create(long auditLogsId);

	/**
	 * Removes the audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs that was removed
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public AuditLogs remove(long auditLogsId) throws NoSuchAuditLogsException;

	public AuditLogs updateImpl(AuditLogs auditLogs);

	/**
	 * Returns the audit logs with the primary key or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	public AuditLogs findByPrimaryKey(long auditLogsId)
		throws NoSuchAuditLogsException;

	/**
	 * Returns the audit logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs, or <code>null</code> if a audit logs with the primary key could not be found
	 */
	public AuditLogs fetchByPrimaryKey(long auditLogsId);

	/**
	 * Returns all the audit logses.
	 *
	 * @return the audit logses
	 */
	public java.util.List<AuditLogs> findAll();

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
	public java.util.List<AuditLogs> findAll(int start, int end);

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
	public java.util.List<AuditLogs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator);

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
	public java.util.List<AuditLogs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLogs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the audit logses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of audit logses.
	 *
	 * @return the number of audit logses
	 */
	public int countAll();

}