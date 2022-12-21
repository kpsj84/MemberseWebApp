package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseFacebookTest extends WBase {
	
	@Test
	public void wLaunchMemberseFacebookTestCase()throws InterruptedException {
		WUtilities u = new  WUtilities();
		u.timeDelayToLoadWebsite(driver);
		
		ExplorePage fb = new ExplorePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fb.FacebookIcon().click();
		Thread.sleep(3000);
		
		 String mainWindowHandle = driver.getWindowHandle();
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = allWindowHandles.iterator();
	     while (iterator.hasNext()) {
	    	 String ChildWindow = iterator.next();
	         	if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	            driver.switchTo().window(ChildWindow);
		
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	    String Text= driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/span/h1")).getText();
 		System.out.println(Text);
 		Assert.assertEquals(Text,"Memberse");
	         	}
	    }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
	}

}
