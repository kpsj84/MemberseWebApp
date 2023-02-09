package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseLinkedInTest extends WBase {
	
	@Test
	public void wLaunchMemberseLinkedInTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		ExplorePage li = new ExplorePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(li.LinkedinIcon())).click();
		
		String mainWindowHandle = driver.getWindowHandle();
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = allWindowHandles.iterator();
	     while (iterator.hasNext()) 
	     {
	    	 String ChildWindow = iterator.next();
	         	if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
	         	{
	            driver.switchTo().window(ChildWindow);
	            
		        try
		        {
		        	driver.findElement(By.xpath("//icon[@class='contextual-sign-in-modal__modal-dismiss-icon lazy-loaded']")).click();
		        }
		        catch(Exception e)
		        {
		        	System.out.println(e.toString());
		        }
		        
		        try
		        {
		        	String Text= driver.findElement(By.xpath("//h1[text()='\n"+ "                    Memberse\n"+ "                    \n"+ "                  ']")).getText();
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
