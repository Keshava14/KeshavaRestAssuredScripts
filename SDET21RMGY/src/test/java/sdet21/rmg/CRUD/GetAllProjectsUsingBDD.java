package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProjectsUsingBDD {

	@Test
	public void getAllProjectsUsingBDD() {

		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
