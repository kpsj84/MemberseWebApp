package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginWithFacebookTest extends WBase {
	
	@Test
	public void wLoginWithFacebookTestCase() throws InterruptedException {
		Thread.sleep(15000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(13000);
		
		lp.FacebookLogin().click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("qatesting9999@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Softqa1313");   
		driver.findElement(By.id("loginbutton")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		try
		{
			driver.findElement(By.xpath("//a[text()='Account']")).click();
			Thread.sleep(3000);
			String msg1 = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
			System.out.println(msg1);
			Assert.assertEquals(msg1, "qatesting9999@gmail.com");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Facebook Login Test Case Completed");
		}
	}

}
