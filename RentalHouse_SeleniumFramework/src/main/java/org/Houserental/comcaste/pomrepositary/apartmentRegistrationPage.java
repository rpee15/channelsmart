package org.Houserental.comcaste.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class apartmentRegistrationPage {
	public apartmentRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='Apartment Registration']")
	private WebElement apartmentRegBtn;
	@FindBy(xpath="//input[@id='apartment_name']")
	private WebElement apartmentNameEdt;
	@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='mobile']")
	private WebElement mobileNumEdt;
	@FindBy (xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@type='email']")
	private WebElement emailEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='plot_number']")
	private WebElement plotNumEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='country']")
	private WebElement countryEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='state']")
	private WebElement stateEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='city']")
	private WebElement cityEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='landmark']")
	private WebElement landmarkEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='address']")
	private WebElement adressEdt;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='image']")
	private WebElement imageUpload;
	@FindBy(xpath="//h2[.='Apartment Room']/parent::div[@class='alert alert-info']/descendant::button[.='Submit']")
	private WebElement submitBtn;
	public WebElement getApartmentRegBtn() {
		return apartmentRegBtn;
	}
	public WebElement getApartmentNameEdt() {
		return apartmentNameEdt;
	}
	public WebElement getMobileNumEdt() {
		return mobileNumEdt;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public WebElement getPlotNumEdt() {
		return plotNumEdt;
	}
	public WebElement getCountryEdt() {
		return countryEdt;
	}
	public WebElement getStateEdt() {
		return stateEdt;
	}
	public WebElement getCityEdt() {
		return cityEdt;
	}
	public WebElement getLandmarkEdt() {
		return landmarkEdt;
	}
	public WebElement getAdressEdt() {
		return adressEdt;
	}
	public WebElement getImageUpload() {
		return imageUpload;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void apartmentRegistration(String aptName,String mobileNUM,String Email,String plotNum,String country,String state,String city,String landmark,String adress,String image) {
		apartmentRegBtn.click();
		apartmentNameEdt.sendKeys(aptName);
		mobileNumEdt.sendKeys(mobileNUM);
		emailEdt.sendKeys(Email);
		plotNumEdt.sendKeys(plotNum);
		countryEdt.sendKeys(country);
		stateEdt.sendKeys(state);
		cityEdt.sendKeys(city);
		landmarkEdt.sendKeys(landmark);
		adressEdt.sendKeys(adress);
		imageUpload.sendKeys(image);
		submitBtn.click();
	}
}
