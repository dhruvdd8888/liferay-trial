package com.aixtor.meepay.dynamic.blogs.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author dhruv.dhana
 */
@Component(
	immediate = true,
	service = DynamicInclude.class
)
public class DynamicIncludeBlogsViewEntryPortlet implements DynamicInclude{

	@Override
	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key)
			throws IOException {

		PrintWriter printWriter = httpServletResponse.getWriter();

		printWriter.println(
			"<h2>Added by Blogs</h2><br/> <h2>Dynamic Include!</h2><br/>");		
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
				"com.liferay.blogs.web#/blogs/view_entry.jsp#pre");
		}
}