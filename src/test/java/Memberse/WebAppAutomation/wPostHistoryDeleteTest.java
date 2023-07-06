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

public class wPostHistoryDeleteTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=50)
	public void wPostHistoryDeleteTestCase()throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
		
		List<WebElement> buttonPosition = driver.findElements(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button"));
    	System.out.println(buttonPosition.size());
    	int buttonNos = buttonPosition.size();
    	if(buttonNos > 2)
    	{
    		php.DeletePost().click();
    	}
    	else
    	{
    		driver.findElement(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[2]")).click();
    	}
        u.loadDelay();
    	  
        String Text = driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Confirm");
	    u.shortDelay();
	    php.DeletePostCancel().click(); 
	    
	  //Test Status Flag
	  		super.testStatus = 1;
   }

}
