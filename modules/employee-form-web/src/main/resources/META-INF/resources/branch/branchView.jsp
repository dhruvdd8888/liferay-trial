<%@ include file="/init.jsp" %>

<portlet:renderURL var="addBranchRenderURL">
    <portlet:param name="mvcPath" value="/branch/branchForm.jsp"/>
</portlet:renderURL>


<h2>Branch List</h2>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Country</th>
                <th>State</th>
                <th>City</th>
                
            </tr>
        </thead>
        <tbody>
			<c:forEach var="branch" items="${branchList}">
				<tr>
	                <td>${branch.getName()}</td>
        			<td>${branch.getCountryId()}</td>                
	                <td>${branch.getStateId()}</td>
                	<td>${branch.getCityId()}</td>
	                
	            </tr>
			</c:forEach>        
        </tbody>
    </table>
<a class="btn btn-primary" href="${addBranchRenderURL}">Add Branch</a>
