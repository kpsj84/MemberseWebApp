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

public class wPrivacyPolicyTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=19)
	public void wPrivacyPolicyTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		ExplorePage py = new ExplorePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(py.PrivacyLink())).click();
		
		 String mainWindowHandle = driver.getWindowHandle();
	     Set<String> allWindowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = allWindowHandles.iterator();
	     while (iterator.hasNext()) 
	     {
	           String ChildWindow = iterator.next();
	              if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
	              {
	               driver.switchTo().window(ChildWindow);
    
	      String Text= driver.findElement(By.xpath("//h1[text()='Privacy Policy']")).getText();
	      System.out.println(Text);
	      Assert.assertEquals(Text,"Privacy Policy");      
               }
          }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
	     
	   //Test Status Flag
			super.testStatus = 1;
      }

}
