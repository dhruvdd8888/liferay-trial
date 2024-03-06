package com.aixtor.meepay.model;

import com.aixtor.meepay.constants.GoldOfferFormConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
	public static Map<String, ArrayList<String>> STATE_MAP = new HashMap<String, ArrayList<String>>();

    static{

        ArrayList<String> indiaStates = new ArrayList<String>();
        indiaStates.add(GoldOfferFormConstants.MAHARASHTRA);
        indiaStates.add(GoldOfferFormConstants.GUJARAT);
        STATE_MAP.put(GoldOfferFormConstants.INDIA, indiaStates);
        addStatesToCountry(GoldOfferFormConstants.INDIA,
                GoldOfferFormConstants.GUJARAT,
                GoldOfferFormConstants.MAHARASHTRA);

        
        addStatesToCountry(GoldOfferFormConstants.USA,
                GoldOfferFormConstants.CALIFORNIA,
                GoldOfferFormConstants.TEXAS,
                GoldOfferFormConstants.FLORIDA);
        
        addStatesToCountry(GoldOfferFormConstants.AUSTRALIA,
                GoldOfferFormConstants.TASMANIA,
                GoldOfferFormConstants.QUEENSLAND);
    }
    
    public static void addStatesToCountry(String country, String... states) {
        ArrayList<String> countryStates = new ArrayList<>();
        for (String state : states) {
        	countryStates.add(state);
        }
        STATE_MAP.put(country, countryStates);
    }
}
