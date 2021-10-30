package sdet21.rmg.CRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetProjects {
	@Test
	public void getAllProjects() {

		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);

		Response res = RestAssured.get("http://localhost:8084/projects");
		res.then().assertThat().statusCode(200);
		
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}

}
