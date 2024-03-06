package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Branch;
import com.aixtor.meepay.employee.headless.client.dto.v1_0.Employee;
import com.aixtor.meepay.employee.headless.client.dto.v1_0.EmployeeByBranchResponse;
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
public class EmployeeByBranchResponseSerDes {

	public static EmployeeByBranchResponse toDTO(String json) {
		EmployeeByBranchResponseJSONParser employeeByBranchResponseJSONParser =
			new EmployeeByBranchResponseJSONParser();

		return employeeByBranchResponseJSONParser.parseToDTO(json);
	}

	public static EmployeeByBranchResponse[] toDTOs(String json) {
		EmployeeByBranchResponseJSONParser employeeByBranchResponseJSONParser =
			new EmployeeByBranchResponseJSONParser();

		return employeeByBranchResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		EmployeeByBranchResponse employeeByBranchResponse) {

		if (employeeByBranchResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeByBranchResponse.getBranches() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branches\": ");

			sb.append("[");

			for (int i = 0; i < employeeByBranchResponse.getBranches().length;
				 i++) {

				sb.append(
					String.valueOf(employeeByBranchResponse.getBranches()[i]));

				if ((i + 1) < employeeByBranchResponse.getBranches().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (employeeByBranchResponse.getEmployees() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employees\": ");

			sb.append("[");

			for (int i = 0; i < employeeByBranchResponse.getEmployees().length;
				 i++) {

				sb.append(
					String.valueOf(employeeByBranchResponse.getEmployees()[i]));

				if ((i + 1) < employeeByBranchResponse.getEmployees().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (employeeByBranchResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(employeeByBranchResponse.getStatus()));
		}

		if (employeeByBranchResponse.getTotalEmployee() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalEmployee\": ");

			sb.append(employeeByBranchResponse.getTotalEmployee());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeByBranchResponseJSONParser employeeByBranchResponseJSONParser =
			new EmployeeByBranchResponseJSONParser();

		return employeeByBranchResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeByBranchResponse employeeByBranchResponse) {

		if (employeeByBranchResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeByBranchResponse.getBranches() == null) {
			map.put("branches", null);
		}
		else {
			map.put(
				"branches",
				String.valueOf(employeeByBranchResponse.getBranches()));
		}

		if (employeeByBranchResponse.getEmployees() == null) {
			map.put("employees", null);
		}
		else {
			map.put(
				"employees",
				String.valueOf(employeeByBranchResponse.getEmployees()));
		}

		if (employeeByBranchResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put(
				"status", String.valueOf(employeeByBranchResponse.getStatus()));
		}

		if (employeeByBranchResponse.getTotalEmployee() == null) {
			map.put("totalEmployee", null);
		}
		else {
			map.put(
				"totalEmployee",
				String.valueOf(employeeByBranchResponse.getTotalEmployee()));
		}

		return map;
	}

	public static class EmployeeByBranchResponseJSONParser
		extends BaseJSONParser<EmployeeByBranchResponse> {

		@Override
		protected EmployeeByBranchResponse createDTO() {
			return new EmployeeByBranchResponse();
		}

		@Override
		protected EmployeeByBranchResponse[] createDTOArray(int size) {
			return new EmployeeByBranchResponse[size];
		}

		@Override
		protected void setField(
			EmployeeByBranchResponse employeeByBranchResponse,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "branches")) {
				if (jsonParserFieldValue != null) {
					employeeByBranchResponse.setBranches(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> BranchSerDes.toDTO((String)object)
						).toArray(
							size -> new Branch[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employees")) {
				if (jsonParserFieldValue != null) {
					employeeByBranchResponse.setEmployees(
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
					employeeByBranchResponse.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalEmployee")) {
				if (jsonParserFieldValue != null) {
					employeeByBranchResponse.setTotalEmployee(
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