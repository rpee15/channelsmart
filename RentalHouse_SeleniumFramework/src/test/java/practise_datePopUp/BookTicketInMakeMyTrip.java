package practise_datePopUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookTicketInMakeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.makemytrip.com");
		driver.findElement(By.xpath("//div[@class='makeFlex column flexOne whiteText latoBold']/ancestor::div[@id='root']/descendant::span[@class='chNavIcon appendBottom2 chSprite chTrains']")).click();

		driver.findElement(By.xpath("//input[@id='travelDate']")).click();

		WebElement calender = driver.findElement(By.xpath("//div[@class='makeFlex column flexOne whiteText latoBold']/ancestor::div[@id='root']/descendant::div[@aria-label='Thu Aug 25 2022']"));
		calender.click();
		WebElement drop = driver.findElement(By.xpath("//span[@class='appendBottom5 downArrow']"));
	
		Select sel=new Select(drop);
		 sel.selectByIndex(3);
		 
	
		 
		//WebElement ele =
				//driver.findElement(By.xpath("//input[@placeholder='To']")).click();


//		Actions act=new Actions(driver);
//		act.contextClick(ele).perform();
//		act.sendKeys("bengaluru");


	}

}
