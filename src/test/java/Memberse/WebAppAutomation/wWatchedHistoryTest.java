package Memberse.WebAppAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

 public class wWatchedHistoryTest extends WBase {
	
	@Test
	public void wWatchedHistoryTestCase()throws InterruptedException{
	WUtilities u = new  WUtilities();
	u.timeDelayToLoadWebsite(driver);
		
    WelcomePage wp = new WelcomePage(driver);
	wp.LoginButton().click();
	Thread.sleep(1000);
	
	LoginPage lp = new LoginPage(driver);
	//lp.Email().sendKeys("autouser2@yopmail.com");
	//lp.Password().sendKeys("autouser2");
	lp.Email().sendKeys("kqatestc3@yopmail.com");
	lp.Password().sendKeys("kqatestc3");
	lp.Login().click();
    Thread.sleep(7000);  
    
    HomePage hp = new HomePage(driver);
	hp.AccountMenu().click();
	Thread.sleep(1000);
	
	AccountMenuPage amp = new AccountMenuPage(driver);             
    Thread.sleep(1000);
    amp.WatchedHistorySubMenu().click();
    Thread.sleep(5000);
	
	try
	{
		String Text = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
		System.out.println(Text);
	    Assert.assertEquals(Text,"No results available.");
	}
	catch (Exception e) 
	{
		
	}
	finally 
	{
		 List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
         int testresult2 = verifyResult2.size();
         System.out.println(verifyResult2.size());
      
         if(testresult2 == 0)
         {
        	 String Text = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
     		System.out.println(Text);
     	    Assert.assertEquals(Text,"No results available.");
     	
         }
         else
         {
        	 System.out.println("Got Results from the Search field");
        	 System.out.println(verifyResult2.size());
         }
	}	
 }

}
