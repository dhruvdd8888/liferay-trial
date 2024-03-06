package com.aixtor.meepay.portlet.action;

import com.aixtor.meepay.constants.GoldOfferFormPortletKeys;
import com.aixtor.meepay.model.City;
import com.aixtor.meepay.model.State;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;



import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + GoldOfferFormPortletKeys.GOLD_OFFER_FORM_PORTLET,
			"mvc.command.name=/get-country-states-city"
		},
		service = MVCResourceCommand.class
	)
public class GetCountryStatesCityMVCResourceCommand extends BaseMVCResourceCommand{

	private static final Log log = LogFactoryUtil.getLog(GetCountryStatesCityMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		String requestFrom = ParamUtil.getString(resourceRequest, "requestFrom", "");
        
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
        
        PrintWriter writer = null;
        
		try {
            writer = resourceResponse.getWriter();
            if (requestFrom.equals("country")){
                String country = ParamUtil.getString(resourceRequest, "country", "");
                responseObj.put("data", State.STATE_MAP.get(country));
            }
            else{
                String state = ParamUtil.getString(resourceRequest, "state", "");
                responseObj.put("data", City.CITY_MAP.get(state));
            }
            responseObj.put("status", "success");
			log.info("Retrieved successfully");
		} catch (Exception e) {
			log.error("Error occured while fetching -> " + e.getMessage());
			responseObj.put("status", "error");
			responseObj.put("error", "Error occured while fetching.");
		} finally {
			writer.write(responseObj.toString());
			writer.close();
		}
	}

}
