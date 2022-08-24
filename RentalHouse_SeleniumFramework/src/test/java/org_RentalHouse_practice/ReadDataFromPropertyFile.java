package org_RentalHouse_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
// step1 use file input stream to load the property file 
		FileInputStream fis=new FileInputStream(".\\Data\\commonData.properties");
		//create object for properties 
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		System.out.println(url);
		String un = pro.getProperty("userName");
		System.out.println(un);
		String pwd = pro.getProperty("password");
		System.out.println(pwd);
		String bro = pro.getProperty("Browser");
		System.out.println(bro);
	}

}
