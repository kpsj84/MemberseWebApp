package Memberse.WebAppAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPostHistoryPlayTest extends WBase {
	
	@Test
	public void wPostHistoryPlayTestCase() throws InterruptedException {
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
    	Thread.sleep(5000);

        try
    	{
    		String Text = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
    		System.out.println(Text);
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
            	 String noResult = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]")).getText();
            	 System.out.println(noResult);
            	 Assert.assertEquals(noResult, "No results available.");
             }
             else
             {
            	 System.out.println("Got Results from the Search field");
             }
    	}	
        php.ClickOnContent().click();
        Thread.sleep(8000);
        
        String Text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div/p[1]/a")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"kqatestc3's Community");
	}

}
