package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPlayAudioPostTest extends WBase {
	
	@Test
	public void wPlayAudioPostTestCase()throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestcap@yopmail.com");
		lp.Password().sendKeys("kqatestcap");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
			    
		HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(2000);
		
		PostHistoryPage php = new PostHistoryPage(driver);
        php.PostHistorySubMenu().click();
    	Thread.sleep(6000);
		
    	php.ClickOnContent().click(); //failure
        Thread.sleep(3000);
        
        String Text = driver.findElement(By.xpath("//p[text()='Auto Test - Play Audio Post']")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Auto Test - Play Audio Post");
	}      

}
