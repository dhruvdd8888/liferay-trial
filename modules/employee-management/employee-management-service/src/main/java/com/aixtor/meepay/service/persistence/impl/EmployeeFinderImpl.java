package com.aixtor.meepay.service.persistence.impl;

import com.aixtor.meepay.model.Employee;
import com.aixtor.meepay.model.impl.EmployeeImpl;
import com.aixtor.meepay.service.persistence.EmployeeFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Currency;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl  extends EmployeeFinderBaseImpl
implements EmployeeFinder {

	@Reference
	CustomSQL customSQL;

	
	public List<Object> findByEmployeeContents(
		    String keyWord) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = customSQL.get(getClass(),
		        	FIND_BY_EMPLOYEE_CONTENTS);

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
//		        q.addEntity("employee_employee", EmployeeImpl.class);

		        QueryPos qPos = QueryPos.getInstance(q);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        qPos.add(keyWord);
		        
		        List<Object> resultObjList= (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);

		        return resultObjList;
		    }
		    catch (Exception e) {
		       e.printStackTrace();
		    }
		    finally {
		        closeSession(session);
		    }
		    return null;
		}

		public static final String FIND_BY_EMPLOYEE_CONTENTS =
		        "com.aixtor.meepay.service.persistence.EmployeeFinder.findByEmployeeContents";
	
	
	
	
}
