package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseTikTokTest extends WBase {
	
	@Test
	public void wLaunchMemberseTikTokTestCase()throws InterruptedException{
		Thread.sleep(10000);

		ExplorePage in = new ExplorePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		in.TikTokIcon().click();
		
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
		
		 Thread.sleep(10000);
	 	 String Text= driver.findElement(By.xpath("//img[@class='logo-text']")).getAttribute("alt");
	 	 System.out.println(Text);
	 	 Assert.assertEquals(Text,"TikTok");
	                }
	         }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
	}

}
