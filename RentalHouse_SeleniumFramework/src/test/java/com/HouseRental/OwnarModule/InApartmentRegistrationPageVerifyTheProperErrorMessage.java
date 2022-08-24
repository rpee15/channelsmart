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
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.HouseRental.comcast.genricutility.BaseClass;
import com.HouseRental.comcast.genricutility.Excelutility;
import com.HouseRental.comcast.genricutility.FileUtility;
import com.HouseRental.comcast.genricutility.IConstants;
import com.HouseRental.comcast.genricutility.JavaUtility;
import com.HouseRental.comcast.genricutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class InApartmentRegistrationPageVerifyTheProperErrorMessage extends BaseClass   {
	@Test

	public void InApartmentRegistrationPageVerifyTheProperErrorMessage() throws EncryptedDocumentException, IOException {

		//WebDriver driver=null;
		// step getranduNUM
		int intRanNum = Jlib.getRandomNumber();

		//read data from excel sheet
		String ApartmentName = Elib.getExcelSheet("sheet2", 1, 0);
		String MOBILENO = Elib.getExcelSheet("sheet2",1,1)+intRanNum;
		String EMAIL = Elib.getExcelSheet("sheet2",1,3)+intRanNum;
		String PLOT = Elib.getExcelSheet("sheet2",1,4)+intRanNum;
		String COUNTRY = Elib.getExcelSheet("sheet2",1,5);
		String STATE = Elib.getExcelSheet("sheet2",1,6);
		String CITY = Elib.getExcelSheet("sheet2",1,7);
		String LANDMARK = Elib.getExcelSheet("sheet2",1,8);
		String ADDRESS = Elib.getExcelSheet("sheet2",1,8);


		DashBoardPage Dsh=new DashBoardPage(driver);
		apartmentRegistrationPage apt=new apartmentRegistrationPage(driver);




		Dsh.getRegisterBtn().click();
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
		Dsh.getHomeDashboardBtn().click();

	}
	@Test
	public void verifyApartmentRegistrationPageDetails() {
		DashBoardPage dsh=new DashBoardPage(driver);	
		apartmentRegistrationPage apt=new apartmentRegistrationPage(driver);

		dsh.getRegisterBtn().click();
		apt.getApartmentRegBtn().click();
		dsh.getHomeDashboardBtn().click();

	}
	@Test
	public void VerifyIndividualRegisterPageDetails() {
		DashBoardPage dsh=new DashBoardPage(driver); 
		dsh.getRegisterBtn().click();
		dsh.getHomeDashboardBtn().click();
	}
	@Test(priority = 3)
	public void VerifyTheOwnerCreatedRoomApartmentDetailsInTheRegisteredRooms() throws EncryptedDocumentException, IOException {

		String ApartmentName = Elib.getExcelSheet("sheet2", 1, 0);
		String MOBILENO = Elib.getExcelSheet("sheet2",1,1);
		String EMAIL = Elib.getExcelSheet("sheet2",1,3);
		String PLOT = Elib.getExcelSheet("sheet2",1,4);
		String COUNTRY = Elib.getExcelSheet("sheet2",1,5);
		String STATE = Elib.getExcelSheet("sheet2",1,6);
		String CITY = Elib.getExcelSheet("sheet2",1,7);
		String LANDMARK = Elib.getExcelSheet("sheet2",1,8);
		String ADDRESS = Elib.getExcelSheet("sheet2",1,8);
		String RENT = Elib.getExcelSheet("sheet2",5,0);
		String LOCATION = Elib.getExcelSheet("sheet2",5,1);

		HomePage hme=new HomePage(driver);
		DashBoardPage dsh=new DashBoardPage(driver);
		apartmentRegistrationPage apt=new apartmentRegistrationPage(driver);


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

		Point act = Element.getLocation();
		System.out.println(act);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", Element);
		if(Element.equals(act)) {
			System.out.println("page is scrolled");
		}
		else {
			System.out.println("page is not scroll");
		}
		
		hme.getdashBoardHomeBtn().click();
	}
}
