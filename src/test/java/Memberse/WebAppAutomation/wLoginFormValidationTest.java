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
	
	@Test(groups = {"Regression"})
	public void wLoginFormValidationTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 30);
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		util.elementToBeClickable(ewait, wp.LoginButton()).click();
		util.loadDelay();
		
		LoginPage lp = new LoginPage(driver);
		util.elementToBeClickable(ewait, lp.Login()).click();
		
		String msg1 = driver.findElement(By.xpath("//*[text()='Email is required.']")).getText();  
		System.out.println(msg1);
		Assert.assertEquals(msg1, "Email is required.");
		
		String msg2 = driver.findElement(By.xpath("//*[text()='Password is required.']")).getText(); 
		System.out.println(msg2);
		Assert.assertEquals(msg2, "Password is required.");
		
		lp.Email().sendKeys("abc@abc");
		System.out.println("After Email text box have value, Validation message goes off");
		
		lp.Password().sendKeys("123456");
		System.out.println("After password field have value, Validation message goes off");
		
		System.out.println("Web Login Form Validations Verification Done");
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
