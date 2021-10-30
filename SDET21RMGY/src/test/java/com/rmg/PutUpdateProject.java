
	package com.rmg;

	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.response.ValidatableResponse;
	import io.restassured.specification.RequestSpecification;

	public class PutUpdateProject {
		@Test
		public void putupdateproject() {
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Kesh");
			jobj.put("projectName", "TYSs-457");
			jobj.put("status", "Completed");
			jobj.put("teamSize", "30");

			
			RequestSpecification reqspe = RestAssured.given();
			reqspe.contentType(ContentType.JSON);
			reqspe.body(jobj);
			
			Response res = reqspe.put("http://localhost:8084/projects/TY_PROJ_203");
			ValidatableResponse validate = res.then();
			validate.assertThat().statusCode(200);
			validate.assertThat().contentType("application/json");
			validate.log().all();
		}
		
	}
