package Memberse.WebAppAutomation;

import java.awt.AWTException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCommentOnPostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=42)
	public void wCommentOnPostTestCase()throws InterruptedException, AWTException {
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
		
		HomePage hp= new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
	    u.loadDelay();
		
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.commentOnPost())).click();
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.writeComment())).sendKeys("Auto Comment - " + autoText);
	    u.shortDelay();
	    hp.writeComment().sendKeys(Keys.ENTER);
        u.apiDelay();
	    u.loadDelay();
        
        String text = driver.findElement(By.xpath("//p[@class='text-base font-normal leading-5']")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Auto Comment - " + autoText);
        
      //Test Status Flag
      		super.testStatus = 1;
	}
	
	
	public String getSaltString() {
		String SALTCHARS="123456789";
		StringBuilder salt= new StringBuilder();
		Random rnd =new Random();
		while(salt.length() < 4) {//length of the random string.
		int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		salt.append(SALTCHARS.charAt(index));
		}
		String saltStr= salt.toString();
		return saltStr;
   }

}
