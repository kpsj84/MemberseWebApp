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
		Thread.sleep(10000);

		ExplorePage li = new ExplorePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		li.LinkedinIcon().click();
		
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                 
		        Thread.sleep(10000);
	        	driver.findElement(By.xpath("/html/body/div[3]/div/div/section/button")).click();
	        		
	        	Thread.sleep(5000);
	        	String Text= driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/section/div/div[2]/div[1]/h1")).getText();
	      	 	System.out.println(Text);
	      	 	Assert.assertEquals(Text,"Memberse");		
	                }
	        }
	}
	

}
