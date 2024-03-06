package com.aixtor.meepay.employee.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author dhruv.dhana
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/meepay-employee-headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=MeepayEmployeeHeadless"
	},
	service = Application.class
)
@Generated("")
public class MeepayEmployeeHeadlessApplication extends Application {
}