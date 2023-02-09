package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginwithAppleTest extends WBase {
	
	@Test
	public void wLoginWithAppleTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.loadDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.AppleLogin())).click();
		u.shortDelay();
		
		String Text1 = driver.findElement(By.xpath("//div[@class='ac-localnav-title']")).getText(); 
		Assert.assertEquals(Text1, "Apple ID");
		
		System.out.println("Login with Apple is working fine as Button is clickable and GUI is responsive");
	}

}
	
