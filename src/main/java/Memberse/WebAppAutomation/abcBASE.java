package Memberse.WebAppAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class abcBASE {
	
	public static WebDriver driver;
	
	public void capabilities() {
		String driverLocation = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
		System.setProperty("webdriver.chrome.driver", driverLocation);
	}
	
	@BeforeTest
	public void InvokeCapabilities() {
		capabilities();
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	
	@BeforeClass
	public void startDriver() {
		driver = new ChromeDriver();
		driver.get("https:\\www.google.co.in");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterCode() {
		System.out.println("Test Done or Pass or Executed or FAIl");
	}
}
