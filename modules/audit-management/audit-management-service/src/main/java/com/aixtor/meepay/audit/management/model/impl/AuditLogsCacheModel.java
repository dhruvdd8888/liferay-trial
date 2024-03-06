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

package com.aixtor.meepay.audit.management.model.impl;

import com.aixtor.meepay.audit.management.model.AuditLogs;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditLogs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditLogsCacheModel
	implements CacheModel<AuditLogs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditLogsCacheModel)) {
			return false;
		}

		AuditLogsCacheModel auditLogsCacheModel = (AuditLogsCacheModel)object;

		if (auditLogsId == auditLogsCacheModel.auditLogsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditLogsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", auditLogsId=");
		sb.append(auditLogsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", action=");
		sb.append(action);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuditLogs toEntityModel() {
		AuditLogsImpl auditLogsImpl = new AuditLogsImpl();

		if (uuid == null) {
			auditLogsImpl.setUuid("");
		}
		else {
			auditLogsImpl.setUuid(uuid);
		}

		auditLogsImpl.setAuditLogsId(auditLogsId);
		auditLogsImpl.setGroupId(groupId);
		auditLogsImpl.setCompanyId(companyId);
		auditLogsImpl.setUserId(userId);

		if (userName == null) {
			auditLogsImpl.setUserName("");
		}
		else {
			auditLogsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			auditLogsImpl.setCreateDate(null);
		}
		else {
			auditLogsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			auditLogsImpl.setModifiedDate(null);
		}
		else {
			auditLogsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (action == null) {
			auditLogsImpl.setAction("");
		}
		else {
			auditLogsImpl.setAction(action);
		}

		if (moduleName == null) {
			auditLogsImpl.setModuleName("");
		}
		else {
			auditLogsImpl.setModuleName(moduleName);
		}

		auditLogsImpl.setCreatedBy(createdBy);
		auditLogsImpl.setModifiedBy(modifiedBy);

		auditLogsImpl.resetOriginalValues();

		return auditLogsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		auditLogsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		action = objectInput.readUTF();
		moduleName = objectInput.readUTF();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(auditLogsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (moduleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long auditLogsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String action;
	public String moduleName;
	public long createdBy;
	public long modifiedBy;

}