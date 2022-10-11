package Memberse.WebAppAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;

public class wLaunchMemberseInstagramTest extends WBase {
	
	@Test
	public void wLaunchMemberseInstagramTestCase()throws InterruptedException{
		Thread.sleep(10000);

		ExplorePage in = new ExplorePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		in.InstagramIcon().click();
		
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
		
		 Thread.sleep(15000);
	 	 String Text= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/header/section/div[1]/a/h2")).getText();
	 	 System.out.println(Text);
	 	 Assert.assertEquals(Text,"memberse.app");
	                }
	         }
	}

}
