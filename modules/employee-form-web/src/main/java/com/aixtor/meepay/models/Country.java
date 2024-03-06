package com.aixtor.meepay.models;

import java.util.List;

import com.aixtor.meepay.constants.EmployeeFormConstants;
import java.util.ArrayList;

public class Country {

	 public static final List<String> COUNTRY_LIST = new ArrayList<String>();

	 static{
	     COUNTRY_LIST.add(EmployeeFormConstants.INDIA);
	     COUNTRY_LIST.add(EmployeeFormConstants.AUSTRALIA);
	     COUNTRY_LIST.add(EmployeeFormConstants.USA);
 }

	public static List<String> getCountryList() {
		return COUNTRY_LIST;
	}
}