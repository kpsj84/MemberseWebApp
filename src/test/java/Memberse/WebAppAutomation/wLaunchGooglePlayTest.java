package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wLaunchGooglePlayTest extends WBase {
	
	@Test
	public void wLaunchGooglePlayTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
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
