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
 * Provides a wrapper for {@link AuditLogsService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogsService
 * @generated
 */
public class AuditLogsServiceWrapper
	implements AuditLogsService, ServiceWrapper<AuditLogsService> {

	public AuditLogsServiceWrapper() {
		this(null);
	}

	public AuditLogsServiceWrapper(AuditLogsService auditLogsService) {
		_auditLogsService = auditLogsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditLogsService.getOSGiServiceIdentifier();
	}

	@Override
	public AuditLogsService getWrappedService() {
		return _auditLogsService;
	}

	@Override
	public void setWrappedService(AuditLogsService auditLogsService) {
		_auditLogsService = auditLogsService;
	}

	private AuditLogsService _auditLogsService;

}