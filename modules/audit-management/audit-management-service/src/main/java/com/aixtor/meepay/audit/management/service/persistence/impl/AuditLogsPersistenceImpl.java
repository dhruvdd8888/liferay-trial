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

package com.aixtor.meepay.audit.management.service.persistence.impl;

import com.aixtor.meepay.audit.management.exception.NoSuchAuditLogsException;
import com.aixtor.meepay.audit.management.model.AuditLogs;
import com.aixtor.meepay.audit.management.model.AuditLogsTable;
import com.aixtor.meepay.audit.management.model.impl.AuditLogsImpl;
import com.aixtor.meepay.audit.management.model.impl.AuditLogsModelImpl;
import com.aixtor.meepay.audit.management.service.persistence.AuditLogsPersistence;
import com.aixtor.meepay.audit.management.service.persistence.AuditLogsUtil;
import com.aixtor.meepay.audit.management.service.persistence.impl.constants.EmployeePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the audit logs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AuditLogsPersistence.class, BasePersistence.class})
public class AuditLogsPersistenceImpl
	extends BasePersistenceImpl<AuditLogs> implements AuditLogsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditLogsUtil</code> to access the audit logs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditLogsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching audit logses
	 */
	@Override
	public List<AuditLogs> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLogs auditLogs : list) {
					if (!uuid.equals(auditLogs.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByUuid_First(
			String uuid, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByUuid_First(uuid, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUuid_First(
		String uuid, OrderByComparator<AuditLogs> orderByComparator) {

		List<AuditLogs> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByUuid_Last(
			String uuid, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByUuid_Last(uuid, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUuid_Last(
		String uuid, OrderByComparator<AuditLogs> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AuditLogs> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AuditLogs[] findByUuid_PrevAndNext(
			long auditLogsId, String uuid,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		uuid = Objects.toString(uuid, "");

		AuditLogs auditLogs = findByPrimaryKey(auditLogsId);

		Session session = null;

		try {
			session = openSession();

			AuditLogs[] array = new AuditLogsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, auditLogs, uuid, orderByComparator, true);

			array[1] = auditLogs;

			array[2] = getByUuid_PrevAndNext(
				session, auditLogs, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditLogs getByUuid_PrevAndNext(
		Session session, AuditLogs auditLogs, String uuid,
		OrderByComparator<AuditLogs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditLogs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditLogs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit logses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AuditLogs auditLogs :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"auditLogs.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(auditLogs.uuid IS NULL OR auditLogs.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByUUID_G(uuid, groupId);

		if (auditLogs == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuditLogsException(sb.toString());
		}

		return auditLogs;
	}

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof AuditLogs) {
			AuditLogs auditLogs = (AuditLogs)result;

			if (!Objects.equals(uuid, auditLogs.getUuid()) ||
				(groupId != auditLogs.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<AuditLogs> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AuditLogs auditLogs = list.get(0);

					result = auditLogs;

					cacheResult(auditLogs);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AuditLogs)result;
		}
	}

	/**
	 * Removes the audit logs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the audit logs that was removed
	 */
	@Override
	public AuditLogs removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = findByUUID_G(uuid, groupId);

		return remove(auditLogs);
	}

	/**
	 * Returns the number of audit logses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"auditLogs.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(auditLogs.uuid IS NULL OR auditLogs.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"auditLogs.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching audit logses
	 */
	@Override
	public List<AuditLogs> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLogs auditLogs : list) {
					if (!uuid.equals(auditLogs.getUuid()) ||
						(companyId != auditLogs.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AuditLogs findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the first audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AuditLogs> orderByComparator) {

		List<AuditLogs> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AuditLogs findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the last audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AuditLogs> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AuditLogs> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AuditLogs[] findByUuid_C_PrevAndNext(
			long auditLogsId, String uuid, long companyId,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		uuid = Objects.toString(uuid, "");

		AuditLogs auditLogs = findByPrimaryKey(auditLogsId);

		Session session = null;

		try {
			session = openSession();

			AuditLogs[] array = new AuditLogsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, auditLogs, uuid, companyId, orderByComparator, true);

			array[1] = auditLogs;

			array[2] = getByUuid_C_PrevAndNext(
				session, auditLogs, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditLogs getByUuid_C_PrevAndNext(
		Session session, AuditLogs auditLogs, String uuid, long companyId,
		OrderByComparator<AuditLogs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditLogs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditLogs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit logses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AuditLogs auditLogs :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"auditLogs.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(auditLogs.uuid IS NULL OR auditLogs.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"auditLogs.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGetAuditDataByAuditLogId;
	private FinderPath
		_finderPathWithoutPaginationFindByGetAuditDataByAuditLogId;
	private FinderPath _finderPathCountByGetAuditDataByAuditLogId;

	/**
	 * Returns all the audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the matching audit logses
	 */
	@Override
	public List<AuditLogs> findByGetAuditDataByAuditLogId(long auditLogsId) {
		return findByGetAuditDataByAuditLogId(
			auditLogsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end) {

		return findByGetAuditDataByAuditLogId(auditLogsId, start, end, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return findByGetAuditDataByAuditLogId(
			auditLogsId, start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAuditLogId(
		long auditLogsId, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGetAuditDataByAuditLogId;
				finderArgs = new Object[] {auditLogsId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGetAuditDataByAuditLogId;
			finderArgs = new Object[] {
				auditLogsId, start, end, orderByComparator
			};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLogs auditLogs : list) {
					if (auditLogsId != auditLogs.getAuditLogsId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			sb.append(_FINDER_COLUMN_GETAUDITDATABYAUDITLOGID_AUDITLOGSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(auditLogsId);

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByAuditLogId_First(
			long auditLogsId, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByAuditLogId_First(
			auditLogsId, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("auditLogsId=");
		sb.append(auditLogsId);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the first audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByAuditLogId_First(
		long auditLogsId, OrderByComparator<AuditLogs> orderByComparator) {

		List<AuditLogs> list = findByGetAuditDataByAuditLogId(
			auditLogsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByAuditLogId_Last(
			long auditLogsId, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByAuditLogId_Last(
			auditLogsId, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("auditLogsId=");
		sb.append(auditLogsId);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the last audit logs in the ordered set where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByAuditLogId_Last(
		long auditLogsId, OrderByComparator<AuditLogs> orderByComparator) {

		int count = countByGetAuditDataByAuditLogId(auditLogsId);

		if (count == 0) {
			return null;
		}

		List<AuditLogs> list = findByGetAuditDataByAuditLogId(
			auditLogsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the audit logses where auditLogsId = &#63; from the database.
	 *
	 * @param auditLogsId the audit logs ID
	 */
	@Override
	public void removeByGetAuditDataByAuditLogId(long auditLogsId) {
		for (AuditLogs auditLogs :
				findByGetAuditDataByAuditLogId(
					auditLogsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses where auditLogsId = &#63;.
	 *
	 * @param auditLogsId the audit logs ID
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByGetAuditDataByAuditLogId(long auditLogsId) {
		FinderPath finderPath = _finderPathCountByGetAuditDataByAuditLogId;

		Object[] finderArgs = new Object[] {auditLogsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			sb.append(_FINDER_COLUMN_GETAUDITDATABYAUDITLOGID_AUDITLOGSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(auditLogsId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GETAUDITDATABYAUDITLOGID_AUDITLOGSID_2 =
			"auditLogs.auditLogsId = ?";

	private FinderPath _finderPathWithPaginationFindByGetAuditDataByAction;
	private FinderPath _finderPathWithoutPaginationFindByGetAuditDataByAction;
	private FinderPath _finderPathCountByGetAuditDataByAction;

	/**
	 * Returns all the audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the matching audit logses
	 */
	@Override
	public List<AuditLogs> findByGetAuditDataByAction(String action) {
		return findByGetAuditDataByAction(
			action, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end) {

		return findByGetAuditDataByAction(action, start, end, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return findByGetAuditDataByAction(
			action, start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByAction(
		String action, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		action = Objects.toString(action, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGetAuditDataByAction;
				finderArgs = new Object[] {action};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGetAuditDataByAction;
			finderArgs = new Object[] {action, start, end, orderByComparator};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLogs auditLogs : list) {
					if (!action.equals(auditLogs.getAction())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			boolean bindAction = false;

			if (action.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_3);
			}
			else {
				bindAction = true;

				sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAction) {
					queryPos.add(action);
				}

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByAction_First(
			String action, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByAction_First(
			action, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("action=");
		sb.append(action);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the first audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByAction_First(
		String action, OrderByComparator<AuditLogs> orderByComparator) {

		List<AuditLogs> list = findByGetAuditDataByAction(
			action, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByAction_Last(
			String action, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByAction_Last(
			action, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("action=");
		sb.append(action);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the last audit logs in the ordered set where action = &#63;.
	 *
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByAction_Last(
		String action, OrderByComparator<AuditLogs> orderByComparator) {

		int count = countByGetAuditDataByAction(action);

		if (count == 0) {
			return null;
		}

		List<AuditLogs> list = findByGetAuditDataByAction(
			action, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AuditLogs[] findByGetAuditDataByAction_PrevAndNext(
			long auditLogsId, String action,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		action = Objects.toString(action, "");

		AuditLogs auditLogs = findByPrimaryKey(auditLogsId);

		Session session = null;

		try {
			session = openSession();

			AuditLogs[] array = new AuditLogsImpl[3];

			array[0] = getByGetAuditDataByAction_PrevAndNext(
				session, auditLogs, action, orderByComparator, true);

			array[1] = auditLogs;

			array[2] = getByGetAuditDataByAction_PrevAndNext(
				session, auditLogs, action, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditLogs getByGetAuditDataByAction_PrevAndNext(
		Session session, AuditLogs auditLogs, String action,
		OrderByComparator<AuditLogs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

		boolean bindAction = false;

		if (action.isEmpty()) {
			sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_3);
		}
		else {
			bindAction = true;

			sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAction) {
			queryPos.add(action);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditLogs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditLogs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit logses where action = &#63; from the database.
	 *
	 * @param action the action
	 */
	@Override
	public void removeByGetAuditDataByAction(String action) {
		for (AuditLogs auditLogs :
				findByGetAuditDataByAction(
					action, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses where action = &#63;.
	 *
	 * @param action the action
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByGetAuditDataByAction(String action) {
		action = Objects.toString(action, "");

		FinderPath finderPath = _finderPathCountByGetAuditDataByAction;

		Object[] finderArgs = new Object[] {action};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			boolean bindAction = false;

			if (action.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_3);
			}
			else {
				bindAction = true;

				sb.append(_FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAction) {
					queryPos.add(action);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_2 =
		"auditLogs.action = ?";

	private static final String _FINDER_COLUMN_GETAUDITDATABYACTION_ACTION_3 =
		"(auditLogs.action IS NULL OR auditLogs.action = '')";

	private FinderPath _finderPathWithPaginationFindByGetAuditDataByModuleName;
	private FinderPath
		_finderPathWithoutPaginationFindByGetAuditDataByModuleName;
	private FinderPath _finderPathCountByGetAuditDataByModuleName;

	/**
	 * Returns all the audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching audit logses
	 */
	@Override
	public List<AuditLogs> findByGetAuditDataByModuleName(String moduleName) {
		return findByGetAuditDataByModuleName(
			moduleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end) {

		return findByGetAuditDataByModuleName(moduleName, start, end, null);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator) {

		return findByGetAuditDataByModuleName(
			moduleName, start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findByGetAuditDataByModuleName(
		String moduleName, int start, int end,
		OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		moduleName = Objects.toString(moduleName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGetAuditDataByModuleName;
				finderArgs = new Object[] {moduleName};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGetAuditDataByModuleName;
			finderArgs = new Object[] {
				moduleName, start, end, orderByComparator
			};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLogs auditLogs : list) {
					if (!moduleName.equals(auditLogs.getModuleName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

			boolean bindModuleName = false;

			if (moduleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModuleName) {
					queryPos.add(moduleName);
				}

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByModuleName_First(
			String moduleName, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByModuleName_First(
			moduleName, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("moduleName=");
		sb.append(moduleName);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the first audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByModuleName_First(
		String moduleName, OrderByComparator<AuditLogs> orderByComparator) {

		List<AuditLogs> list = findByGetAuditDataByModuleName(
			moduleName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs
	 * @throws NoSuchAuditLogsException if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs findByGetAuditDataByModuleName_Last(
			String moduleName, OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByGetAuditDataByModuleName_Last(
			moduleName, orderByComparator);

		if (auditLogs != null) {
			return auditLogs;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("moduleName=");
		sb.append(moduleName);

		sb.append("}");

		throw new NoSuchAuditLogsException(sb.toString());
	}

	/**
	 * Returns the last audit logs in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit logs, or <code>null</code> if a matching audit logs could not be found
	 */
	@Override
	public AuditLogs fetchByGetAuditDataByModuleName_Last(
		String moduleName, OrderByComparator<AuditLogs> orderByComparator) {

		int count = countByGetAuditDataByModuleName(moduleName);

		if (count == 0) {
			return null;
		}

		List<AuditLogs> list = findByGetAuditDataByModuleName(
			moduleName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AuditLogs[] findByGetAuditDataByModuleName_PrevAndNext(
			long auditLogsId, String moduleName,
			OrderByComparator<AuditLogs> orderByComparator)
		throws NoSuchAuditLogsException {

		moduleName = Objects.toString(moduleName, "");

		AuditLogs auditLogs = findByPrimaryKey(auditLogsId);

		Session session = null;

		try {
			session = openSession();

			AuditLogs[] array = new AuditLogsImpl[3];

			array[0] = getByGetAuditDataByModuleName_PrevAndNext(
				session, auditLogs, moduleName, orderByComparator, true);

			array[1] = auditLogs;

			array[2] = getByGetAuditDataByModuleName_PrevAndNext(
				session, auditLogs, moduleName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditLogs getByGetAuditDataByModuleName_PrevAndNext(
		Session session, AuditLogs auditLogs, String moduleName,
		OrderByComparator<AuditLogs> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITLOGS_WHERE);

		boolean bindModuleName = false;

		if (moduleName.isEmpty()) {
			sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_3);
		}
		else {
			bindModuleName = true;

			sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditLogsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindModuleName) {
			queryPos.add(moduleName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditLogs)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditLogs> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit logses where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 */
	@Override
	public void removeByGetAuditDataByModuleName(String moduleName) {
		for (AuditLogs auditLogs :
				findByGetAuditDataByModuleName(
					moduleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching audit logses
	 */
	@Override
	public int countByGetAuditDataByModuleName(String moduleName) {
		moduleName = Objects.toString(moduleName, "");

		FinderPath finderPath = _finderPathCountByGetAuditDataByModuleName;

		Object[] finderArgs = new Object[] {moduleName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITLOGS_WHERE);

			boolean bindModuleName = false;

			if (moduleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				sb.append(_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModuleName) {
					queryPos.add(moduleName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_2 =
			"auditLogs.moduleName = ?";

	private static final String
		_FINDER_COLUMN_GETAUDITDATABYMODULENAME_MODULENAME_3 =
			"(auditLogs.moduleName IS NULL OR auditLogs.moduleName = '')";

	public AuditLogsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AuditLogs.class);

		setModelImplClass(AuditLogsImpl.class);
		setModelPKClass(long.class);

		setTable(AuditLogsTable.INSTANCE);
	}

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	@Override
	public void cacheResult(AuditLogs auditLogs) {
		entityCache.putResult(
			AuditLogsImpl.class, auditLogs.getPrimaryKey(), auditLogs);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {auditLogs.getUuid(), auditLogs.getGroupId()},
			auditLogs);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the audit logses in the entity cache if it is enabled.
	 *
	 * @param auditLogses the audit logses
	 */
	@Override
	public void cacheResult(List<AuditLogs> auditLogses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (auditLogses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AuditLogs auditLogs : auditLogses) {
			if (entityCache.getResult(
					AuditLogsImpl.class, auditLogs.getPrimaryKey()) == null) {

				cacheResult(auditLogs);
			}
		}
	}

	/**
	 * Clears the cache for all audit logses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditLogsImpl.class);

		finderCache.clearCache(AuditLogsImpl.class);
	}

	/**
	 * Clears the cache for the audit logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditLogs auditLogs) {
		entityCache.removeResult(AuditLogsImpl.class, auditLogs);
	}

	@Override
	public void clearCache(List<AuditLogs> auditLogses) {
		for (AuditLogs auditLogs : auditLogses) {
			entityCache.removeResult(AuditLogsImpl.class, auditLogs);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuditLogsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuditLogsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AuditLogsModelImpl auditLogsModelImpl) {

		Object[] args = new Object[] {
			auditLogsModelImpl.getUuid(), auditLogsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, auditLogsModelImpl);
	}

	/**
	 * Creates a new audit logs with the primary key. Does not add the audit logs to the database.
	 *
	 * @param auditLogsId the primary key for the new audit logs
	 * @return the new audit logs
	 */
	@Override
	public AuditLogs create(long auditLogsId) {
		AuditLogs auditLogs = new AuditLogsImpl();

		auditLogs.setNew(true);
		auditLogs.setPrimaryKey(auditLogsId);

		String uuid = _portalUUID.generate();

		auditLogs.setUuid(uuid);

		auditLogs.setCompanyId(CompanyThreadLocal.getCompanyId());

		return auditLogs;
	}

	/**
	 * Removes the audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs that was removed
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	@Override
	public AuditLogs remove(long auditLogsId) throws NoSuchAuditLogsException {
		return remove((Serializable)auditLogsId);
	}

	/**
	 * Removes the audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audit logs
	 * @return the audit logs that was removed
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	@Override
	public AuditLogs remove(Serializable primaryKey)
		throws NoSuchAuditLogsException {

		Session session = null;

		try {
			session = openSession();

			AuditLogs auditLogs = (AuditLogs)session.get(
				AuditLogsImpl.class, primaryKey);

			if (auditLogs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditLogsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditLogs);
		}
		catch (NoSuchAuditLogsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AuditLogs removeImpl(AuditLogs auditLogs) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditLogs)) {
				auditLogs = (AuditLogs)session.get(
					AuditLogsImpl.class, auditLogs.getPrimaryKeyObj());
			}

			if (auditLogs != null) {
				session.delete(auditLogs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auditLogs != null) {
			clearCache(auditLogs);
		}

		return auditLogs;
	}

	@Override
	public AuditLogs updateImpl(AuditLogs auditLogs) {
		boolean isNew = auditLogs.isNew();

		if (!(auditLogs instanceof AuditLogsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(auditLogs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(auditLogs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in auditLogs proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AuditLogs implementation " +
					auditLogs.getClass());
		}

		AuditLogsModelImpl auditLogsModelImpl = (AuditLogsModelImpl)auditLogs;

		if (Validator.isNull(auditLogs.getUuid())) {
			String uuid = _portalUUID.generate();

			auditLogs.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (auditLogs.getCreateDate() == null)) {
			if (serviceContext == null) {
				auditLogs.setCreateDate(date);
			}
			else {
				auditLogs.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!auditLogsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				auditLogs.setModifiedDate(date);
			}
			else {
				auditLogs.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auditLogs);
			}
			else {
				auditLogs = (AuditLogs)session.merge(auditLogs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AuditLogsImpl.class, auditLogsModelImpl, false, true);

		cacheUniqueFindersCache(auditLogsModelImpl);

		if (isNew) {
			auditLogs.setNew(false);
		}

		auditLogs.resetOriginalValues();

		return auditLogs;
	}

	/**
	 * Returns the audit logs with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audit logs
	 * @return the audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	@Override
	public AuditLogs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditLogsException {

		AuditLogs auditLogs = fetchByPrimaryKey(primaryKey);

		if (auditLogs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditLogsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditLogs;
	}

	/**
	 * Returns the audit logs with the primary key or throws a <code>NoSuchAuditLogsException</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs
	 * @throws NoSuchAuditLogsException if a audit logs with the primary key could not be found
	 */
	@Override
	public AuditLogs findByPrimaryKey(long auditLogsId)
		throws NoSuchAuditLogsException {

		return findByPrimaryKey((Serializable)auditLogsId);
	}

	/**
	 * Returns the audit logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditLogsId the primary key of the audit logs
	 * @return the audit logs, or <code>null</code> if a audit logs with the primary key could not be found
	 */
	@Override
	public AuditLogs fetchByPrimaryKey(long auditLogsId) {
		return fetchByPrimaryKey((Serializable)auditLogsId);
	}

	/**
	 * Returns all the audit logses.
	 *
	 * @return the audit logses
	 */
	@Override
	public List<AuditLogs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AuditLogs> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AuditLogs> findAll(
		int start, int end, OrderByComparator<AuditLogs> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AuditLogs> findAll(
		int start, int end, OrderByComparator<AuditLogs> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AuditLogs> list = null;

		if (useFinderCache) {
			list = (List<AuditLogs>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUDITLOGS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITLOGS;

				sql = sql.concat(AuditLogsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AuditLogs>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the audit logses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuditLogs auditLogs : findAll()) {
			remove(auditLogs);
		}
	}

	/**
	 * Returns the number of audit logses.
	 *
	 * @return the number of audit logses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUDITLOGS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "auditLogsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITLOGS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditLogsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the audit logs persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGetAuditDataByAuditLogId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGetAuditDataByAuditLogId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"auditLogsId"}, true);

		_finderPathWithoutPaginationFindByGetAuditDataByAuditLogId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGetAuditDataByAuditLogId",
				new String[] {Long.class.getName()},
				new String[] {"auditLogsId"}, true);

		_finderPathCountByGetAuditDataByAuditLogId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetAuditDataByAuditLogId",
			new String[] {Long.class.getName()}, new String[] {"auditLogsId"},
			false);

		_finderPathWithPaginationFindByGetAuditDataByAction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGetAuditDataByAction",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"action"}, true);

		_finderPathWithoutPaginationFindByGetAuditDataByAction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGetAuditDataByAction", new String[] {String.class.getName()},
			new String[] {"action"}, true);

		_finderPathCountByGetAuditDataByAction = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetAuditDataByAction",
			new String[] {String.class.getName()}, new String[] {"action"},
			false);

		_finderPathWithPaginationFindByGetAuditDataByModuleName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGetAuditDataByModuleName",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"moduleName"}, true);

		_finderPathWithoutPaginationFindByGetAuditDataByModuleName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGetAuditDataByModuleName",
				new String[] {String.class.getName()},
				new String[] {"moduleName"}, true);

		_finderPathCountByGetAuditDataByModuleName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetAuditDataByModuleName",
			new String[] {String.class.getName()}, new String[] {"moduleName"},
			false);

		_setAuditLogsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAuditLogsUtilPersistence(null);

		entityCache.removeCache(AuditLogsImpl.class.getName());
	}

	private void _setAuditLogsUtilPersistence(
		AuditLogsPersistence auditLogsPersistence) {

		try {
			Field field = AuditLogsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, auditLogsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = EmployeePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EmployeePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EmployeePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUDITLOGS =
		"SELECT auditLogs FROM AuditLogs auditLogs";

	private static final String _SQL_SELECT_AUDITLOGS_WHERE =
		"SELECT auditLogs FROM AuditLogs auditLogs WHERE ";

	private static final String _SQL_COUNT_AUDITLOGS =
		"SELECT COUNT(auditLogs) FROM AuditLogs auditLogs";

	private static final String _SQL_COUNT_AUDITLOGS_WHERE =
		"SELECT COUNT(auditLogs) FROM AuditLogs auditLogs WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditLogs.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuditLogs exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AuditLogs exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditLogsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}