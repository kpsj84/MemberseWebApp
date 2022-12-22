package Memberse.WebAppAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wFeedsVerifyTest extends WBase {
	
	@Test
	public void wFeedsVerifyTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc4@yopmail.com");
		lp.Password().sendKeys("kqatestc4");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
		
		HomePage hp = new HomePage(driver);
	    hp.HomeMenu().click();
		Thread.sleep(2000);
		
		int verifyResult = driver.findElements(By.xpath("//*[@class='space-y-2']/div")).size()-1;
        System.out.println(verifyResult);
        if(verifyResult >= 1)
        {
        	System.out.println("Feeds are available on Home Screen ");
        }
        else
        {
        	Assert.fail();	
        }
       }

}
