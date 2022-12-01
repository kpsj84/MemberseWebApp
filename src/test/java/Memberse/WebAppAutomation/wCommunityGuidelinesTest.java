package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wCommunityGuidelinesTest extends WBase {
	
	@Test
	public void wCommunityGuidelinesTestCase()throws InterruptedException{
		Thread.sleep(7000);

		ExplorePage gl = new ExplorePage(driver);
		gl.GuidelinesLink().click();
		Thread.sleep(3000);

		String mainWindowHandle = driver.getWindowHandle();
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    Iterator<String> iterator = allWindowHandles.iterator();
	    while (iterator.hasNext()) {
	           String ChildWindow = iterator.next();
	              if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
    
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     String Text= driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div/h1")).getText();
	     System.out.println(Text);
	     Assert.assertEquals(Text,"Community Guidelines");      
                 }
         }
	     driver.close();
	     driver.switchTo().window(mainWindowHandle);
     }    

}
