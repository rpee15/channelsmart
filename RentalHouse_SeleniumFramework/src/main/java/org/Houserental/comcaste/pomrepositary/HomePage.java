package org.Houserental.comcaste.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HouseRental.comcast.genricutility.WebDriverUtility;

public class HomePage  {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Search']")
	private WebElement searchBtn;
	@FindBy(id="keywords")
	private WebElement keywordsEdt;
	@FindBy(id="location")
	private WebElement locationEdt;
	@FindBy(xpath="//button[.='Search']")
	private WebElement searchSearchBtn;
	@FindBy(xpath="//a[.='Home']")
	private WebElement dashBoardHomeBtn;
	
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getKeywordsEdt() {
		return keywordsEdt;
	}
	public WebElement getLocationEdt() {
		return locationEdt;
	}
	public WebElement getSearchSearchBtn() {
		return searchSearchBtn;
	}
	public WebElement getdashBoardHomeBtn() {
		return dashBoardHomeBtn;
	}
	
	public void searchRooms(WebDriver driver,String arg,WebElement element) {
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.executejavaScript(driver, arg, element);
		searchBtn.click();
		keywordsEdt.sendKeys(arg);
		locationEdt.sendKeys(arg);
		searchSearchBtn.click();
		dashBoardHomeBtn.click();
	}
	
}
