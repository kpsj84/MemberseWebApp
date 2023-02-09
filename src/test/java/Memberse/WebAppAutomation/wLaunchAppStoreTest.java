package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wLaunchAppStoreTest extends WBase {
	
	@Test
	public void wLaunchAppStoreTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.AppStoreButtton())).click();
		
		String originalWindow = driver.getWindowHandle();
		System.out.println(originalWindow);
		for(String childWindow : driver.getWindowHandles())
		{
			if(!originalWindow.contentEquals(childWindow))
			{
				driver.switchTo().window(childWindow);
				break;
			}
		}
		System.out.println(driver.getWindowHandle());
		
		try
		{
			driver.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		String VerifyText1 = driver.findElement(By.xpath("//span[@class='we-localnav__title__product']")).getText();
		System.out.println(VerifyText1);
		Assert.assertEquals(VerifyText1, "App Store");
		driver.close();
		driver.switchTo().window(originalWindow);
	}

}
