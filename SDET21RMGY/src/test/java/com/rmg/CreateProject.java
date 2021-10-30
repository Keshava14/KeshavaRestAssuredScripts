package com.rmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void create() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Raghu");
		jobj.put("projectName", "testyrmg");
		jobj.put("status", "On Goging");
		jobj.put("teamSize", "10");

		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		reqspe.body(jobj);
		
		Response res = reqspe.post("http://localhost:8084/addProject");
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType("application/json");
		validate.log().all();
	}
	
}
