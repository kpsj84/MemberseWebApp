package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wMemberInfoTest extends WBase {
	
	@Test
	public void wMemberInfoTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.AccountMenu())).click();
		u.shortDelay();
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(amp.UserInfoSubMenu())).click();
		u.shortDelay();
	
		WebElement verifyName = driver.findElement(By.xpath("//input[@name='first_name']"));
		String chk1 = verifyName.getAttribute("value");
		System.out.println(chk1);
		Assert.assertEquals(chk1, "kqatestc3");
		
		WebElement verifyUserName = driver.findElement(By.xpath("//input[@name='username']"));
		String chk2 = verifyUserName.getAttribute("value");
		System.out.println(chk2);
		Assert.assertEquals(chk2, "kqatestc3");
		
		WebElement verifyEmail = driver.findElement(By.xpath("//input[@name='email']"));
		String chk3 = verifyEmail.getAttribute("value");
		System.out.println(chk3);
		Assert.assertEquals(chk3, "kqatestc3@yopmail.com");
		
		String randomNumber = getSaltString();
		System.out.println(randomNumber);
		
		driver.findElement(By.xpath("//input[@name='phone']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(randomNumber);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		u.loadDelay();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")).getText(), "Operation succesfully completed.");
		System.out.println("Edit functionality at User Info Page is working fine");
		
		//Test Status Flag
		super.testStatus = 1;
	}
	
	public String getSaltString() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	public String getRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";   //Characters from string to build
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 10) { 							  //decide length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());//nextFloat() returns random number from 0.0 to 1.0
            builder.append(characters.charAt(index));				  //Add up characters into builder at that index
        }
        String autoString = builder.toString();						  //String Builder object value converts to String. 
        return autoString;
	}

}
