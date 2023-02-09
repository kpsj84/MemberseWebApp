package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wDeleteAccountTest extends WBase {
	
	@Test
	public void wDeleteAccountTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(2000);
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		
		SignupPage sp = new SignupPage(driver);
		Thread.sleep(2000);
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
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[text()='As a Creator']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Delete Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div > button > span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(4000);
		
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
