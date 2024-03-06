package com.aixtor.meepay.employee.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
@GraphQLName("EmployeeByBranchResponse")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "EmployeeByBranchResponse")
public class EmployeeByBranchResponse implements Serializable {

	public static EmployeeByBranchResponse toDTO(String json) {
		return ObjectMapperUtil.readValue(EmployeeByBranchResponse.class, json);
	}

	public static EmployeeByBranchResponse unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			EmployeeByBranchResponse.class, json);
	}

	@Schema
	@Valid
	public Branch[] getBranches() {
		return branches;
	}

	public void setBranches(Branch[] branches) {
		this.branches = branches;
	}

	@JsonIgnore
	public void setBranches(
		UnsafeSupplier<Branch[], Exception> branchesUnsafeSupplier) {

		try {
			branches = branchesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Branch[] branches;

	@Schema
	@Valid
	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	@JsonIgnore
	public void setEmployees(
		UnsafeSupplier<Employee[], Exception> employeesUnsafeSupplier) {

		try {
			employees = employeesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Employee[] employees;

	@Schema
	@Valid
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Status status;

	@Schema
	public Long getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(Long totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	@JsonIgnore
	public void setTotalEmployee(
		UnsafeSupplier<Long, Exception> totalEmployeeUnsafeSupplier) {

		try {
			totalEmployee = totalEmployeeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long totalEmployee;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (branches != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branches\": ");

			sb.append("[");

			for (int i = 0; i < branches.length; i++) {
				sb.append(String.valueOf(branches[i]));

				if ((i + 1) < branches.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (employees != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employees\": ");

			sb.append("[");

			for (int i = 0; i < employees.length; i++) {
				sb.append(String.valueOf(employees[i]));

				if ((i + 1) < employees.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(status));
		}

		if (totalEmployee != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalEmployee\": ");

			sb.append(totalEmployee);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.aixtor.meepay.employee.headless.dto.v1_0.EmployeeByBranchResponse",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}