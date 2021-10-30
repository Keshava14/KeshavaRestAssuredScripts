package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectUsingBDD {
	@Test
	public void deleteProjectUsingBDD() {

		when()
		.delete("http://localhost:8084/projects/TY_PROJ_008")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}
