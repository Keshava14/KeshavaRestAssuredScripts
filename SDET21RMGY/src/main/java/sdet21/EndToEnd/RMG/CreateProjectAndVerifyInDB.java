package sdet21.EndToEnd.RMG;

import com.sdet.POJOclass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdet21.GenericUtils.BaseClass;
import sdet21.GenericUtils.EndPoints;

public class CreateProjectAndVerifyInDB extends BaseClass {

	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{
		// create a project through API
		ProjectLibrary pLib = new ProjectLibrary
				("Keshava", "Firefox"+jlib.getRandom(), "Completed", 20);

		Response res = given()
				.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post(EndPoints.addProject);

		res.then()
		.log().all();

		// cspture the expected data
		String expData = rlib.getJsonData(res, "projectName");
		System.out.println(expData);

		// verify it in batabase
		String query ="select * from project";
		String actData = dlib.executeQueryAndGetData(query, 4, expData);

		//validate
		Assert.assertEquals(actData, expData);
		System.out.println("Sucessful");

	}
}			

