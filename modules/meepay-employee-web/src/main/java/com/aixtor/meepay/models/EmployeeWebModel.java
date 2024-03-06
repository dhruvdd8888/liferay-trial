package com.aixtor.meepay.models;

import com.aixtor.meepay.model.Employee;
import com.liferay.petra.string.StringPool;

import java.math.BigInteger;

public class EmployeeWebModel {
	
	long employeeId;
	long departmentId;
	long designationId;
	long branchId;
	String firstName;
	String lastName;
	String email;
	String mobile;
	String department;
	String branch;
	String designation;
	String address;
	



	public long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}


	public long getDesignationId() {
		return designationId;
	}


	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}


	public long getBranchId() {
		return branchId;
	}


	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}


	@Override
	public String toString() {
		return "EmployeeWebModel [employeeId=" + employeeId + ", departmentId=" + departmentId + ", designationId="
				+ designationId + ", branchId=" + branchId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobile=" + mobile + ", department=" + department + ", branch=" + branch
				+ ", designation=" + designation + ", address=" + address + "]";
	}


	public EmployeeWebModel() {
		super();
	}




	public EmployeeWebModel(long employeeId, long departmentId, long designationId, long branchId, String firstName,
			String lastName, String email, String mobile, String department, String branch, String designation,
			String address) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.designationId = designationId;
		this.branchId = branchId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.department = department;
		this.branch = branch;
		this.designation = designation;
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	public EmployeeWebModel(Employee employee){
		firstName = employee.getFirstName();
		lastName = employee.getLastName();
		email = employee.getEmail();
		employeeId = employee.getEmployeeId();
		mobile = StringPool.BLANK + employee.getMobileNumber();
		departmentId  = employee.getDepartmentId();
		department = EmployeeMapper.departmentMap.get(departmentId);
		branchId = employee.getBranchId();
		branch =  EmployeeMapper.branchMap.get(branchId);
		designationId = employee.getDesignationId();
		designation =  EmployeeMapper.designationMap.get(designationId);
		address = StringPool.BLANK + employee.getAddress();
		
	}

	public EmployeeWebModel(Object object){

		Object[] current = (Object[])object;
		try {
			employeeId = (new BigInteger(StringPool.BLANK+current[1])).longValue();
			firstName = StringPool.BLANK + current[8];
			lastName = StringPool.BLANK + current[9];
			email = StringPool.BLANK + current[10];
			mobile = StringPool.BLANK + current[11];
			departmentId = (new BigInteger(StringPool.BLANK+current[12])).longValue();
			branchId = (new BigInteger(StringPool.BLANK+current[13])).longValue();
			designationId = (new BigInteger(StringPool.BLANK+current[14])).longValue();
			department = StringPool.BLANK + current[17];
			branch = StringPool.BLANK + current[16];
			designation = StringPool.BLANK + current[18];
			address = StringPool.BLANK + current[15];
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
}
