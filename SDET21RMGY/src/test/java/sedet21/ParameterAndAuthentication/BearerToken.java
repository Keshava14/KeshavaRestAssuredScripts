package sedet21.ParameterAndAuthentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerToken() {
	
		// create the data
		HashMap map = new HashMap();
		map.put("name", "SDET_21_Bearer_Token");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("http://api.github.com/user/repos")
		
		.then().log().all();
	}
}
