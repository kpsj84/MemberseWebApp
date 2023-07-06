package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wFeedsVerifyTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=20)
	public void wFeedsVerifyTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc7@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc7");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
	    hp.HomeMenu().click();
		u.shortDelay();
		
		String noFeeds = null;
		try
		{
			noFeeds = driver.findElement(By.xpath("//p[contains(text(), 'This Homepage could use some color')]")).getText();
			System.out.println(noFeeds);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		int verifyResult = 0;
		try
		{
			verifyResult = driver.findElements(By.xpath("//*[@class='space-y-2']/div")).size()-1;
	        System.out.println("Total number of Feeds are :- " + verifyResult);
		}
		catch(Exception e)
		{
			
		}
		
        if(noFeeds != null)
        {
        	System.out.println("Feeds are not available as Fan not subscribed to any Community");
        }
		else if(verifyResult >= 1)
        {
        	System.out.println("Feeds are available on Home Screen");
        }
        else
        {
        	Assert.fail();	
        }
        
      //Test Status Flag
      		super.testStatus = 1;
       }

}
