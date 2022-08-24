package org.Houserental.comcaste.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath="//a[.='Login']")
	private WebElement loginBtn;
	@FindBy(xpath="//input[@type='text']")
	private WebElement userNameEdt;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordEdt;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitBtn;



	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;

	}
	public void loginInTOApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
		loginBtn.click();

	}

}
