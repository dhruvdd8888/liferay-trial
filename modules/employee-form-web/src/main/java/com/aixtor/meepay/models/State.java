package com.aixtor.meepay.models;

import com.aixtor.meepay.constants.EmployeeFormConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
	public static Map<String, ArrayList<String>> STATE_MAP = new HashMap<String, ArrayList<String>>();

    static{
        addStatesToCountry(EmployeeFormConstants.INDIA,
                EmployeeFormConstants.GUJARAT,
                EmployeeFormConstants.MAHARASHTRA,
                EmployeeFormConstants.BIHAR);

        
        addStatesToCountry(EmployeeFormConstants.USA,
                EmployeeFormConstants.CALIFORNIA,
                EmployeeFormConstants.TEXAS,
                EmployeeFormConstants.FLORIDA);
        
        addStatesToCountry(EmployeeFormConstants.AUSTRALIA,
                EmployeeFormConstants.TASMANIA,
                EmployeeFormConstants.QUEENSLAND);
    }
    
    
    public static void addStatesToCountry(String country, String... states) {
        ArrayList<String> countryStates = new ArrayList<>();
        for (String state : states) {
        	countryStates.add(state);
        }
        STATE_MAP.put(country, countryStates);
    }
}
