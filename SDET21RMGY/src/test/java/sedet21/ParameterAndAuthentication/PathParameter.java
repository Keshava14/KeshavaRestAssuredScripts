package sedet21.ParameterAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

	@Test
	public void pathParametrer() {

		baseURI = "http://localhost";
		port = 8084;

		given()
		.pathParam("projectID", "TY_PROJ_1202")

		.when()
		.get("/projects/{projectID}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();

	}
}
