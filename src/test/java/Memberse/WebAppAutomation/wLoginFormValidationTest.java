package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginFormValidationTest extends WBase{
	
	@Test
	public void wLoginFormValidationTestCase() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities util = new  WUtilities(driver);
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		util.elementToBeClickable(ewait, wp.LoginButton()).click();
		
		LoginPage lp = new LoginPage(driver);
		util.elementToBeClickable(ewait, lp.Login()).click();
		
		String msg1 = driver.findElement(By.xpath("//*[text()='Email is a required field']")).getText();  
		System.out.println(msg1);
		Assert.assertEquals(msg1, "Email is a required field.");
		
		String msg2 = driver.findElement(By.xpath("//*[text()='Password is a required field']")).getText(); 
		System.out.println(msg2);
		Assert.assertEquals(msg2, "Password is a required field.");
		
		lp.Email().sendKeys("abc@abc");
		System.out.println("After Email text box have value, Validation message goes off");
		
		lp.Password().sendKeys("123456");
		System.out.println("After password field have value, Validation message goes off");
		
		System.out.println("Web Login Form Validations Verification Done");
	}

}
