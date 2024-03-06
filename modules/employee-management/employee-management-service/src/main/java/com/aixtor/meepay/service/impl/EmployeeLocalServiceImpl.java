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

package com.aixtor.meepay.service.impl;

import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.service.base.EmployeeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.meepay.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public List<Object> findByEmployeeContents(
		    String keyWord) {
		return employeeFinder.findByEmployeeContents(keyWord);
		
	}
	public List<Employee> findByBranchId(
		    long branchId) {
		return employeePersistence.findBybranchId(branchId);
	}

	
	public List<Employee> findByDepartmentId(
		    long departmentId) {
		return employeePersistence.findBydepartmentId(departmentId);
	}
}