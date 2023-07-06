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

public class wTermsAndConditionsTest extends WBase{
	
	@Test(groups = {"Regression"}, priority=17)
	public void wTermsAndConditionsTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		ExplorePage tm = new ExplorePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(tm.TermLink())).click();

		 String mainWindowHandle = driver.getWindowHandle();
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = allWindowHandles.iterator();
	     while (iterator.hasNext()) 
	     {
	           String ChildWindow = iterator.next();
	               if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
	               {
	               driver.switchTo().window(ChildWindow);
    
	     String Text= driver.findElement(By.xpath("//h1[text()='Terms and Conditions']")).getText();
	     System.out.println(Text);
	     Assert.assertEquals(Text, "Terms and Conditions");      
                  }
         }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
	     
	   //Test Status Flag
			super.testStatus = 1;
     }    

}
