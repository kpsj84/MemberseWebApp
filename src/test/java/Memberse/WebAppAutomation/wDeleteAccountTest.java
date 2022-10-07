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
		Thread.sleep(15000);
		
		WelcomePage wp = new WelcomePage(driver);
		Thread.sleep(2000);
		wp.SignupButtton().click();
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		
		SignupPage sp = new SignupPage(driver);
		sp.Email().sendKeys(email);
		sp.Password().sendKeys(password);
		sp.confirmPassword().sendKeys(password);
		sp.SignupButton().click();
		Thread.sleep(5000);
		
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.Login().click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//a[text()='Creator']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Delete Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(6000);
		
		String verifyUrl = driver.getCurrentUrl();
		System.out.println(verifyUrl);
		Assert.assertEquals(verifyUrl, "https://app-qa.so.fa.dog/explore");
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
