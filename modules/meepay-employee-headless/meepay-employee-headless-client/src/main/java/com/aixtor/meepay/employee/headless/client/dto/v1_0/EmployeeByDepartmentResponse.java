package com.aixtor.meepay.employee.headless.client.dto.v1_0;

import com.aixtor.meepay.employee.headless.client.function.UnsafeSupplier;
import com.aixtor.meepay.employee.headless.client.serdes.v1_0.EmployeeByDepartmentResponseSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeByDepartmentResponse implements Cloneable, Serializable {

	public static EmployeeByDepartmentResponse toDTO(String json) {
		return EmployeeByDepartmentResponseSerDes.toDTO(json);
	}

	public Department[] getDepartments() {
		return departments;
	}

	public void setDepartments(Department[] departments) {
		this.departments = departments;
	}

	public void setDepartments(
		UnsafeSupplier<Department[], Exception> departmentsUnsafeSupplier) {

		try {
			departments = departmentsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Department[] departments;

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
	public EmployeeByDepartmentResponse clone()
		throws CloneNotSupportedException {

		return (EmployeeByDepartmentResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeByDepartmentResponse)) {
			return false;
		}

		EmployeeByDepartmentResponse employeeByDepartmentResponse =
			(EmployeeByDepartmentResponse)object;

		return Objects.equals(
			toString(), employeeByDepartmentResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmployeeByDepartmentResponseSerDes.toJSON(this);
	}

}