package com.aixtor.meepay.employee.headless.client.dto.v1_0;

import com.aixtor.meepay.employee.headless.client.function.UnsafeSupplier;
import com.aixtor.meepay.employee.headless.client.serdes.v1_0.EmployeeByBranchRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeByBranchRequest implements Cloneable, Serializable {

	public static EmployeeByBranchRequest toDTO(String json) {
		return EmployeeByBranchRequestSerDes.toDTO(json);
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public void setBranchId(
		UnsafeSupplier<Long, Exception> branchIdUnsafeSupplier) {

		try {
			branchId = branchIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long branchId;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setBranchName(
		UnsafeSupplier<String, Exception> branchNameUnsafeSupplier) {

		try {
			branchName = branchNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String branchName;

	@Override
	public EmployeeByBranchRequest clone() throws CloneNotSupportedException {
		return (EmployeeByBranchRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeByBranchRequest)) {
			return false;
		}

		EmployeeByBranchRequest employeeByBranchRequest =
			(EmployeeByBranchRequest)object;

		return Objects.equals(toString(), employeeByBranchRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EmployeeByBranchRequestSerDes.toJSON(this);
	}

}