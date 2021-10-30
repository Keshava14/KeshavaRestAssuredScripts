package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFILE {

	@Test
	public void createProjectUsingJSONFILE() throws IOException {
		
		FileInputStream fis = new FileInputStream("./Data.json");
		
		// request specification
		given()
		.contentType(ContentType.JSON)
		.body(fis)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		// validate
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
