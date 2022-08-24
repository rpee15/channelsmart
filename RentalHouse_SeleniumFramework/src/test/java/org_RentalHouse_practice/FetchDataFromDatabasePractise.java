package org_RentalHouse_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDatabasePractise {

	public static void main(String[] args) throws SQLException {
		//Create object for DB driver class
Driver dbdriver=new Driver();

//register the driver jdbc
DriverManager.registerDriver(dbdriver);
  Connection connection= null;
try {
	
//establish the connection
 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rental", "root", "root");

 //create the statement
 Statement statement = connection.createStatement();
 
 //execute the query
 
statement.executeUpdate("create table RoomsDetails(ownerID int(4) not null unique,ownerName varchar(30),phone_number int(10) not null unique,Address varchar(50));");
System.out.println("data updated succesfully");
}
finally {
connection.close();
System.out.println("connection closed");
}
	}

}
