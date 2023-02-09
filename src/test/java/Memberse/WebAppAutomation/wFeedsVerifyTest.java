package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wFeedsVerifyTest extends WBase {
	
	@Test
	public void wFeedsVerifyTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc7@yopmail.com");
		lp.Password().sendKeys("kqatestc7");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
	    hp.HomeMenu().click();
		Thread.sleep(5000);
		
		String noFeeds = null;
		try
		{
			noFeeds = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/p[2]")).getText();
			System.out.println(noFeeds);
		}
		catch(Exception e)
		{
			
		}
		
		int verifyResult = 0;
		try
		{
			verifyResult = driver.findElements(By.xpath("//*[@class='space-y-2']/div")).size()-1;
	        System.out.println(verifyResult);
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
       }

}
