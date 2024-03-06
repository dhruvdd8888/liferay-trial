<%@ include file="/init.jsp"%>
<%@page import="com.aixtor.meepay.models.EmployeeWebModel"%>
<%@page import="com.aixtor.meepay.service.EmployeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.aixtor.meepay.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:renderURL var="switchViewURL">
    <portlet:param name="mvcPath" value="/employee/employeeView.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/employee/employeeForm.jsp"/>
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/employee/searchContainerView.jsp" />
</liferay-portlet:renderURL>
<a class="btn btn-primary" href="${addEmployeeRenderURL}">Add Employee</a>
<a class="btn btn-primary" href="${switchViewURL}">Table View</a>

<liferay-ui:search-container 
	emptyResultsMessage="there-are-no-employee-details"
	headerNames="
			FirstName,
            LastName,
            Email,
            Mobile,
            Department,
            Branch,
            Designation,
            Address,
            Actions"
	iteratorURL="${iteratorURL}" delta="1" deltaConfigurable="true" 
		total="<%=EmployeeLocalServiceUtil.getEmployeesCount()%>"
	>
	<liferay-ui:search-container-results>
		<%
		
			List<Object> employeeDetailsList = EmployeeLocalServiceUtil.findByEmployeeContents("%%");
			List<EmployeeWebModel> employeeList = new ArrayList<>();
			for (Object object:employeeDetailsList)	{
				employeeList.add(new EmployeeWebModel(object));
			}	
			results = ListUtil.subList(employeeList, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResultsAndTotal(results);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="EmployeeWebModel"
		keyProperty="employeeId" modelVar="currentObjectEmployeeWebModel"  >
		<liferay-ui:search-container-column-text name="FirstName"
			property="firstName" />
		<liferay-ui:search-container-column-text name="LastName"
			property="lastName" />
		<liferay-ui:search-container-column-text name="Email"
			property="email" />
			<liferay-ui:search-container-column-text name="Mobile"
			property="mobile" />
		<liferay-ui:search-container-column-text name="Department"
			property="department" />		
		<liferay-ui:search-container-column-text name="Branch"
			property="branch" />		
		<liferay-ui:search-container-column-text name="Designation"
			property="designation" />		
		<liferay-ui:search-container-column-text name="Address"
			property="address" />	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</liferay-ui:search-container>
<br>

<br><br><br><br><br><br><br><br>

