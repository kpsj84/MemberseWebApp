package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseInstagramTest extends WBase {
	
	@Test
	public void wLaunchMemberseInstagramTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		ExplorePage in = new ExplorePage(driver);
		in.InstagramIcon().click();
		Thread.sleep(3000);
		
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                
		 Thread.sleep(10000);
	 	 String Text= driver.findElement(By.xpath("//*[text()='Memberse | Membership Platform']")).getText();
	 	 System.out.println(Text);
	 	 Assert.assertEquals(Text,"Memberse | Membership Platform");
	                }
	         }
		 driver.close();
		 driver.switchTo().window(mainWindowHandle);
	}

}
