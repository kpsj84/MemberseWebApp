package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		Thread.sleep(7000);

		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("autouser1@yopmail.com");
		lp.Password().sendKeys("autouser1");
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
		hp.AccountMenu().click();
		Thread.sleep(1000);
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		amp.ChangePasswordSubMenu().click();
		Thread.sleep(1000);

		ChangePasswordPage cpp = new ChangePasswordPage(driver);
		cpp.ChangePassword().sendKeys("autouser1");
		cpp.ConfirmPassword().sendKeys("autouser1");
		cpp.SaveButton().click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[6]/div/div/div/div[2]")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Operation succesfully completed.");
    }

}
