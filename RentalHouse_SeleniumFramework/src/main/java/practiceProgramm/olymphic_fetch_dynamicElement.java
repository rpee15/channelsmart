package practiceProgramm;

import java.awt.Point;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class olymphic_fetch_dynamicElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lis=new ArrayList<String>();
		lis.add("Eliud KIPCHOGE");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/");
		driver.findElement(By.xpath("//button[.='Yes, I am happy']")).click();
		String x="//a[.='Eliud KIPCHOGE']/../../../div[@class='featured-athlete__medals text-body-sm']/span[@class='result-medal result-medal--gold']";


		for(String pro:lis)
		{

			WebElement ele = driver.findElement(By.xpath(x));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			org.openqa.selenium.Point loc = ele.getLocation();
			int x1=loc.getX();
			int y = loc.getY();
			js.executeScript("window.scrollBy("+x1+", "+y+")");

			
			System.out.println(ele.getText());
		}

	}

}
