package sdet21.rmg.CRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingBDD {
	@Test
	public void createProjectUsingBDD(){
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Raja");
		jobj.put("projectName", "DeepakSB");
		jobj.put("status", "On Goging");
		jobj.put("teamSize", "20");
		
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
