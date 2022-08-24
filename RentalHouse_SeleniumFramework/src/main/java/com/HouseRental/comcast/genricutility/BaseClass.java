package com.HouseRental.comcast.genricutility;

import java.io.IOException;

import org.Houserental.comcaste.pomrepositary.DashBoardPage;
import org.Houserental.comcaste.pomrepositary.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public JavaUtility Jlib=new JavaUtility();
	public Excelutility Elib=new Excelutility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility Flib=new FileUtility();
	public DatabaseUtility Dlib=new DatabaseUtility();
	@BeforeSuite
	public void connectToDataBase() {
		Dlib.connectDB();
		System.out.println("succusfully connected to databse");
	}
	@BeforeClass
	public void lunchBrowser() throws IOException {
		String BROWSER = Flib.getPropertykeyValue("Browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		wlib.waitForElementInDom(driver);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void loginApplication() throws IOException {
		String USERNAME = Flib.getPropertykeyValue("userName");
		String PASSWORD = Flib.getPropertykeyValue("password");
		String URL = Flib.getPropertykeyValue("url");
		driver.get(URL);
		LoginPage log=new LoginPage(driver);
		log.getLoginBtn().click();
		log.getUserNameEdt().sendKeys(USERNAME);
		log.getPasswordEdt().sendKeys(PASSWORD);
		log.getSubmitBtn().click();
	}
	@AfterMethod
	public void logoutApplication() {
		DashBoardPage Dsh=new DashBoardPage(driver);
		Dsh.getLogoutBtn().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void DbConnectionClose() {
		System.out.println("database connection closed");
	}
}
