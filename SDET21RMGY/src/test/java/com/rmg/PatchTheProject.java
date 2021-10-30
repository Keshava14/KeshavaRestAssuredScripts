package com.rmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PatchTheProject {

	@Test
	public void patchtheproject() {
		JSONObject jobj = new JSONObject();
		jobj.put("status", "create");

		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		reqspe.body(jobj);
		
		Response res = reqspe.patch("http://localhost:8084/projects/TY_PROJ_203");
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(200);
		validate.assertThat().contentType("application/json");
		validate.log().all();
	}
}
