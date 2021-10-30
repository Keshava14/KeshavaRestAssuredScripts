package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;

public class UpdatetheprojectByUsingpathParameter {
	@Test
	public void updatetheprojectByUsingpathParameter() {

		// Random no method
		Random ran = new Random();
		int random = ran.nextInt(10000);
		
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("rmg3", "Vision"+random, "On Goging", 12);
	
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_809")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
