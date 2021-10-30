package sdet21.rmg.CRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;
/**
 * EXCEPTION :javax.xml.bind.MarshalException
 - with linked exception:
 * @author USER
 *
 */
public class CreateProjectWithXmlFomat {

	@Test
	public void createProjectWithXmlFormat() {
		baseURI = "http://localhost";
		port = 8084;
	
		// read the throgh POJO class
		ProjectLibrary pLib = new ProjectLibrary("aruvi", "Vision", "On Goging", 18);
	
		given()
		.contentType(ContentType.XML)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(500)
		.log().all();
		
	}
}
