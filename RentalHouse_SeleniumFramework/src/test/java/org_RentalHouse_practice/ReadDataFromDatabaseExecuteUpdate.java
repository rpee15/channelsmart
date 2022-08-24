package org_RentalHouse_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseExecuteUpdate {
	public static void main(String[] args) throws SQLException {
		//create a object driver class
		Driver dbDriver=new Driver();
		//register the db driver
		DriverManager.registerDriver(dbDriver);
		Connection con=null;
		//establish connection

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rental", "root", "root");
		//create statement
		Statement statement = con.createStatement();
		//execute query
		String query="insert into roomsdetails values(131,'karthi',96633792,'Hirisav_3nd_Cross'),(111,'Rakesh',212345678,'tumkur');";
		//String qury = "delete from roomsdetails where ownerID=123;";
		int result = statement.executeUpdate(query);
		System.out.println(result);

		if(result==3)
		{
			System.out.println("data sucussfully added");
		}
		else {
			System.out.println("not added");
		}
	}
}
