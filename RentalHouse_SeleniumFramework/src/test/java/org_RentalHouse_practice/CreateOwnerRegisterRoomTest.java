package org_RentalHouse_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOwnerRegisterRoomTest {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
		//read common data 
		FileInputStream fis=new FileInputStream(".\\Data\\commonData.properties");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String USERNAME = pro.getProperty("userName");
String PASSWORD = pro.getProperty("password");
String BROWSER = pro.getProperty("Browser");

//read the test data from excell sheet
FileInputStream file=new FileInputStream(".\\Data\\Test_case_template.xlsx");
Workbook wb = WorkbookFactory.create(file);
String firstName = wb.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
String MobileNumber = wb.getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
String AlterMobileNumber = wb.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
String EmailID = wb.getSheet("sheet1").getRow(1).getCell(3).getStringCellValue();
String PlotNumber = wb.getSheet("sheet1").getRow(1).getCell(4).getStringCellValue();
String AvilabeRooms = wb.getSheet("sheet1").getRow(1).getCell(5).getStringCellValue();
String country = wb.getSheet("sheet1").getRow(1).getCell(6).getStringCellValue();

String State = wb.getSheet("sheet1").getRow(1).getCell(7).getStringCellValue();


if(BROWSER.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}else if(BROWSER.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else {
	System.out.println("incorrect broswer");
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(URL);
driver.findElement(By.xpath("//a[.='Login']")).click();
driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
driver.findElement(By.xpath("//button[.='Submit']")).click();
driver.findElement(By.xpath("//a[.='Register']")).click();
driver.findElement(By.xpath("//input[@name='fullname']")).sendKeys(firstName);
driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(MobileNumber);
driver.findElement(By.xpath("(//input[@id='alternat_mobile'])[1]")).sendKeys(AlterMobileNumber);
driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys(EmailID);
driver.findElement(By.xpath("(//input[@id='plot_number'])[1]")).sendKeys(PlotNumber);
driver.findElement(By.xpath("//input[@id='rooms']")).sendKeys(AvilabeRooms);
driver.findElement(By.xpath("(//input[@type='state'])[1]")).sendKeys(State);
driver.findElement(By.xpath("(//input[@id='country'])[1]")).sendKeys(country);


	}

}
