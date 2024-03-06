package com.aixtor.meepay.employee.headless.client.serdes.v1_0;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.Status;
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
public class StatusSerDes {

	public static Status toDTO(String json) {
		StatusJSONParser statusJSONParser = new StatusJSONParser();

		return statusJSONParser.parseToDTO(json);
	}

	public static Status[] toDTOs(String json) {
		StatusJSONParser statusJSONParser = new StatusJSONParser();

		return statusJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Status status) {
		if (status == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (status.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(status.getCode()));

			sb.append("\"");
		}

		if (status.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(status.getMessage()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StatusJSONParser statusJSONParser = new StatusJSONParser();

		return statusJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Status status) {
		if (status == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (status.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(status.getCode()));
		}

		if (status.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(status.getMessage()));
		}

		return map;
	}

	public static class StatusJSONParser extends BaseJSONParser<Status> {

		@Override
		protected Status createDTO() {
			return new Status();
		}

		@Override
		protected Status[] createDTOArray(int size) {
			return new Status[size];
		}

		@Override
		protected void setField(
			Status status, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					status.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					status.setMessage((String)jsonParserFieldValue);
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