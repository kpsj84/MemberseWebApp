package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseTikTokTest extends WBase {
	
	@Test
	public void wLaunchMemberseTikTokTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		ExplorePage in = new ExplorePage(driver);
		in.TikTokIcon().click();
		Thread.sleep(3000);
		
		 String mainWindowHandle = driver.getWindowHandle();
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	        String ChildWindow = iterator.next();
	        if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	        driver.switchTo().window(ChildWindow);
	                
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  	     
		 try
		 {
			 String Text= driver.findElement(By.xpath("//img[@class='logo-text']")).getAttribute("alt");
		 	 System.out.println(Text);
		 	 Assert.assertEquals(Text,"TikTok");	 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.toString());
		 }
	 	     }
	        System.out.println("Test Case is Passed by reaching at this point");        
	         }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
	}

}
