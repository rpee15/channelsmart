package com.HouseRental.OwnarModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.Houserental.comcaste.pomrepositary.DashBoardPage;
import org.Houserental.comcaste.pomrepositary.HomePage;
import org.Houserental.comcaste.pomrepositary.LoginPage;
import org.Houserental.comcaste.pomrepositary.apartmentRegistrationPage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HouseRental.comcast.genricutility.FileUtility;
import com.HouseRental.comcast.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyApartmentRegistrationPageDetails {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		String BROWSER = flib.getPropertykeyValue("Browser");
		String USERNAME = flib.getPropertykeyValue("userName");
		String PASSWORD = flib.getPropertykeyValue("password");
		String URL = flib.getPropertykeyValue("url");




		if(BROWSER.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("inavlid browser");
		}

		LoginPage log=new LoginPage(driver);
		DashBoardPage dsh=new DashBoardPage(driver);	
		apartmentRegistrationPage apt=new apartmentRegistrationPage(driver);

		driver.manage().window().maximize();
		wlib.waitForElementInDom(driver);
		driver.get(URL);

		log.getLoginBtn().click();
		log.getUserNameEdt().sendKeys(USERNAME);
		log.getPasswordEdt().sendKeys(PASSWORD);
		log.getSubmitBtn().click();
		dsh.getRegisterBtn().click();
		apt.getApartmentRegBtn().click();
		dsh.getHomeDashboardBtn().click();
		dsh.getLogoutBtn().click();

	}

}
