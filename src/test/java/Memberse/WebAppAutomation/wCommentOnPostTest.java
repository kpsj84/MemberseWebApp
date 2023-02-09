package Memberse.WebAppAutomation;

import java.awt.AWTException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCommentOnPostTest extends WBase {
	
	@Test
	public void wCommentOnPostTestCase()throws InterruptedException, AWTException {
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
		Thread.sleep(8000);
		
	    hp.commentOnPost().click();
	    Thread.sleep(2000);
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    
	    hp.writeComment().sendKeys("Auto generated-" + autoText);
	    Thread.sleep(2000);
	    hp.writeComment().sendKeys(Keys.ENTER);
        Thread.sleep(7000);
        
        String text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/ul/li[1]/div/div[2]/div")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Auto generated-" + autoText);
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
