package org.Houserental.comcaste.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[.='Register']")
	private WebElement registerBtn;
	@FindBy(xpath="//a[.='Home']")
	private WebElement homeDashboardBtn;
	@FindBy(xpath="//div[@role='alert']")
	private WebElement registerRoomsLink;
	@FindBy(xpath="//a[.='Details/Update']")
	private WebElement detailsBtn;
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutBtn;
	@FindBy(xpath="//a[.='Logo/Home']")
	private WebElement homHomeBtn;
	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	public WebElement getHomeDashboardBtn() {
		return homeDashboardBtn;
	}
	public WebElement getRegisterRoomsLink() {
		return registerRoomsLink;
	}
	public WebElement getDetailsBtn() {
		return detailsBtn;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public WebElement getHomHomeBtn() {
		return homHomeBtn;
	}
	public void dashBoard() {
		registerBtn.click();
		homeDashboardBtn.click();
		registerRoomsLink.click();
		detailsBtn.click();
		logoutBtn.click();
		homHomeBtn.click();
	}
	
}
