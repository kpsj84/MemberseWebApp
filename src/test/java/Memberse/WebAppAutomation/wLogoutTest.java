package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLogoutTest extends WBase {
	
	@Test
	public void wLogoutTestCase() throws InterruptedException {
		Thread.sleep(15000);
		
		WelcomePage wp = new WelcomePage(driver);
		Thread.sleep(3000);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc2@yopmail.com");
		lp.Password().sendKeys("kqatestc2");
		lp.Login().click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[text()='Creator']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='shadow-thick cursor-pointer inline-flex items-center p-0.5 rounded-full text-sm bg-pink-2000 text-neutral-1000']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Log out']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(3000);
		
		String verifyUrl = driver.getCurrentUrl();
		System.out.println(verifyUrl);
		Assert.assertEquals(verifyUrl, "https://app-qa.so.fa.dog/auth/signup");
		System.out.println("Test Case Completed");
	}

}
