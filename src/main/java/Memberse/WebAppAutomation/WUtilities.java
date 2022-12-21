package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WUtilities {
	
	WebDriver localDriver;
	
	public WebDriver timeDelayToLoadWebsite(WebDriver driver) throws InterruptedException {
		localDriver = driver;
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("From start delay method");
		return localDriver;
	}

}
