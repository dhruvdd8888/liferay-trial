package com.aixtor.meepay.service.blog;

import com.liferay.blogs.kernel.service.BlogsEntryLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author dhruv.dhana
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class BlogsEditServiceWrapper extends BlogsEntryLocalServiceWrapper {

	public BlogsEditServiceWrapper() {
		super(null);
	}

}