package sdet21.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Keshava
 *
 */
public class BaseClass {
	
	public DataUtility dlib = new DataUtility();
	public RestAssuredUtility rlib = new RestAssuredUtility();
	public JAVAUtility jlib = new JAVAUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		dlib.connectToDB();
		baseURI ="http://localhost";
		port =8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dlib.closeDB();
	}
}
