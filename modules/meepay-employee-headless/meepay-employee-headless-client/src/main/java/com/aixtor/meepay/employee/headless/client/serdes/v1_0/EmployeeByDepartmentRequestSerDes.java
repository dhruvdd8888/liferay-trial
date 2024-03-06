package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.EmployeeByDepartmentRequest;
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
public class EmployeeByDepartmentRequestSerDes {

	public static EmployeeByDepartmentRequest toDTO(String json) {
		EmployeeByDepartmentRequestJSONParser
			employeeByDepartmentRequestJSONParser =
				new EmployeeByDepartmentRequestJSONParser();

		return employeeByDepartmentRequestJSONParser.parseToDTO(json);
	}

	public static EmployeeByDepartmentRequest[] toDTOs(String json) {
		EmployeeByDepartmentRequestJSONParser
			employeeByDepartmentRequestJSONParser =
				new EmployeeByDepartmentRequestJSONParser();

		return employeeByDepartmentRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		EmployeeByDepartmentRequest employeeByDepartmentRequest) {

		if (employeeByDepartmentRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeByDepartmentRequest.getDepartmentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentId\": ");

			sb.append(employeeByDepartmentRequest.getDepartmentId());
		}

		if (employeeByDepartmentRequest.getDepartmentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentName\": ");

			sb.append("\"");

			sb.append(_escape(employeeByDepartmentRequest.getDepartmentName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeByDepartmentRequestJSONParser
			employeeByDepartmentRequestJSONParser =
				new EmployeeByDepartmentRequestJSONParser();

		return employeeByDepartmentRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeByDepartmentRequest employeeByDepartmentRequest) {

		if (employeeByDepartmentRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeByDepartmentRequest.getDepartmentId() == null) {
			map.put("departmentId", null);
		}
		else {
			map.put(
				"departmentId",
				String.valueOf(employeeByDepartmentRequest.getDepartmentId()));
		}

		if (employeeByDepartmentRequest.getDepartmentName() == null) {
			map.put("departmentName", null);
		}
		else {
			map.put(
				"departmentName",
				String.valueOf(
					employeeByDepartmentRequest.getDepartmentName()));
		}

		return map;
	}

	public static class EmployeeByDepartmentRequestJSONParser
		extends BaseJSONParser<EmployeeByDepartmentRequest> {

		@Override
		protected EmployeeByDepartmentRequest createDTO() {
			return new EmployeeByDepartmentRequest();
		}

		@Override
		protected EmployeeByDepartmentRequest[] createDTOArray(int size) {
			return new EmployeeByDepartmentRequest[size];
		}

		@Override
		protected void setField(
			EmployeeByDepartmentRequest employeeByDepartmentRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "departmentId")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentRequest.setDepartmentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentName")) {
				if (jsonParserFieldValue != null) {
					employeeByDepartmentRequest.setDepartmentName(
						(String)jsonParserFieldValue);
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