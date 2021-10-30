package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;

public class UpdatetheProject {

	@Test
	public void updatetheproject() {
		baseURI = "http://localhost";
		port = 8084;
		
		// Random no method
		Random ran = new Random();
		int random = ran.nextInt(10000);
	
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("Keshav", "IDea"+random, "Created", 15);
	
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.put("/projects/TY_PROJ_810")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
