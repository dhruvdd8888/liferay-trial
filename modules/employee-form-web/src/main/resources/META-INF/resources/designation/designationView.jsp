<%@ include file="/init.jsp" %>
<%@ page import = "com.aixtor.meepay.models.Designation" %>

<portlet:renderURL var="addDesignationRenderURL">
    <portlet:param name="mvcPath" value="/designation/designationForm.jsp"/>
</portlet:renderURL>


<h2>Designation List</h2>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="designation" items="${designationList}">
				<tr>
	                <td>${designation.getName()}</td>
	            </tr>
			</c:forEach>        
        </tbody>
    </table>
<a class="btn btn-primary" href="${addDesignationRenderURL}">Add Designation</a>
