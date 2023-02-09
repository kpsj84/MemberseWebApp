package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wSignupTest extends WBase {
	
	@Test
	public void wSignupTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		
		SignupPage sp = new SignupPage(driver);
		u.elementToBeClickable(ewait, sp.Email()).sendKeys(email);
		u.elementToBeClickable(ewait, sp.Password()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.confirmPassword()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.SignupButton()).click();
		u.shortDelay();
		
		String succesfullText = driver.findElement(By.xpath("//p[text()='Your account has been successfully created.']")).getText(); 
		System.out.println(succesfullText);
		Assert.assertEquals(succesfullText, "Your account has been successfully created.");
		
		System.out.println("Web Signup Functionality Verification Completed");
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
