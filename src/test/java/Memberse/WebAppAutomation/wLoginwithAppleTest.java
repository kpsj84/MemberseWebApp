package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginwithAppleTest extends WBase {
	
	@Test
	public void wLoginWithAppleTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(13000);
		lp.AppleLogin().click();
		Thread.sleep(15000);
		
		String Text1 = driver.findElement(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[1]/span")).getText(); 
		Assert.assertEquals(Text1, "Apple ID");
		
		System.out.println("Login with Apple is working fine as Button is clickable and GUI is responsive");
	}

}
	
