package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Branch;
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
public class BranchSerDes {

	public static Branch toDTO(String json) {
		BranchJSONParser branchJSONParser = new BranchJSONParser();

		return branchJSONParser.parseToDTO(json);
	}

	public static Branch[] toDTOs(String json) {
		BranchJSONParser branchJSONParser = new BranchJSONParser();

		return branchJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Branch branch) {
		if (branch == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (branch.getBranchId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchId\": ");

			sb.append(branch.getBranchId());
		}

		if (branch.getBranchName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchName\": ");

			sb.append("\"");

			sb.append(_escape(branch.getBranchName()));

			sb.append("\"");
		}

		if (branch.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(branch.getCity()));

			sb.append("\"");
		}

		if (branch.getCountry() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"country\": ");

			sb.append("\"");

			sb.append(_escape(branch.getCountry()));

			sb.append("\"");
		}

		if (branch.getState() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"state\": ");

			sb.append("\"");

			sb.append(_escape(branch.getState()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		BranchJSONParser branchJSONParser = new BranchJSONParser();

		return branchJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Branch branch) {
		if (branch == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (branch.getBranchId() == null) {
			map.put("branchId", null);
		}
		else {
			map.put("branchId", String.valueOf(branch.getBranchId()));
		}

		if (branch.getBranchName() == null) {
			map.put("branchName", null);
		}
		else {
			map.put("branchName", String.valueOf(branch.getBranchName()));
		}

		if (branch.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(branch.getCity()));
		}

		if (branch.getCountry() == null) {
			map.put("country", null);
		}
		else {
			map.put("country", String.valueOf(branch.getCountry()));
		}

		if (branch.getState() == null) {
			map.put("state", null);
		}
		else {
			map.put("state", String.valueOf(branch.getState()));
		}

		return map;
	}

	public static class BranchJSONParser extends BaseJSONParser<Branch> {

		@Override
		protected Branch createDTO() {
			return new Branch();
		}

		@Override
		protected Branch[] createDTOArray(int size) {
			return new Branch[size];
		}

		@Override
		protected void setField(
			Branch branch, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "branchId")) {
				if (jsonParserFieldValue != null) {
					branch.setBranchId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "branchName")) {
				if (jsonParserFieldValue != null) {
					branch.setBranchName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					branch.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "country")) {
				if (jsonParserFieldValue != null) {
					branch.setCountry((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "state")) {
				if (jsonParserFieldValue != null) {
					branch.setState((String)jsonParserFieldValue);
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