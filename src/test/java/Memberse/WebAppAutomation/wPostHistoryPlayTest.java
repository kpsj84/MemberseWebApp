package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPostHistoryPlayTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=48)
	public void wPostHistoryPlayTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
	    
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    u.shortDelay();
    	
		PostHistoryPage php = new PostHistoryPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(php.PostHistorySubMenu())).click();
    	u.shortDelay();

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
    		 List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='flex-grow']/div/div[2]/div/div"));
             int testresult2 = verifyResult2.size();
             System.out.println(verifyResult2.size());
          
             if(testresult2 == 0)
             {
            	 String noResult = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
            	 System.out.println(noResult);
            	 Assert.assertEquals(noResult, "No results available.");
             }
             else
             {
            	 System.out.println("Got Results from the Search field");
             }
    	}	
        ewait.until(ExpectedConditions.elementToBeClickable(php.ClickOnContent())).click();
        u.shortDelay();
        
        String Text = driver.findElement(By.cssSelector("p[class=' text-sm font-semibold line-clamp-1']")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"kqatestc3's Community");
	    
	  //Test Status Flag
	  		super.testStatus = 1;
	}

}
