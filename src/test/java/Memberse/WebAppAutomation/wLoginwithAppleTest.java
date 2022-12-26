package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginwithAppleTest extends WBase {
	
	@Test
	public void wLoginWithAppleTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.AppleLogin().click();
		Thread.sleep(2000);
		
		String Text1 = driver.findElement(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[1]/span")).getText(); 
		Assert.assertEquals(Text1, "Apple ID");
		
		System.out.println("Login with Apple is working fine as Button is clickable and GUI is responsive");
	}

}
	
