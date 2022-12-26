package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wSignupFormValidationTest extends WBase {
	
	@Test
	public void wSignupFormValidationTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(2000);
		
		SignupPage sp = new SignupPage(driver);
		sp.SignupButton().click();
		Thread.sleep(1000);
		
		String msg1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[1]/span[2]")).getText();  
		Assert.assertEquals(msg1, "Email is a required field.");
		System.out.println(msg1);
		
		String msg2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[2]/span[2]")).getText(); 
		Assert.assertEquals(msg2, "Password must be at least 6 characters.");
		System.out.println(msg2);
		
		String msg3 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[3]/span[2]")).getText(); 
		Assert.assertEquals(msg3, "Confirm Password is a required field.");
		System.out.println(msg3);
		
		sp.Email().sendKeys("abc@abc");
		Thread.sleep(1000);
		String msg4 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[1]/span[2]")).getText(); 
		Assert.assertEquals(msg4, "Email must be a valid email.");
		System.out.println(msg4);
		
		sp.Password().sendKeys("123456");
		sp.confirmPassword().sendKeys("12345");
		Thread.sleep(1000);
		String msg5 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[2]/span[2]")).getText(); 
		Assert.assertEquals(msg5, "Passwords must match.");
		System.out.println(msg5);
		
		System.out.println("Register form validations are working fine");
	}

}
