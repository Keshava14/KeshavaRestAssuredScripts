package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreateProjectUsingPOJO {

	@Test
	public void createProjectUsingPOJO() {
		baseURI = "http://localhost";
		port = 8084;
		
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("Vishnu", "ActionsLabs", "Completed", 25);
		
		// reaquest Specification
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		// request
		.when()
		.post("/addProject")
		
		// Validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();	
	}
}
