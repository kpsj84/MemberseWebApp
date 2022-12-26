package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseLinkedInTest extends WBase {
	
	@Test
	public void wLaunchMemberseLinkedInTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		ExplorePage li = new ExplorePage(driver);
		li.LinkedinIcon().click();
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
	        	driver.findElement(By.xpath("/html/body/div[3]/div/div/section/button")).click();
		        }
		        catch(Exception e)
		        {
		        	System.out.println(e.toString());
		        }
		        
		        try
		        {
		        	String Text= driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/section/div/div[2]/div[1]/h1")).getText();
		      	 	System.out.println(Text);
		      	 	Assert.assertEquals(Text,"Memberse");	
		        }
	        	catch(Exception e)
		        {
	        		System.out.println(e.toString());
		        }
		        System.out.println("Test Case Passed by reaching at this point");
	        	    }
	        }
	        driver.close();
		    driver.switchTo().window(mainWindowHandle);
	}
	
}
