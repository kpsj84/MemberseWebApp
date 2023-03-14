package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.ChangePasswordPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wChangePasswordTest extends WBase {
	
	@Test
	public void wChangePasswordTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("autouser1@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("autouser1");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.AccountMenu())).click();
		u.shortDelay();
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(amp.ChangePasswordSubMenu())).click();

		ChangePasswordPage cpp = new ChangePasswordPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(cpp.ChangePassword())).sendKeys("autouser1");
		ewait.until(ExpectedConditions.elementToBeClickable(cpp.ConfirmPassword())).sendKeys("autouser1");
		ewait.until(ExpectedConditions.elementToBeClickable(cpp.SaveButton())).click();
		u.shortDelay();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='rnc__notification-content']")).getText(), "Success!\n" + "Operation succesfully completed.");
    }

}
