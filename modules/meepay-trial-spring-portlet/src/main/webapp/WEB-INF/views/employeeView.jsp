<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Employee List</h2>
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
	        </tr>
        </thead>
        <tbody>
			<c:forEach var="employee" items="${employeeList}">
	            <tr>
	                <td>${employee.getFirstName()}</td>
	                <td>${employee.getLastName()}</td>
	                <td>${employee.getEmail()}</td>
	                <td>${employee.getMobileNumber()}</td>
	                <td>${employee.getDepartmentId()}</td>
	                <td>${employee.getBranchId()}</td>
	                <td>${employee.getDesignationId()}</td>
	                <td>${employee.getAddress()}</td>
	            </tr>
	        </c:	forEach>
        </tbody>
    </table>
    