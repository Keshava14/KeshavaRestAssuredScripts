package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RMGPost {

	@Test
	public void createPost() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "rmG");
		jobj.put("projectName", "rmProject");
		jobj.put("status", "Created");
		jobj.put("teamSize", "10");

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}
}

