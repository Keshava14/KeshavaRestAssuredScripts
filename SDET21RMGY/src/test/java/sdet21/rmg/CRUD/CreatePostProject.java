package sdet21.rmg.CRUD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatePostProject {

	@Test
	public void createproject() {
		// Random no method
		Random ran = new Random();
		int random = ran.nextInt(10000);
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "AKS"+random);
		jobj.put("projectName", "Trmg"+random);
		jobj.put("status", "Created");
		jobj.put("teamSize", "30");

		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		reqspe.body(jobj);

		Response res = RestAssured.post("http://localhost:8084/addProject");
		res.then().assertThat()
		.statusCode(201);
		
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}
}