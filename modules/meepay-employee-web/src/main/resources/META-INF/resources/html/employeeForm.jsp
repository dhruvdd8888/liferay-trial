<%@ include file="/init.jsp"%>

<portlet:actionURL name="/addEmployee" var="addEmployeeURL" />
<portlet:actionURL name="/editEmployee" var="editEmployeeURL" />
<a href="http://localhost:8080/web/meepay/employee-crud" class="btn btn-primary">
	<b><span>&lt;</span></b>
  </a>
  
<h2>Employee Form</h2>


<form action="${empty employeePrefill ? addEmployeeURL : editEmployeeURL}" method="post">
	<input value = "${employeePrefill.employeeId}" type="hidden" name="<portlet:namespace/>employeeId" >
	<div class="form-group">
		<label class="" for="firstName">First name</label> <input id="0"
			placeholder="Enter firstName" value = "${employeePrefill.firstName}" class="form-control" type="text"
			name="<portlet:namespace/>firstName" >
	</div>
	<div class="form-group">
		<label class="" for="lastName">Lastname</label> <input id="1"
			placeholder="Enter Lastname" value = "${employeePrefill.lastName}" class="form-control" type="text"
			name="<portlet:namespace/>lastName" >
	</div>
	<div class="form-group">
		<label class="" for="email">Email</label> <input id="2"
			placeholder="Enter Email" value = "${employeePrefill.email}" class="form-control" type="text"
			name="<portlet:namespace/>email" >
	</div>
	
	<div class="form-group">
		<label class="" for="mobile">Mobile</label> <input id="3"
			placeholder="Enter Mobile" value = "${employeePrefill.mobile}" class="form-control" type="number"
			name="<portlet:namespace/>mobile" >
	</div>
	
	
	<div class="form-group">
		<label class="" for="department">Department</label> <select aria-label="Label"
			id="department" name="<portlet:namespace/>department" class="form-control">
			<option value="">Select Department</option>
			<c:forEach var="department" items="${departmentList}">
				<option value="${department.getPrimaryKey()}"
				${department.getPrimaryKey() eq employeePrefill.departmentId ? 'selected' : ''}>
				${department.getName()}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label class="" for="branch">Branch</label> <select aria-label="Label"
			id="branch" name="<portlet:namespace/>branch" class="form-control">
			<option value="">Select Branch</option>
			<c:forEach var="branch" items="${branchList}">
				<option value="${branch.getPrimaryKey()}"
				${branch.getPrimaryKey() eq employeePrefill.branchId ? 'selected' : ''}>
					${branch.getName()}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="designation">Designation</label> <select aria-label="Label"
			id="designation" name="<portlet:namespace/>designation" class="form-control">
			<option value="">Select Designation</option>
			<c:forEach var="designation" items="${designationList}">
				<option value="${designation.getPrimaryKey()}"
				${designation.getPrimaryKey() eq employeePrefill.designationId ? 'selected' : ''}>
				${designation.getName()}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="address">Address</label> <input id="4"
			placeholder="Enter Address" value = "${employeePrefill.address}" class="form-control" type="text"
			name="<portlet:namespace/>address" >
	</div>

	
	
	
	<div class="form-group">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>
