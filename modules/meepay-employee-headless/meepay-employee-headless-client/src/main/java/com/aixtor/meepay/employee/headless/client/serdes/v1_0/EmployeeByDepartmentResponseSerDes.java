package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Department;
import com.aixtor.meepay.employee.headless.client.dto.v1_0.Employee;
import com.aixtor.meepay.employee.headless.client.dto.v1_0.EmployeeByDepartmentResponse;
import com.aixtor.meepay.employee.headless.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public class EmployeeByDepartmentResponseSerDes {

	public static EmployeeByDepartmentResponse toDTO(String json) {
		EmployeeByDepartmentResponseJSONParser
			employeeByDepartmentResponseJSONParser =
				new EmployeeByDepartmentResponseJSONParser();

		return employeeByDepartmentResponseJSONParser.parseToDTO(json);
	}

	public static EmployeeByDepartmentResponse[] toDTOs(String json) {
		EmployeeByDepartmentResponseJSONParser
			employeeByDepartmentResponseJSONParser =
				new EmployeeByDepartmentResponseJSONParser();

		return employeeByDepartmentResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		EmployeeByDepartmentResponse employeeByDepartmentResponse) {

		if (employeeByDepartmentResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeByDepartmentResponse.getDepartments() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departments\": ");

			sb.append("[");

			for (int i = 0;
				 i < employeeByDepartmentResponse.getDepartments().length;
				 i++) {

				sb.append(
					String.valueOf(
						employeeByDepartmentResponse.getDepartments()[i]));

				if ((i + 1) <
						employeeByDepartmentResponse.getDepartments().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (employeeByDepartmentResponse.getEmployees() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employees\": ");

			sb.append("[");

			for (int i = 0;
				 i < employeeByDepartmentResponse.getEmployees().length; i++) {

				sb.append(
					String.valueOf(
						employeeByDepartmentResponse.getEmployees()[i]));

				if ((i + 1) <
						employeeByDepartmentResponse.getEmployees().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (employeeByDepartmentResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(employeeByDepartmentResponse.getStatus()));
		}

		if (employeeByDepartmentResponse.getTotalEmployee() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalEmployee\": ");

			sb.append(employeeByDepartmentResponse.getTotalEmployee());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeByDepartmentResponseJSONParser
			employeeByDepartmentResponseJSONParser =
				new EmployeeByDepartmentResponseJSONParser();

		return employeeByDepartmentResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeByDepartmentResponse employeeByDepartmentResponse) {

		if (employeeByDepartmentResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeByDepartmentResponse.getDepartments() == null) {
			map.put("departments", null);
		}
		else {
			map.put(
				"departments",
				String.valueOf(employeeByDepartmentResponse.getDepartments()));
		}

		if (employeeByDepartmentResponse.getEmployees() == null) {
			map.put("employees", null);
		}
		else {
			map.put(
				"employees",
				String.valueOf(employeeByDepartmentResponse.getEmployees()));
		}

		if (employeeByDepartmentResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put(
				"status",
				String.valueOf(employeeByDepartmentResponse.getStatus()));
		}

		if (employeeByDepartmentResponse.getTotalEmployee() == null) {
			map.put("totalEmployee", null);
		}
		else {
			map.put(
				"totalEmployee",
				String.valueOf(
					employeeByDepartmentResponse.getTotalEmployee()));
		}

		return map;
	}

	public static class EmployeeByDepartmentResponseJSONParser
		extends BaseJSONParser<EmployeeByDepartmentResponse> {

		@Override
		protected EmployeeByDepartmentResponse createDTO() {
			return new EmployeeByDepartmentResponse();
		}

		@Override
		protected EmployeeByDepartmentResponse[] createDTOArray(int size) {
			return new EmployeeByDepartmentResponse[size];
		}

		@Override
		protected void setField(
			EmployeeByDepartmentResponse employeeByDepartmentResponse,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "departments")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentResponse.setDepartments(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> DepartmentSerDes.toDTO((String)object)
						).toArray(
							size -> new Department[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employees")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentResponse.setEmployees(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> EmployeeSerDes.toDTO((String)object)
						).toArray(
							size -> new Employee[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentResponse.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalEmployee")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentResponse.setTotalEmployee(
						Long.valueOf((String)jsonParserFieldValue));
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