package Memberse.WebAppAutomation;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wDeleteAccountTest extends WBase {
	
	@Test
	public void wDeleteAccountTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(2000);
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		
		SignupPage sp = new SignupPage(driver);
		sp.Email().sendKeys(email);
		sp.Password().sendKeys(password);
		sp.confirmPassword().sendKeys(password);
		sp.SignupButton().click();
		Thread.sleep(4000);
		
		wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.Login().click();
		Thread.sleep(7000); //earlier 7sec
		
		driver.findElement(By.xpath("//*[text()='As a Creator']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Delete Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[2]/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(3000);
		
		String verifyUrl = driver.getCurrentUrl();
		System.out.println(verifyUrl);
		Assert.assertEquals(verifyUrl, "https://app-qa.so.fa.dog/auth/signup");
		System.out.println("Test Case Completed");
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@yopmail.com";
        return saltStr;
    }

}
