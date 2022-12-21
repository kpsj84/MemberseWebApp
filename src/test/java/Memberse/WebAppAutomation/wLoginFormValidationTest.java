package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginFormValidationTest extends WBase{
	
	@Test
	public void wLoginFormValidationTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities();
		u.timeDelayToLoadWebsite(driver);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Login().click();
		Thread.sleep(1000);
		
		String msg1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[1]/span[2]")).getText();  
		Assert.assertEquals(msg1, "Email is a required field.");
		System.out.println(msg1);
		
		String msg2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[2]/span[2]")).getText(); 
		Assert.assertEquals(msg2, "Password is a required field.");
		System.out.println(msg2);
		
		lp.Email().sendKeys("abc@abc");
		Thread.sleep(1000);
		System.out.println("After Email text box have value, Validation message goes off");
		
		lp.Password().sendKeys("123456");
		Thread.sleep(1000);
		System.out.println("After password field have value, Validation message goes off");
		
		System.out.println("Email form validations are working fine");

	}

}
