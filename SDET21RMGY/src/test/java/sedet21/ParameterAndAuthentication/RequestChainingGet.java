package sedet21.ParameterAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet21.GenericUtils.JAVAUtility;

public class RequestChainingGet {

	@Test
	public void pathParametrer() {
		JAVAUtility jlib = new JAVAUtility();

		baseURI = "http://localhost";
		port = 8084;

		// create a project
		ProjectLibrary plib = new ProjectLibrary
				("NKeshava", "Alex"+jlib.getRandom(), "Conpleted", 25);

		Response res = given()
				.contentType(ContentType.JSON)
				.body(plib)
				.when()
				.post("/addProject");

		//capyure the project id using json path
		String myprojID = res.jsonPath().get("projectId");
		System.out.println(myprojID);

		res.then().log().all();

		//this is second request to read the same project created in 1st request
		given()
		.pathParam("projID", myprojID)

		.when()
		.get("/projects/{projID}")

		.then().assertThat().statusCode(200).log().all();

	}
}
