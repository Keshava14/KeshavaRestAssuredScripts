package com.rmg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProjects {

	@Test
	public void getAllProjects() {
	Response response = RestAssured.get("http://localhost:8084/projects");
	System.out.println(response.getContentType());
	System.out.println(response.getTime());
	System.out.println(response.statusCode());

	ValidatableResponse validate = response.then();
	validate.assertThat().statusCode(200);
	validate.assertThat().contentType("application/json");
	response.prettyPrint();
	validate.log().all();
	
	}
}
