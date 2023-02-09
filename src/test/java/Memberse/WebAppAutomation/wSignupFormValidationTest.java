package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wSignupFormValidationTest extends WBase {
	
	@Test
	public void wSignupFormValidationTestCase() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //For findElement Method's
		WebDriverWait ewait =  new WebDriverWait(driver, 60);			 //For ExpectedCondtion Method's 
		
		WUtilities util = new  WUtilities(driver);
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		util.elementToBeClickable(ewait, wp.SignupButtton()).click();
		
		SignupPage sp = new SignupPage(driver);
		util.elementToBeClickable(ewait, sp.SignupButton()).click();
		
		String msg1 = driver.findElement(By.xpath("//*[text()='Email is a required field']")).getText();  
		System.out.println(msg1);
		Assert.assertEquals(msg1, "Email is a required field.");
		
		String msg2 = driver.findElement(By.xpath("//*[text()='Password must be at least 6 characters']")).getText(); 
		System.out.println(msg2);
		Assert.assertEquals(msg2, "Password must be at least 6 characters.");
		
		String msg3 = driver.findElement(By.xpath("//*[text()='Confirm Password is a required field']")).getText(); 
		System.out.println(msg3);
		Assert.assertEquals(msg3, "Confirm Password is a required field.");
		
		sp.Email().sendKeys("abc@abc");
		String msg4 = driver.findElement(By.xpath("//*[text()='Email must be a valid email']")).getText();
		System.out.println(msg4);
		Assert.assertEquals(msg4, "Email must be a valid email.");
		
		sp.Password().sendKeys("123456");
		sp.confirmPassword().sendKeys("12345");
		String msg5 = driver.findElement(By.xpath("//*[text()='Passwords must match']")).getText(); 
		System.out.println(msg5);
		Assert.assertEquals(msg5, "Passwords must match.");
		
		System.out.println("Web Signup Form Validations Verification Completed");
	}

}
