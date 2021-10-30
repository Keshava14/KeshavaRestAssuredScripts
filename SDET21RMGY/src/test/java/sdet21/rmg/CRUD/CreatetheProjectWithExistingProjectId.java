package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreatetheProjectWithExistingProjectId {
	@Test
	public void createtheProjectWithExistingProjectId() {
		baseURI = "http://localhost";
		port = 8084;
	
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("rmG", "rmProject", "Created", 10);
	
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(409)
		.log().all();
	}
}
