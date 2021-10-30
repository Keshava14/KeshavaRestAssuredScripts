package sdet21.GenericUtils;

import io.restassured.response.Response;

/**
 * This class contains generic methods pertaining to rest-assured
 * @author Keshava
 *
 */
public class RestAssuredUtility {

	public String getJsonData(Response res,String jsonPath) {
		
		String value = res.jsonPath().get(jsonPath);
		return value;
		
	}
}
