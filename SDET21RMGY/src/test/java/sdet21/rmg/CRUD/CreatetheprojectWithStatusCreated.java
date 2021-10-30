package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;
import sdet21.GenericUtils.JAVAUtility;

public class CreatetheprojectWithStatusCreated {

	@Test
	public void createtheprojectWithStatusCreated() {
		baseURI = "http://localhost";
		port = 8084;

		JAVAUtility jLib = new JAVAUtility();

		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("KeshavaN", "RMG"+jLib.getRandom(), "On Going", 20);

		given()
		.contentType(ContentType.JSON)
		.body(pLib)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.log().all();

		when()
		.get("/projects")

		.then()
		.assertThat()
		.statusCode(200)
		.log().all();


	}	
}