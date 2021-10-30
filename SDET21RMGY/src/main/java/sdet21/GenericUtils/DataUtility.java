package sdet21.GenericUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contains generic methods to access database connection
 * @author Keshava
 *
 */
public class DataUtility {
	Driver driver;
	Connection con;
	ResultSet result;
	
	/**
	 * This method will get connection to database
	 * @throws Throwable 
	 */
	public void connectToDB() throws Throwable {
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	/**
	 *This method will close the database connection 
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	/**
	 * This method will execute select query and return the value
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return 
	 * @throws SQLException 
	 */
	public String executeQueryAndGetData(String query, int columnIndex,String expData) throws SQLException {
		
		Boolean  flag = false;
		result = con.createStatement().executeQuery(query);
		
		while(result.next()) {
			String actData = result.getString(columnIndex);
		if(actData.equalsIgnoreCase(expData)){
			flag = true;
			break;
			}
		}
		if(flag) {
			System.out.println(expData + " data verified successfully");
			return expData;
		}else {
		return expData;
		}
	}
}
