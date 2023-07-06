package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wSharePostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=40)
	public void wSharePostTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc5@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc5");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
	    
	    HomePage hp= new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
	    u.loadDelay();
	    
	    //List<WebElement> shareButtons = ewait.until(ExpectedConditions.visibilityOfAllElements(hp.ShareButton()));
	    //System.out.println(shareButtons.size());
	    //shareButtons.get(1).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Share']"))).click();
	    String Text = driver.findElement(By.xpath("//*[text()='Link copied to clipboard.']")).getText();
		System.out.println(Text);
	    Thread.sleep(1000);
	    Assert.assertEquals(Text, "Link copied to clipboard.");
		Thread.sleep(1000); 
		
		//Test Status Flag
				super.testStatus = 1;
	}

}
