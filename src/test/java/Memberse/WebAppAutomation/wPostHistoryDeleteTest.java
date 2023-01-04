package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPostHistoryDeleteTest extends WBase {
	
	@Test
	public void wPostHistoryDeleteTestCase()throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		Thread.sleep(1000);
	    lp.ShowPassword().click();
		lp.Login().click();
	    Thread.sleep(10000);  
	    
	    HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(2000);
    	
		PostHistoryPage php = new PostHistoryPage(driver);
        php.PostHistorySubMenu().click();
    	Thread.sleep(10000);
    	php.DeletePost().click();
        Thread.sleep(7000);
    	  
        String Text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/button[1]/span")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Confirm");
	    Thread.sleep(3000);
	    php.DeletePostCancel().click(); 
   }

}
