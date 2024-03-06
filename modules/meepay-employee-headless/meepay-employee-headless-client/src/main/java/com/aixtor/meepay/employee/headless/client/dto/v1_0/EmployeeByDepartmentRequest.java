package com.aixtor.meepay.employee.headless.client.dto.v1_0;

import com.aixtor.meepay.employee.headless.client.function.UnsafeSupplier;
import com.aixtor.meepay.employee.headless.client.serdes.v1_0.EmployeeByDepartmentRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeByDepartmentRequest implements Cloneable, Serializable {

	public static EmployeeByDepartmentRequest toDTO(String json) {
		return EmployeeByDepartmentRequestSerDes.toDTO(json);
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentId(
		UnsafeSupplier<Long, Exception> departmentIdUnsafeSupplier) {

		try {
			departmentId = departmentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long departmentId;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentName(
		UnsafeSupplier<String, Exception> departmentNameUnsafeSupplier) {

		try {
			departmentName = departmentNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String departmentName;

	@Override
	public EmployeeByDepartmentRequest clone()
		throws CloneNotSupportedException {

		return (EmployeeByDepartmentRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeByDepartmentRequest)) {
			return false;
		}

		EmployeeByDepartmentRequest employeeByDepartmentRequest =
			(EmployeeByDepartmentRequest)object;

		return Objects.equals(
			toString(), employeeByDepartmentRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmployeeByDepartmentRequestSerDes.toJSON(this);
	}

}