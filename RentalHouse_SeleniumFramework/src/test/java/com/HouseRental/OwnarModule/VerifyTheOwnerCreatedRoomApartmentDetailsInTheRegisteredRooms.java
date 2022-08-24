package com.HouseRental.OwnarModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.Houserental.comcaste.pomrepositary.DashBoardPage;
import org.Houserental.comcaste.pomrepositary.HomePage;
import org.Houserental.comcaste.pomrepositary.LoginPage;
import org.Houserental.comcaste.pomrepositary.apartmentRegistrationPage;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HouseRental.comcast.genricutility.Excelutility;
import com.HouseRental.comcast.genricutility.FileUtility;
import com.HouseRental.comcast.genricutility.JavaUtility;
import com.HouseRental.comcast.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.AllArguments;
import okhttp3.Address;

public class VerifyTheOwnerCreatedRoomApartmentDetailsInTheRegisteredRooms {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		FileUtility flib=new FileUtility();
		Excelutility elib=new Excelutility();
		//
		String BROWSER = flib.getPropertykeyValue("Browser");
		String USERNAME = flib.getPropertykeyValue("userName");
		String PASSWORD = flib.getPropertykeyValue("password");
		String URL = flib.getPropertykeyValue("url");
		//
		int intRanNum = jlib.getRandomNumber();
		//
		String ApartmentName = elib.getExcelSheet("sheet2", 1, 0);
		String MOBILENO = elib.getExcelSheet("sheet2",1,1);
		String EMAIL = elib.getExcelSheet("sheet2",1,3);
		String PLOT = elib.getExcelSheet("sheet2",1,4);
		String COUNTRY = elib.getExcelSheet("sheet2",1,5);
		String STATE = elib.getExcelSheet("sheet2",1,6);
		String CITY = elib.getExcelSheet("sheet2",1,7);
		String LANDMARK = elib.getExcelSheet("sheet2",1,8);
		String ADDRESS = elib.getExcelSheet("sheet2",1,8);
		String RENT = elib.getExcelSheet("sheet2",5,0);
		String LOCATION = elib.getExcelSheet("sheet2",5,1);

		//
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
		HomePage hme=new HomePage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		log.getLoginBtn().click();
		log.getUserNameEdt().sendKeys(USERNAME);
		log.getPasswordEdt().sendKeys(PASSWORD);		
		log.getSubmitBtn().click();	
		dsh.getRegisterBtn().click();
		apt.getApartmentRegBtn().click();

		apt.getApartmentNameEdt().sendKeys(ApartmentName);
		apt.getMobileNumEdt().sendKeys(MOBILENO);
		apt.getEmailEdt().sendKeys(EMAIL);
		apt.getPlotNumEdt().sendKeys(PLOT);	
		apt.getCountryEdt().sendKeys(COUNTRY);	
		apt.getStateEdt().sendKeys(STATE);		
		apt.getCityEdt().sendKeys(CITY);		
		apt.getLandmarkEdt().sendKeys(LANDMARK);
		apt.getAdressEdt().sendKeys(ADDRESS);
		apt.getImageUpload().sendKeys("C:\\\\Users\\\\Admin\\\\Desktop\\\\not updated.png");
		apt.getSubmitBtn().click();
		dsh.getDetailsBtn().click();
		dsh.getHomeDashboardBtn().click();
		dsh.getRegisterRoomsLink().click();
		dsh.getHomHomeBtn().click();
		hme.getSearchBtn().click();		
		hme.getKeywordsEdt().sendKeys(RENT);	
		hme.getLocationEdt().sendKeys(LOCATION);
		hme.getSearchSearchBtn().click();
		WebElement Element = hme.getSearchSearchBtn();

		//JavascriptExecutor js=(JavascriptExecutor)driver;
		Point act = Element.getLocation();
		System.out.println(act);
		//wlib.executejavaScript(driver, "arguments[0].scrollIntoView();", Element);
		//js.executeScript("arguments[0].scrollIntoView()",Element);
		hme.searchRooms(driver, "arguments[0].scrollIntoView()", Element);
		if(Element.equals(act)) {
			System.out.println("page is scrolled");
		}
		else {
			System.out.println("page is not scroll");
		}



		hme.getdashBoardHomeBtn().click();
		dsh.getLogoutBtn().click();	
	}


}
