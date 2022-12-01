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
		Thread.sleep(7000);

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
	 	 String Text= driver.findElement(By.xpath("//*[@text()='memberse.app']")).getText();
	 	 System.out.println(Text);
	 	 Assert.assertEquals(Text,"memberse.app");
	                }
	         }
		 driver.close();
		 driver.switchTo().window(mainWindowHandle);
	}

}
