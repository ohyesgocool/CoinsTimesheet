package Timesheet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Utils {
	static WebDriver driver;
	
	public static WebDriver lauchBrowser() throws InterruptedException, IOException
	{
		Utils u = new Utils();
		WebDriverManager.firefoxdriver().setup();
		// It create firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		// This will set the true value
		profile.setAcceptUntrustedCertificates(true);
		// This will open firefox browser using above created profile
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(500);
		System.out.println(u.getGlobalValue("URL"));
		driver.get(u.getGlobalValue("URL"));
		Thread.sleep(500);
		return driver;

	}
	
}
