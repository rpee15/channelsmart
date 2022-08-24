package practiceProgramm;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDynamicElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<String> lis=new ArrayList<String>();
lis.add("APPLE iPhone 12 (Red, 128 GB)");
lis.add("APPLE iPhone 12 (Black, 128 GB)");
lis.add("APPLE iPhone 12 (Purple, 64 GB)");
lis.add("APPLE iPhone 12 (White, 64 GB)");
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/search?q=iphone+12&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&as-pos=1&as-type=RECENT&suggestionId=iphone+12%7CMobiles&requestId=cd0def14-518c-448f-9e53-f69dbbdb48a4&as-searchtext=iphone");
	String x="//div[.='APPLE iPhone 12 (Red, 128 GB)']/ancestor::div[2]/div[2]/descendant::div[2]/div[1]";

	for(String product:lis)
	{
		String pre = driver.findElement(By.xpath(x)).getText();
		System.out.println(pre);
	}
	
	
	
	}

}
