package com.aixtor.meepay.employee.headless.resource.v1_0.test;

import com.aixtor.meepay.employee.headless.client.dto.v1_0.EmployeeByDepartmentResponse;
import com.aixtor.meepay.employee.headless.client.http.HttpInvoker;
import com.aixtor.meepay.employee.headless.client.pagination.Page;
import com.aixtor.meepay.employee.headless.client.resource.v1_0.GetEmployeesByDepartmentResource;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author dhruv.dhana
 * @generated
 */
@Generated("")
public abstract class BaseGetEmployeesByDepartmentResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_getEmployeesByDepartmentResource.setContextCompany(testCompany);

		GetEmployeesByDepartmentResource.Builder builder =
			GetEmployeesByDepartmentResource.builder();

		getEmployeesByDepartmentResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testPostGetEmployeesByDepartment() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(
		Object getEmployeesByDepartment,
		List<Object> getEmployeesByDepartments) {

		boolean contains = false;

		for (Object item : getEmployeesByDepartments) {
			if (equals(getEmployeesByDepartment, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			getEmployeesByDepartments + " does not contain " +
				getEmployeesByDepartment,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Object getEmployeesByDepartment1, Object getEmployeesByDepartment2) {

		Assert.assertTrue(
			getEmployeesByDepartment1 + " does not equal " +
				getEmployeesByDepartment2,
			equals(getEmployeesByDepartment1, getEmployeesByDepartment2));
	}

	protected void assertEquals(
		List<Object> getEmployeesByDepartments1,
		List<Object> getEmployeesByDepartments2) {

		Assert.assertEquals(
			getEmployeesByDepartments1.size(),
			getEmployeesByDepartments2.size());

		for (int i = 0; i < getEmployeesByDepartments1.size(); i++) {
			Object getEmployeesByDepartment1 = getEmployeesByDepartments1.get(
				i);
			Object getEmployeesByDepartment2 = getEmployeesByDepartments2.get(
				i);

			assertEquals(getEmployeesByDepartment1, getEmployeesByDepartment2);
		}
	}

	protected void assertEquals(
		EmployeeByDepartmentResponse employeeByDepartmentResponse1,
		EmployeeByDepartmentResponse employeeByDepartmentResponse2) {

		Assert.assertTrue(
			employeeByDepartmentResponse1 + " does not equal " +
				employeeByDepartmentResponse2,
			equals(
				employeeByDepartmentResponse1, employeeByDepartmentResponse2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> getEmployeesByDepartments1,
		List<Object> getEmployeesByDepartments2) {

		Assert.assertEquals(
			getEmployeesByDepartments1.size(),
			getEmployeesByDepartments2.size());

		for (Object getEmployeesByDepartment1 : getEmployeesByDepartments1) {
			boolean contains = false;

			for (Object getEmployeesByDepartment2 :
					getEmployeesByDepartments2) {

				if (equals(
						getEmployeesByDepartment1, getEmployeesByDepartment2)) {

					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				getEmployeesByDepartments2 + " does not contain " +
					getEmployeesByDepartment1,
				contains);
		}
	}

	protected void assertValid(Object getEmployeesByDepartment)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> getEmployeesByDepartments =
			page.getItems();

		int size = getEmployeesByDepartments.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(
		EmployeeByDepartmentResponse employeeByDepartmentResponse) {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalEmployeeByDepartmentResponseAssertFieldNames()) {

			if (Objects.equals("departments", additionalAssertFieldName)) {
				if (employeeByDepartmentResponse.getDepartments() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("employees", additionalAssertFieldName)) {
				if (employeeByDepartmentResponse.getEmployees() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (employeeByDepartmentResponse.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("totalEmployee", additionalAssertFieldName)) {
				if (employeeByDepartmentResponse.getTotalEmployee() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[]
		getAdditionalEmployeeByDepartmentResponseAssertFieldNames() {

		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		Object getEmployeesByDepartment1, Object getEmployeesByDepartment2) {

		if (getEmployeesByDepartment1 == getEmployeesByDepartment2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected boolean equals(
		EmployeeByDepartmentResponse employeeByDepartmentResponse1,
		EmployeeByDepartmentResponse employeeByDepartmentResponse2) {

		if (employeeByDepartmentResponse1 == employeeByDepartmentResponse2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalEmployeeByDepartmentResponseAssertFieldNames()) {

			if (Objects.equals("departments", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeByDepartmentResponse1.getDepartments(),
						employeeByDepartmentResponse2.getDepartments())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("employees", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeByDepartmentResponse1.getEmployees(),
						employeeByDepartmentResponse2.getEmployees())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeByDepartmentResponse1.getStatus(),
						employeeByDepartmentResponse2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("totalEmployee", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employeeByDepartmentResponse1.getTotalEmployee(),
						employeeByDepartmentResponse2.getTotalEmployee())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_getEmployeesByDepartmentResource instanceof
				EntityModelResource)) {

			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_getEmployeesByDepartmentResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		Object getEmployeesByDepartment) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected EmployeeByDepartmentResponse randomEmployeeByDepartmentResponse()
		throws Exception {

		return new EmployeeByDepartmentResponse() {
			{
				totalEmployee = RandomTestUtil.randomLong();
			}
		};
	}

	protected GetEmployeesByDepartmentResource getEmployeesByDepartmentResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(
			BaseGetEmployeesByDepartmentResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.aixtor.meepay.employee.headless.resource.v1_0.
		GetEmployeesByDepartmentResource _getEmployeesByDepartmentResource;

}