package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;
/**
 * EXCEPTION : java.lang.IllegalArgumentException:
 *  Cannot serialize because cannot determine how to serialize content-type text/plain
 * @author USER
 *
 */
public class CreateProjectWithTextFomat {
	@Test
	public void createProjectWithTextFormat() {
		baseURI = "http://localhost";
		port = 8084;
	
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("aruvi", "Vision", "On Goging", 18);
	
		given()
		.contentType(ContentType.TEXT)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(500)
		.log().all();
	}
}
