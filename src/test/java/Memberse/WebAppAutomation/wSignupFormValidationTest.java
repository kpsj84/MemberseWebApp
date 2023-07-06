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
	
	@Test(groups = {"Regression"}, priority=1)
	public void wSignupFormValidationTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //For findElement Method's
		WebDriverWait ewait =  new WebDriverWait(driver, 30);			 //For ExpectedCondtion Method's 
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		util.elementToBeClickable(ewait, wp.SignupButtton()).click();
		
		SignupPage sp = new SignupPage(driver);
		util.elementToBeClickable(ewait, sp.SignupButton()).click();
		
		String msg1 = driver.findElement(By.xpath("//*[text()='Email is required.']")).getText();  
		System.out.println(msg1);
		Assert.assertEquals(msg1, "Email is required.");
		
		String msg2 = driver.findElement(By.xpath("//*[text()='Password must be at least 6 characters long.']")).getText(); 
		System.out.println(msg2);
		Assert.assertEquals(msg2, "Password must be at least 6 characters long.");
		
		String msg3 = driver.findElement(By.xpath("//*[text()='Password confirmation is required.']")).getText(); 
		System.out.println(msg3);
		Assert.assertEquals(msg3, "Password confirmation is required.");
		
		sp.Email().sendKeys("abc@abc");
		util.elementToBeClickable(ewait, sp.SignupButton()).click();
		String msg4 = driver.findElement(By.xpath("//*[text()='Please enter a valid email address.']")).getText();
		System.out.println(msg4);
		Assert.assertEquals(msg4, "Please enter a valid email address.");
		
		sp.Password().sendKeys("123456");
		sp.confirmPassword().sendKeys("12345");
		util.elementToBeClickable(ewait, sp.SignupButton()).click();
		String msg5 = driver.findElement(By.xpath("//*[text()='Passwords do not match.']")).getText(); 
		System.out.println(msg5);
		Assert.assertEquals(msg5, "Passwords do not match.");
		
		System.out.println("Web Signup Form Validations Verification Completed");
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
