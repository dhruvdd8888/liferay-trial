package com.aixtor.meepay.model;

import java.util.List;

import com.aixtor.meepay.constants.GoldOfferFormConstants;
import java.util.ArrayList;

public class Country {

	 public static final List<String> COUNTRY_LIST = new ArrayList<String>();

	 static{
	     COUNTRY_LIST.add(GoldOfferFormConstants.INDIA);
	     COUNTRY_LIST.add(GoldOfferFormConstants.AUSTRALIA);
	     COUNTRY_LIST.add(GoldOfferFormConstants.USA);
 }
}
