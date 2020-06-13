package CoinsTimesheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpleoCoins {
	public static void main(String[] args) {
		
		System.setProperty(
				  "webdriver.chrome.driver","E:\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver(); 
		driver.get("www.google.com");
	}
	
}
