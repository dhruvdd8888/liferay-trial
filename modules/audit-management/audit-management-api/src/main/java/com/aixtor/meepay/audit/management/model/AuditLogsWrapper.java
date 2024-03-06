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

package com.aixtor.meepay.audit.management.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditLogs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogs
 * @generated
 */
public class AuditLogsWrapper
	extends BaseModelWrapper<AuditLogs>
	implements AuditLogs, ModelWrapper<AuditLogs> {

	public AuditLogsWrapper(AuditLogs auditLogs) {
		super(auditLogs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("auditLogsId", getAuditLogsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("action", getAction());
		attributes.put("moduleName", getModuleName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long auditLogsId = (Long)attributes.get("auditLogsId");

		if (auditLogsId != null) {
			setAuditLogsId(auditLogsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public AuditLogs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this audit logs.
	 *
	 * @return the action of this audit logs
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the audit logs ID of this audit logs.
	 *
	 * @return the audit logs ID of this audit logs
	 */
	@Override
	public long getAuditLogsId() {
		return model.getAuditLogsId();
	}

	/**
	 * Returns the company ID of this audit logs.
	 *
	 * @return the company ID of this audit logs
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this audit logs.
	 *
	 * @return the create date of this audit logs
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this audit logs.
	 *
	 * @return the created by of this audit logs
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this audit logs.
	 *
	 * @return the group ID of this audit logs
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this audit logs.
	 *
	 * @return the modified by of this audit logs
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this audit logs.
	 *
	 * @return the modified date of this audit logs
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module name of this audit logs.
	 *
	 * @return the module name of this audit logs
	 */
	@Override
	public String getModuleName() {
		return model.getModuleName();
	}

	/**
	 * Returns the primary key of this audit logs.
	 *
	 * @return the primary key of this audit logs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this audit logs.
	 *
	 * @return the user ID of this audit logs
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this audit logs.
	 *
	 * @return the user name of this audit logs
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this audit logs.
	 *
	 * @return the user uuid of this audit logs
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this audit logs.
	 *
	 * @return the uuid of this audit logs
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this audit logs.
	 *
	 * @param action the action of this audit logs
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the audit logs ID of this audit logs.
	 *
	 * @param auditLogsId the audit logs ID of this audit logs
	 */
	@Override
	public void setAuditLogsId(long auditLogsId) {
		model.setAuditLogsId(auditLogsId);
	}

	/**
	 * Sets the company ID of this audit logs.
	 *
	 * @param companyId the company ID of this audit logs
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this audit logs.
	 *
	 * @param createDate the create date of this audit logs
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this audit logs.
	 *
	 * @param createdBy the created by of this audit logs
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this audit logs.
	 *
	 * @param groupId the group ID of this audit logs
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this audit logs.
	 *
	 * @param modifiedBy the modified by of this audit logs
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this audit logs.
	 *
	 * @param modifiedDate the modified date of this audit logs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module name of this audit logs.
	 *
	 * @param moduleName the module name of this audit logs
	 */
	@Override
	public void setModuleName(String moduleName) {
		model.setModuleName(moduleName);
	}

	/**
	 * Sets the primary key of this audit logs.
	 *
	 * @param primaryKey the primary key of this audit logs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this audit logs.
	 *
	 * @param userId the user ID of this audit logs
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this audit logs.
	 *
	 * @param userName the user name of this audit logs
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this audit logs.
	 *
	 * @param userUuid the user uuid of this audit logs
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this audit logs.
	 *
	 * @param uuid the uuid of this audit logs
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AuditLogsWrapper wrap(AuditLogs auditLogs) {
		return new AuditLogsWrapper(auditLogs);
	}

}