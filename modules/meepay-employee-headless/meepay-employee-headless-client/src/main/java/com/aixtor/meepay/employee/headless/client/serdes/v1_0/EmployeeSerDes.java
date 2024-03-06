package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Employee;
import com.aixtor.meepay.employee.headless.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeSerDes {

	public static Employee toDTO(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToDTO(json);
	}

	public static Employee[] toDTOs(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Employee employee) {
		if (employee == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employee.getBranchName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchName\": ");

			sb.append("\"");

			sb.append(_escape(employee.getBranchName()));

			sb.append("\"");
		}

		if (employee.getDepartmentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentName\": ");

			sb.append("\"");

			sb.append(_escape(employee.getDepartmentName()));

			sb.append("\"");
		}

		if (employee.getDesignationName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"designationName\": ");

			sb.append("\"");

			sb.append(_escape(employee.getDesignationName()));

			sb.append("\"");
		}

		if (employee.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(employee.getEmail()));

			sb.append("\"");
		}

		if (employee.getEmployeeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeId\": ");

			sb.append(employee.getEmployeeId());
		}

		if (employee.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(employee.getFirstName()));

			sb.append("\"");
		}

		if (employee.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(employee.getLastName()));

			sb.append("\"");
		}

		if (employee.getMobile() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobile\": ");

			sb.append("\"");

			sb.append(_escape(employee.getMobile()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Employee employee) {
		if (employee == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employee.getBranchName() == null) {
			map.put("branchName", null);
		}
		else {
			map.put("branchName", String.valueOf(employee.getBranchName()));
		}

		if (employee.getDepartmentName() == null) {
			map.put("departmentName", null);
		}
		else {
			map.put(
				"departmentName", String.valueOf(employee.getDepartmentName()));
		}

		if (employee.getDesignationName() == null) {
			map.put("designationName", null);
		}
		else {
			map.put(
				"designationName",
				String.valueOf(employee.getDesignationName()));
		}

		if (employee.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(employee.getEmail()));
		}

		if (employee.getEmployeeId() == null) {
			map.put("employeeId", null);
		}
		else {
			map.put("employeeId", String.valueOf(employee.getEmployeeId()));
		}

		if (employee.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(employee.getFirstName()));
		}

		if (employee.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(employee.getLastName()));
		}

		if (employee.getMobile() == null) {
			map.put("mobile", null);
		}
		else {
			map.put("mobile", String.valueOf(employee.getMobile()));
		}

		return map;
	}

	public static class EmployeeJSONParser extends BaseJSONParser<Employee> {

		@Override
		protected Employee createDTO() {
			return new Employee();
		}

		@Override
		protected Employee[] createDTOArray(int size) {
			return new Employee[size];
		}

		@Override
		protected void setField(
			Employee employee, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "branchName")) {
				if (jsonParserFieldValue != null) {
					employee.setBranchName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentName")) {
				if (jsonParserFieldValue != null) {
					employee.setDepartmentName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "designationName")) {
				if (jsonParserFieldValue != null) {
					employee.setDesignationName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					employee.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employeeId")) {
				if (jsonParserFieldValue != null) {
					employee.setEmployeeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					employee.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					employee.setLastName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mobile")) {
				if (jsonParserFieldValue != null) {
					employee.setMobile((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}