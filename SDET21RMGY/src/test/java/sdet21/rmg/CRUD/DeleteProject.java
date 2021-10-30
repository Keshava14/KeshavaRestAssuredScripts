package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProject {

	@Test
	public void deleteProject() {
		
	// delete Single Project
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_803")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
