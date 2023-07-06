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

public class wDeleteAccountTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=10)
	public void wDeleteAccountTestCase() throws InterruptedException {
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
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.confirmPassword())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.SignupButton())).click();
		u.apiDelay();
		
		String fan = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Fan')]"))).getText();
		Assert.assertEquals(fan, "Fan");
		String creator = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Creator')]"))).getText();
		Assert.assertEquals(creator, "Creator");
		ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Fan')]"))).click();
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button']//span[text()=\"Let's go\"])[2]"))).click();
		u.loadDelay();
		
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		driver.findElement(By.xpath("//p[text()='Delete Account']")).click();
		u.shortDelay();
		driver.findElement(By.xpath("//*[@class='text-base font-medium leading-4']")).click();
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		u.apiDelay();
		u.loadDelay();
		
		String verifyUrl = driver.getCurrentUrl();
		System.out.println(verifyUrl);
		Assert.assertEquals(verifyUrl, "https://app-qa.memberse.com/auth/signup");
		System.out.println("Test Case Completed");
		
		//Test Status Flag
		super.testStatus = 1;
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
