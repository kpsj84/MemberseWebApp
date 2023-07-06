package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

 public class wWatchedHistoryTest extends WBase {
	
	@Test(groups = {"Regression"})
	public void wWatchedHistoryTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 30);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
			
    WelcomePage wp = new WelcomePage(driver);
    ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
	
	LoginPage lp = new LoginPage(driver);
	ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
	ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
	ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
	ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
	u.apiDelay();
	
	HomePage hp = new HomePage(driver);
	ewait.until(ExpectedConditions.elementToBeClickable(hp.AccountMenu())).click();
	u.shortDelay();
	
	AccountMenuPage amp = new AccountMenuPage(driver);             
    ewait.until(ExpectedConditions.elementToBeClickable(amp.WatchedHistorySubMenu())).click();
	
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
