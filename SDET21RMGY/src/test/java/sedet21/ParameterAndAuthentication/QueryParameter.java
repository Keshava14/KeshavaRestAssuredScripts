package sedet21.ParameterAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void queryParametrer() {

		baseURI = "http://reqres.in";

		given()
		.queryParam("page", "2")

		.when()
		.get("/api/users")

		.then()
		.assertThat()
		.statusCode(200)
		.log().all();	
	}
}
