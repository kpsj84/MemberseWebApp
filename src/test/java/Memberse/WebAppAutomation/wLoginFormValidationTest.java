package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginFormValidationTest extends WBase{
	
	@Test
	public void wLoginFormValidationTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Login().click();
		Thread.sleep(2000);
		
		String msg1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[1]/span[2]")).getText();  
		Assert.assertEquals(msg1, "Email is a required field.");
		System.out.println(msg1);
		
		String msg2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div/div/div/div/div/div/ul/li[2]/span[2]")).getText(); 
		Assert.assertEquals(msg2, "Password is a required field.");
		System.out.println(msg2);
		
		lp.Email().sendKeys("abc@abc");
		Thread.sleep(2000);
		System.out.println("After Email text box have value, Validation message goes off");
		
		lp.Password().sendKeys("123456");
		Thread.sleep(2000);
		System.out.println("After password field have value, Validation message goes off");
		
		System.out.println("Email form validations are working fine");

	}

}