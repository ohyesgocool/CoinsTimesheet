package Timesheet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import Timesheet.Utils;

public class Firefox extends Utils {

	@Test
	public static void StartFirefox() throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		// It create firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		// This will set the true value
		profile.setAcceptUntrustedCertificates(true);
		// This will open firefox browser using above created profile
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(500);
		System.out.println(Utils.getGlobalValue("URL"));
		driver.get(Utils.getGlobalValue("URL"));
		Thread.sleep(500);
		// Firefox Successfully lauched your coins PAGE
		driver.findElement(By.id("id_username")).sendKeys(Utils.getGlobalValue("userName"));
		driver.findElement(By.id("id_password")).sendKeys(Utils.getGlobalValue("password"));
		WebElement link = driver.findElement(By.xpath("//a[starts-with(@href, '#')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", link);

		Thread.sleep(500);

		// DATE to Pick todays date from the Xpath
		Date d = new Date();
		String today = new SimpleDateFormat("dd-MMM-YYYY").format(d);
		System.out.println(new SimpleDateFormat("dd-MMM-YYYY").format(d));
		Thread.sleep(700);
		driver.findElement(By.xpath("//dt[@id=\"span_id" + today + "\"]")).click();
		// Below Codes are for clicking the add Button and selecting the task
		Thread.sleep(1700);
		driver.findElement(By.xpath("//img[@title='Add']")).click();

		Thread.sleep(500);
		driver.findElement(By.id("dproject_task")).click();

		driver.findElement(By.id("project_checkbox")).click();

		// driver.findElement(By.xpath("//input[@value='general1']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@value='Ok']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='Ok']")).click();
		// Efforts
		driver.findElement(By.xpath("//input[@class='unsave_mode hasTimepicker']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"ui-timepicker-div\"]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[3]/a"))
				.click();
		Thread.sleep(500);
		// Complete
		Select complete = new Select(driver.findElement(By.xpath("//select")));
		complete.selectByValue("100");
		if (Utils.getGlobalValue("sendApproval") == "1")
			driver.findElement(By.xpath("//input[@value='Send for approval']")).click();
	}
}
