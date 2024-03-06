package com.aixtor.meepay.employee.headless.client.dto.v1_0;

import com.aixtor.meepay.employee.headless.client.function.UnsafeSupplier;
import com.aixtor.meepay.employee.headless.client.serdes.v1_0.EmployeeByBranchResponseSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeByBranchResponse implements Cloneable, Serializable {

	public static EmployeeByBranchResponse toDTO(String json) {
		return EmployeeByBranchResponseSerDes.toDTO(json);
	}

	public Branch[] getBranches() {
		return branches;
	}

	public void setBranches(Branch[] branches) {
		this.branches = branches;
	}

	public void setBranches(
		UnsafeSupplier<Branch[], Exception> branchesUnsafeSupplier) {

		try {
			branches = branchesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Branch[] branches;

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public void setEmployees(
		UnsafeSupplier<Employee[], Exception> employeesUnsafeSupplier) {

		try {
			employees = employeesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Employee[] employees;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	public Long getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(Long totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public void setTotalEmployee(
		UnsafeSupplier<Long, Exception> totalEmployeeUnsafeSupplier) {

		try {
			totalEmployee = totalEmployeeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalEmployee;

	@Override
	public EmployeeByBranchResponse clone() throws CloneNotSupportedException {
		return (EmployeeByBranchResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeByBranchResponse)) {
			return false;
		}

		EmployeeByBranchResponse employeeByBranchResponse =
			(EmployeeByBranchResponse)object;

		return Objects.equals(toString(), employeeByBranchResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmployeeByBranchResponseSerDes.toJSON(this);
	}

}