package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wForgotPasswordTest extends WBase{
	
	@Test(groups = {"Regression"}, priority=9)
	public void wSignupTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.forgotPassword())).click();
		
		String dmPageText = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='Forgot your password?']"))).getText();
		Assert.assertEquals(dmPageText, "Forgot your password?");
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Request password reset']"))).click();
		String emailvalidation = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Email is required.']"))).getText();
		Assert.assertEquals(emailvalidation, "Email is required.");
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).sendKeys("kqacreator10@yopmail");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Request password reset']"))).click();
		
		String wrongEmail = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please enter a valid email address.']"))).getText();
		Assert.assertEquals(wrongEmail, "Please enter a valid email address.");
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).clear();
		ewait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).sendKeys("kqacreator10@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Request password reset']"))).click();
		
		String checkInbox = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Check your inbox']"))).getText();
		Assert.assertEquals(checkInbox, "Check your inbox");
		
		//Test Status Flag
				super.testStatus = 1;
	}
}
