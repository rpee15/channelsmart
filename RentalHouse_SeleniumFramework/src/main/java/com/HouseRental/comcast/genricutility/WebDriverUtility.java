package com.HouseRental.comcast.genricutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility<webElement> {
 
	public void waitForElementInDom(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	public void  waitForThePage(WebDriver driver,String partailPageURL) {
		WebDriverWait wait=new WebDriverWait(driver,IConstants.Explicitly_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	public void  waitForElementprsent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,IConstants.Explicitly_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void select(WebElement element,String option) {
		Select sel=new Select(element);
		sel.selectByVisibleText(option);
	}
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void executejavaScript(WebDriver driver,String args,webElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(args, element);
	}
	public void waitAndClick(WebElement Element) throws InterruptedException {
		int count=20;
		while(count<20) {
			try {
				Element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
				
				
			}
		}
	}
	

		
	}

