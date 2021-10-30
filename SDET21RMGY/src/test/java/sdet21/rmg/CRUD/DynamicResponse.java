package sdet21.rmg.CRUD;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse {

	@Test
	public void dynamicResponse() {

		baseURI = "http://localhost";
		port = 8084;

		String exData = "Created";

		// Store all the responses
		Response res = when().get("/projects");

		// Capture the all Details
		List<String> pNames = res.jsonPath().get("status");

		for(String actData : pNames)
		{
			if(actData.equalsIgnoreCase(exData))
			{

				Assert.assertEquals(actData, exData);
				System.out.println(actData +" data present");
				break;
			}
		}

		// Validation
		res.then().log().all();
	}
}
