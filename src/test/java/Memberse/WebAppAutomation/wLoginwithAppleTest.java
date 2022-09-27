package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginwithAppleTest extends WBase {
	
	@Test
	public void wLoginWithAppleTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(13000);
		lp.AppleLogin().click();
		
		
	}

}
	
