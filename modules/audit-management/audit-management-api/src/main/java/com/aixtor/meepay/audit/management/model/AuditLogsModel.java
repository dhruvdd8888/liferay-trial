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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AuditLogs service. Represents a row in the &quot;Employee_AuditLogs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.aixtor.meepay.audit.management.model.impl.AuditLogsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.aixtor.meepay.audit.management.model.impl.AuditLogsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogs
 * @generated
 */
@ProviderType
public interface AuditLogsModel
	extends BaseModel<AuditLogs>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a audit logs model instance should use the {@link AuditLogs} interface instead.
	 */

	/**
	 * Returns the primary key of this audit logs.
	 *
	 * @return the primary key of this audit logs
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this audit logs.
	 *
	 * @param primaryKey the primary key of this audit logs
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this audit logs.
	 *
	 * @return the uuid of this audit logs
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this audit logs.
	 *
	 * @param uuid the uuid of this audit logs
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the audit logs ID of this audit logs.
	 *
	 * @return the audit logs ID of this audit logs
	 */
	public long getAuditLogsId();

	/**
	 * Sets the audit logs ID of this audit logs.
	 *
	 * @param auditLogsId the audit logs ID of this audit logs
	 */
	public void setAuditLogsId(long auditLogsId);

	/**
	 * Returns the group ID of this audit logs.
	 *
	 * @return the group ID of this audit logs
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this audit logs.
	 *
	 * @param groupId the group ID of this audit logs
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this audit logs.
	 *
	 * @return the company ID of this audit logs
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this audit logs.
	 *
	 * @param companyId the company ID of this audit logs
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this audit logs.
	 *
	 * @return the user ID of this audit logs
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this audit logs.
	 *
	 * @param userId the user ID of this audit logs
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this audit logs.
	 *
	 * @return the user uuid of this audit logs
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this audit logs.
	 *
	 * @param userUuid the user uuid of this audit logs
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this audit logs.
	 *
	 * @return the user name of this audit logs
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this audit logs.
	 *
	 * @param userName the user name of this audit logs
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this audit logs.
	 *
	 * @return the create date of this audit logs
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this audit logs.
	 *
	 * @param createDate the create date of this audit logs
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this audit logs.
	 *
	 * @return the modified date of this audit logs
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this audit logs.
	 *
	 * @param modifiedDate the modified date of this audit logs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the action of this audit logs.
	 *
	 * @return the action of this audit logs
	 */
	@AutoEscape
	public String getAction();

	/**
	 * Sets the action of this audit logs.
	 *
	 * @param action the action of this audit logs
	 */
	public void setAction(String action);

	/**
	 * Returns the module name of this audit logs.
	 *
	 * @return the module name of this audit logs
	 */
	@AutoEscape
	public String getModuleName();

	/**
	 * Sets the module name of this audit logs.
	 *
	 * @param moduleName the module name of this audit logs
	 */
	public void setModuleName(String moduleName);

	/**
	 * Returns the created by of this audit logs.
	 *
	 * @return the created by of this audit logs
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this audit logs.
	 *
	 * @param createdBy the created by of this audit logs
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this audit logs.
	 *
	 * @return the modified by of this audit logs
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this audit logs.
	 *
	 * @param modifiedBy the modified by of this audit logs
	 */
	public void setModifiedBy(long modifiedBy);

	@Override
	public AuditLogs cloneWithOriginalValues();

}