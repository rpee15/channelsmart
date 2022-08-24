package org_RentalHouse_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatafromDatabaseExecuteQuery {
public static void main(String[] args) throws SQLException {
	Driver dbdriver=new Driver();
	DriverManager.registerDriver(dbdriver);
	Connection connection=null;
	
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rental", "root", "root");
Statement statement = connection.createStatement();
String query="select * from roomsdetails;";
String expData="karthi";
ResultSet result = statement.executeQuery(query);
boolean flag=false;
while(result.next())
{
	String actData=result.getString(2);
	if(actData.equalsIgnoreCase(expData))
	{
		System.out.println(actData);
		flag=true;
		break;
	}
}
if(flag)
{
	System.out.println("data is present");
}
else {
	System.out.println("data not present");
}
connection.close();
}
}
