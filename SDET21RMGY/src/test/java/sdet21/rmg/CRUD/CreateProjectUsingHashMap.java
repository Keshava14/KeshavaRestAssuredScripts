package sdet21.rmg.CRUD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

public class CreateProjectUsingHashMap {

	@Test
	public void createprojectusingHashMap() {
		
		HashMap map = new HashMap();
		map.put("createBy", "KES");
		map.put("projectName", "CARdekho");
		map.put("status", "On Goging");
		map.put("teamSize", "24");
		
		// request specification
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		// validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	
	}
}
