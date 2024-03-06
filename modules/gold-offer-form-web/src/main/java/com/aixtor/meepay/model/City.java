package com.aixtor.meepay.model;

import com.aixtor.meepay.constants.GoldOfferFormConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class City {
	public static Map<String, ArrayList<String>> CITY_MAP = new HashMap<String, ArrayList<String>>();

    static{
        addCitiesToState(GoldOfferFormConstants.GUJARAT,
                GoldOfferFormConstants.BARODA,
                GoldOfferFormConstants.RAJKOT,
                GoldOfferFormConstants.AHMEDABAD);

        addCitiesToState(GoldOfferFormConstants.MAHARASHTRA,
                GoldOfferFormConstants.MUMBAI,
                GoldOfferFormConstants.PUNE,
                GoldOfferFormConstants.NAGPUR);

        addCitiesToState(GoldOfferFormConstants.CALIFORNIA,
                GoldOfferFormConstants.OAKLAND,
                GoldOfferFormConstants.BAKERSFIELD,
                GoldOfferFormConstants.PASADENA,
                GoldOfferFormConstants.MALIBU);

        addCitiesToState(GoldOfferFormConstants.TEXAS,
                GoldOfferFormConstants.HOUSTON,
                GoldOfferFormConstants.AUSTIN,
                GoldOfferFormConstants.DALLAS,
                GoldOfferFormConstants.LUBBOCK);

        addCitiesToState(GoldOfferFormConstants.FLORIDA,
                GoldOfferFormConstants.MIAMI,
                GoldOfferFormConstants.NAPLES,
                GoldOfferFormConstants.TAMPA);

        addCitiesToState(GoldOfferFormConstants.QUEENSLAND,
                GoldOfferFormConstants.BRISBANE,
                GoldOfferFormConstants.MACKAY,
                GoldOfferFormConstants.TOOWOOMBA,
                GoldOfferFormConstants.CAIRNS);

        addCitiesToState(GoldOfferFormConstants.TASMANIA,
                GoldOfferFormConstants.BURNIE,
                GoldOfferFormConstants.DEVONPORT,
                GoldOfferFormConstants.ULVERSTONE,
                GoldOfferFormConstants.KINGSTON,
                GoldOfferFormConstants.PENGUIN);
    }

    public static void addCitiesToState(String state, String... cities) {
        ArrayList<String> stateCities = new ArrayList<>();
        for (String city : cities) {
            stateCities.add(city);
        }
        CITY_MAP.put(state, stateCities);
    }
}
