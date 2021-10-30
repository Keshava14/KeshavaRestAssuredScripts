package sdet21.rmg.CRUD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponse {

	@Test
	public void staticResponse() {

		baseURI = "http://localhost";
		port = 8084;

		String exData = "TY_PROJ_006";

		// Store all the responses
		Response res = when()
				.get("/projects");

		// Capture the Data Using Json path 
		String actData = res.jsonPath().get("[3].projectId");
		System.out.println(actData);

		//Validate
		Assert.assertEquals(actData, exData);	
		System.out.println(actData + " Data Verified");
		res.then().log().all();
	}
}
