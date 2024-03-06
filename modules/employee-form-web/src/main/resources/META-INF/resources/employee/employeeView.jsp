<%@ include file="/init.jsp" %>

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/employee/employeeForm.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="applySearchFilterURL">
    <portlet:param name="mvcPath" value="/employee/employeeView.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="switchViewURL">
    <portlet:param name="mvcPath" value="/employee/searchContainerView.jsp"/>
</portlet:renderURL>


<portlet:actionURL var="deleteEmployeeURL" name = "deleteEmployee">
	<portlet:param name="employeeId" value="EMPLOYEE_ID" />
</portlet:actionURL>



<h2>Employee List</h2>
	
	<form action="${applySearchFilterURL}" method="post">
	<h3>Search by Keyword</h3>
	<div class="form-group">
		<label class="" for="0">KeyWord</label> <input id="0"
			placeholder="Enter Keyword" class="form-control" type="text"
			name="<portlet:namespace/>keyword" value="${storedKeyWord}">
	</div>


	<h3>Fiter by dates</h3>
	<div class="form-group">
		<label class="" for="0">Start Date</label> <input id="0"
			placeholder="Start Date" class="form-control" type="date"
			name="<portlet:namespace/>startDate" value="${storedStartDate}">
	</div>

	<div class="form-group">
		<label class="" for="0">End Date</label> <input id="0"
			placeholder="End Date" class="form-control" type="date"
			name="<portlet:namespace/>endDate" value="${storedEndDate}">
	</div>

	<div class="form-group">
		<button class="btn btn-primary" type="apply">Apply</button>
	</div>
	<div class="form-group">
   		<input class="btn btn-primary"  type="reset" value="Reset" onclick="location.reload(true);">
   </div>
</form>
	
	
	
	
    <table class="table table-striped">
        <thead>
	        <tr>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>Email</th>
	            <th>Mobile</th>
	            <th>Department</th>
	            <th>Branch</th>
	            <th>Designation</th>
	            <th>Address</th>
	            <th>Action</th>
	        </tr>
        </thead>
        
        <tbody>
			<c:forEach var="employee" items="${employeeList}">
	            <tr>
	                <td>${employee.getFirstName()}</td>
	                <td>${employee.getLastName()}</td>
	                <td>${employee.getEmail()}</td>
	                <td>${employee.getMobile()}</td>
	                <td>${employee.getDepartment()}</td>
	                <td>${employee.getBranch()}</td>
	                <td>${employee.getDesignation()}</td>
	                <td>${employee.getAddress()}</td>
	                <td>
						<portlet:renderURL var="updateEmployeeURL">
							<portlet:param name="command" value="updateEmployee" />
							<portlet:param name="employeeId" value="${employee.getEmployeeId()}" />
						    <portlet:param name="mvcPath" value="/employee/employeeForm.jsp"/>
						</portlet:renderURL>
						<a href="${updateEmployeeURL}" class="btn btn-success">Update</a><br>
								
						<a href="#" onclick="deleteAction(${employee.getEmployeeId() })" class="btn btn-danger">Delete</a>
							
					
					</td>
	            </tr>
	        </c:forEach>    
        </tbody>
    </table>
    
<a class="btn btn-primary" href="${addEmployeeRenderURL}">Add Employee</a>
<a class="btn btn-primary" href="${switchViewURL}">Search Container View</a>

<script>
	function deleteAction(employeeId) {
		let url = '${deleteEmployeeURL }';
		url = url.replace('EMPLOYEE_ID', employeeId);

		if (confirm("Are you sure? You won't be able to revert this!")) {
			window.location.href = url;
		}
	}
</script>
