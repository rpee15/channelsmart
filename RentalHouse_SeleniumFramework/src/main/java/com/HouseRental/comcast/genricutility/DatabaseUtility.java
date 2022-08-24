package com.HouseRental.comcast.genricutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	public void connectDB() {

		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(IConstants.Url_JDBC,IConstants.JDBC_USERNAME,IConstants.JDBC_PASSWORD);
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
