package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLogintTest extends WBase{
	
	@Test
	public void wLogintTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc7@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc7");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		Thread.sleep(10000);
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.AccountMenu())).click();
		
		//ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Account']")));
		//driver.findElement(By.xpath("//a[text()='Account']")).click();
		
		WebElement userInfoEmail = driver.findElement(By.xpath("//input[@name='email']"));
		String chkText = userInfoEmail.getAttribute("value");
		System.out.println(chkText);
		Assert.assertEquals(chkText, "kqatestc7@yopmail.com");
		
		System.out.println("Web Login Functionality Verification Completed");
	}

}
