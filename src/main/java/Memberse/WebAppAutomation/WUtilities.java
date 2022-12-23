package Memberse.WebAppAutomation;

import org.openqa.selenium.WebDriver;

public class WUtilities {
	
	WebDriver localDriver;
	
	public WUtilities(WebDriver driver) {
		this.localDriver = driver;
	}
	
	public void timeDelayToLoadWebsite() throws InterruptedException {
		System.out.println("From start delay method, Website loading...");
		Thread.sleep(4000);
		System.out.println("Website loaded, Ready for Testing");
	}

}
