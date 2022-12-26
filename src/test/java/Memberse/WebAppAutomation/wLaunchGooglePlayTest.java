package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wLaunchGooglePlayTest extends WBase {
	
	@Test
	public void wLaunchGooglePlayTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.GooglePlayButton().click();
		Thread.sleep(3000);
		
		String originalWindow = driver.getWindowHandle();
		
		for(String windowHandle : driver.getWindowHandles())
		{
			if(!originalWindow.contentEquals(windowHandle))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		String VerifyText1 = driver.findElement(By.xpath("//*[@id=\"kO001e\"]/header/nav/a/span")).getText();
		System.out.println(VerifyText1);
		Assert.assertEquals(VerifyText1, "google_logo Play");
		driver.close();
		driver.switchTo().window(originalWindow);
	}

}
