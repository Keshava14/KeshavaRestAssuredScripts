package sedet21.ParameterAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class O_Auth2_Authentication {

	@Test
	public void oauth() {
		
		// generate the token
		Response res = given()
		.formParam("client_id", "SDET_ZigZag_Rest")
		.formParam("client_secret", "c6ce6249f1e2767b6cc05ea128cdd2d8")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		// capture the token
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		// create a new request to access the token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2416")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
	
	}
}
