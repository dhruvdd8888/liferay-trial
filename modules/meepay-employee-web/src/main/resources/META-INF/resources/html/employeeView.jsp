<%@ include file="/init.jsp" %>

<style>
    #noti {
      display: none;
      padding: 10px;
      background-color: #e74c3c;
      color: #fff;
    }
  </style>
<portlet:renderURL var="addEmployeeRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/renderEmployeeForm" />
</portlet:renderURL>


<portlet:actionURL var="deleteEmployeeURL" name="/deleteEmployee">
	<portlet:param name="employeeId" value="EMPLOYEE_ID" />
</portlet:actionURL>

<h2>Employee List</h2>
<div id="noti">
    render success
</div>

<liferay-ui:success key="delete-employee-success" message="delete-employee-success"/>
<liferay-ui:error key="delete-employee-fail" message="delete-employee-fail" />

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
						<portlet:param name="mvcRenderCommandName" value="/renderEmployeeFormPrefill" />
						<portlet:param name="employeeId" value="${employee.getEmployeeId()}" />
					</portlet:renderURL>

					<a href="${updateEmployeeURL}" class="btn btn-success">Update</a><br>

					<a href="#" onclick="deleteAction(${employee.getEmployeeId()})"
						class="btn btn-danger">Delete</a>


				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a class="btn btn-primary" href="${addEmployeeRenderURL}">Add Employee</a>

<script>
	function deleteAction(employeeId) {
		let url = '${deleteEmployeeURL }';
		url = url.replace('EMPLOYEE_ID', employeeId);

		if (confirm("Are you sure? You won't be able to revert this!")) {
			window.location.href = url;
		}
	}

	$(document).ready(function () {
		var notification = document.getElementById('noti');
		notification.style.display = 'block';

		setTimeout(function () {
			notification.style.display = 'none';
		}, 4000);
	});

</script>