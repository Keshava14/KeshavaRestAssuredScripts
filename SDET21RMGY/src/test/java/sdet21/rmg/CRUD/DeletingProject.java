package sdet21.rmg.CRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletingProject {
	@Test
	public void deletingproject() {

		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);

		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_004");
		res.then().assertThat().statusCode(204);
		
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}
}
