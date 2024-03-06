package com.aixtor.meepay.employee.headless.client.dto.v1_0;

import com.aixtor.meepay.employee.headless.client.function.UnsafeSupplier;
import com.aixtor.meepay.employee.headless.client.serdes.v1_0.DepartmentSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class Department implements Cloneable, Serializable {

	public static Department toDTO(String json) {
		return DepartmentSerDes.toDTO(json);
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public void setDepartmentHead(
		UnsafeSupplier<String, Exception> departmentHeadUnsafeSupplier) {

		try {
			departmentHead = departmentHeadUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String departmentHead;

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
	public Department clone() throws CloneNotSupportedException {
		return (Department)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Department)) {
			return false;
		}

		Department department = (Department)object;

		return Objects.equals(toString(), department.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DepartmentSerDes.toJSON(this);
	}

}