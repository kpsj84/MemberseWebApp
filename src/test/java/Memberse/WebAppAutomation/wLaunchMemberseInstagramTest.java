package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseInstagramTest extends WBase {
	
	@Test
	public void wLaunchMemberseInstagramTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
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
	                
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     String Text= driver.findElement(By.xpath("//*[text()='Memberse | Membership Platform']")).getText();
	 	 System.out.println(Text);
	 	 Assert.assertEquals(Text,"Memberse | Membership Platform");
	                }
	         }
	        driver.close();
		    driver.switchTo().window(mainWindowHandle);
	}

}
