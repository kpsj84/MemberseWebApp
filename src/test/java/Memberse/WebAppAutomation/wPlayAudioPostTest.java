package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPlayAudioPostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=38)
	public void wPlayAudioPostTestCase()throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
	    u.shortDelay();
        
        LoginPage lp = new LoginPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestcap@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestcap");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
	    	    
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
		u.shortDelay();
		
		PostHistoryPage php = new PostHistoryPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(php.PostHistorySubMenu())).click();
    	u.loadDelay();
		
    	ewait.until(ExpectedConditions.elementToBeClickable(php.ClickOnContent())).click();
        u.shortDelay();
        
        String Text = driver.findElement(By.xpath("//p[text()='Auto Test - Play Audio Post']")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Auto Test - Play Audio Post");
	    
	  //Test Status Flag
  		super.testStatus = 1;
	}      

}
