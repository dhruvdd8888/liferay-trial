package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.EmployeeByBranchRequest;
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
public class EmployeeByBranchRequestSerDes {

	public static EmployeeByBranchRequest toDTO(String json) {
		EmployeeByBranchRequestJSONParser employeeByBranchRequestJSONParser =
			new EmployeeByBranchRequestJSONParser();

		return employeeByBranchRequestJSONParser.parseToDTO(json);
	}

	public static EmployeeByBranchRequest[] toDTOs(String json) {
		EmployeeByBranchRequestJSONParser employeeByBranchRequestJSONParser =
			new EmployeeByBranchRequestJSONParser();

		return employeeByBranchRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		EmployeeByBranchRequest employeeByBranchRequest) {

		if (employeeByBranchRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (employeeByBranchRequest.getBranchId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchId\": ");

			sb.append(employeeByBranchRequest.getBranchId());
		}

		if (employeeByBranchRequest.getBranchName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchName\": ");

			sb.append("\"");

			sb.append(_escape(employeeByBranchRequest.getBranchName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeByBranchRequestJSONParser employeeByBranchRequestJSONParser =
			new EmployeeByBranchRequestJSONParser();

		return employeeByBranchRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		EmployeeByBranchRequest employeeByBranchRequest) {

		if (employeeByBranchRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (employeeByBranchRequest.getBranchId() == null) {
			map.put("branchId", null);
		}
		else {
			map.put(
				"branchId",
				String.valueOf(employeeByBranchRequest.getBranchId()));
		}

		if (employeeByBranchRequest.getBranchName() == null) {
			map.put("branchName", null);
		}
		else {
			map.put(
				"branchName",
				String.valueOf(employeeByBranchRequest.getBranchName()));
		}

		return map;
	}

	public static class EmployeeByBranchRequestJSONParser
		extends BaseJSONParser<EmployeeByBranchRequest> {

		@Override
		protected EmployeeByBranchRequest createDTO() {
			return new EmployeeByBranchRequest();
		}

		@Override
		protected EmployeeByBranchRequest[] createDTOArray(int size) {
			return new EmployeeByBranchRequest[size];
		}

		@Override
		protected void setField(
			EmployeeByBranchRequest employeeByBranchRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "branchId")) {
				if (jsonParserFieldValue != null) {
					employeeByBranchRequest.setBranchId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "branchName")) {
				if (jsonParserFieldValue != null) {
					employeeByBranchRequest.setBranchName(
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