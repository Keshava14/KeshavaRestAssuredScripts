package sdet21.rmg.CRUD;
	
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

	public class GetProjectsALL {
		@Test
		public void getProjectsALL() {
			
			when()
			.get("http://localhost:8084/projects")
			
			// Get Single Project
			//.get("http://localhost:8084/projects/TY_PROJ_009")
			
			.then()
			.assertThat()
			.statusCode(200)
			.log().all();
		}
	}
