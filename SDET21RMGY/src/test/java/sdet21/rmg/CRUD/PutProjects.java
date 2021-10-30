package sdet21.rmg.CRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutProjects {

	@Test
	public void putProjectUpdate() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Raja");
		jobj.put("projectName", "Tyssrmg");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "30");

		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		reqspe.body(jobj);

		Response res = RestAssured.put("http://localhost:8084/projects/TY_PROJ_602");
		res.then().assertThat().statusCode(200);
		
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}
}
