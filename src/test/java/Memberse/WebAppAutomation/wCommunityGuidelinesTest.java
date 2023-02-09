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

public class wCommunityGuidelinesTest extends WBase {
	
	@Test
	public void wCommunityGuidelinesTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		ExplorePage gl = new ExplorePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(gl.GuidelinesLink())).click();
		
		String mainWindowHandle = driver.getWindowHandle();
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    Iterator<String> iterator = allWindowHandles.iterator();
	    while (iterator.hasNext()) {
	           String ChildWindow = iterator.next();
	              if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
    
	     String Text= driver.findElement(By.xpath("//h1[text()='Community Guidelines']")).getText();
	     System.out.println(Text);
	     Assert.assertEquals(Text,"Community Guidelines");      
                 }
         }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
     }    

}
