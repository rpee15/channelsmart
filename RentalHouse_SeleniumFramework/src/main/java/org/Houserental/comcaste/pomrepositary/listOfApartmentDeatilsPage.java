package org.Houserental.comcaste.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class listOfApartmentDeatilsPage {
	
	public listOfApartmentDeatilsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy()

}
