package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wLaunchAppStoreTest extends WBase {
	
	@Test
	public void wLaunchAppStoreTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.AppStoreButtton().click();
		Thread.sleep(3000);
		
		try
		{
			driver.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		String originalWindow = driver.getWindowHandle();
		for(String childWindow : driver.getWindowHandles())
		{
			if(!originalWindow.contentEquals(childWindow))
			{
				driver.switchTo().window(childWindow);
				break;
			}
		}
		String VerifyText1 = driver.findElement(By.xpath("//*[@id=\"localnav\"]/div/div[2]/div[1]/a/span")).getText();
		System.out.println(VerifyText1);
		Assert.assertEquals(VerifyText1, "App Store");
		driver.close();
		driver.switchTo().window(originalWindow);
	}

}
