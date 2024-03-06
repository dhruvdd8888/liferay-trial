package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Department;
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
public class DepartmentSerDes {

	public static Department toDTO(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTO(json);
	}

	public static Department[] toDTOs(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Department department) {
		if (department == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (department.getDepartmentHead() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentHead\": ");

			sb.append("\"");

			sb.append(_escape(department.getDepartmentHead()));

			sb.append("\"");
		}

		if (department.getDepartmentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentId\": ");

			sb.append(department.getDepartmentId());
		}

		if (department.getDepartmentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentName\": ");

			sb.append("\"");

			sb.append(_escape(department.getDepartmentName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Department department) {
		if (department == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (department.getDepartmentHead() == null) {
			map.put("departmentHead", null);
		}
		else {
			map.put(
				"departmentHead",
				String.valueOf(department.getDepartmentHead()));
		}

		if (department.getDepartmentId() == null) {
			map.put("departmentId", null);
		}
		else {
			map.put(
				"departmentId", String.valueOf(department.getDepartmentId()));
		}

		if (department.getDepartmentName() == null) {
			map.put("departmentName", null);
		}
		else {
			map.put(
				"departmentName",
				String.valueOf(department.getDepartmentName()));
		}

		return map;
	}

	public static class DepartmentJSONParser
		extends BaseJSONParser<Department> {

		@Override
		protected Department createDTO() {
			return new Department();
		}

		@Override
		protected Department[] createDTOArray(int size) {
			return new Department[size];
		}

		@Override
		protected void setField(
			Department department, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "departmentHead")) {
				if (jsonParserFieldValue != null) {
					department.setDepartmentHead((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentId")) {
				if (jsonParserFieldValue != null) {
					department.setDepartmentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentName")) {
				if (jsonParserFieldValue != null) {
					department.setDepartmentName((String)jsonParserFieldValue);
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