package practiceProgramm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_table_Fetching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();;
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("http://rmgtestingserver:8888/index.php?module=Users&action=Logout");
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	}

}
