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

package com.aixtor.meepay.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Designation service. Represents a row in the &quot;EMPLOYEE_Designation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.aixtor.meepay.model.impl.DesignationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.aixtor.meepay.model.impl.DesignationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Designation
 * @generated
 */
@ProviderType
public interface DesignationModel
	extends BaseModel<Designation>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a designation model instance should use the {@link Designation} interface instead.
	 */

	/**
	 * Returns the primary key of this designation.
	 *
	 * @return the primary key of this designation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this designation.
	 *
	 * @param primaryKey the primary key of this designation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this designation.
	 *
	 * @return the uuid of this designation
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this designation.
	 *
	 * @param uuid the uuid of this designation
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the designation ID of this designation.
	 *
	 * @return the designation ID of this designation
	 */
	public long getDesignationId();

	/**
	 * Sets the designation ID of this designation.
	 *
	 * @param designationId the designation ID of this designation
	 */
	public void setDesignationId(long designationId);

	/**
	 * Returns the group ID of this designation.
	 *
	 * @return the group ID of this designation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this designation.
	 *
	 * @param groupId the group ID of this designation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this designation.
	 *
	 * @return the company ID of this designation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this designation.
	 *
	 * @param companyId the company ID of this designation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this designation.
	 *
	 * @return the user ID of this designation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this designation.
	 *
	 * @param userId the user ID of this designation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this designation.
	 *
	 * @return the user uuid of this designation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this designation.
	 *
	 * @param userUuid the user uuid of this designation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this designation.
	 *
	 * @return the user name of this designation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this designation.
	 *
	 * @param userName the user name of this designation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this designation.
	 *
	 * @return the create date of this designation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this designation.
	 *
	 * @param createDate the create date of this designation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this designation.
	 *
	 * @return the modified date of this designation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this designation.
	 *
	 * @param modifiedDate the modified date of this designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this designation.
	 *
	 * @return the name of this designation
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this designation.
	 *
	 * @param name the name of this designation
	 */
	public void setName(String name);

	@Override
	public Designation cloneWithOriginalValues();

}