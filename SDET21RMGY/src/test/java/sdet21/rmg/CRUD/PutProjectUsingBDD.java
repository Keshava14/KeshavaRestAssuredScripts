package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectUsingBDD {

	@Test
	public void putProjectUsingBDD(){
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Raja");
		jobj.put("projectName", "Deepak");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "35");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_404")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
