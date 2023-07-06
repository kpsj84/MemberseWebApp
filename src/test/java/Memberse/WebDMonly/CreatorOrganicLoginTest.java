package Memberse.WebDMonly;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Memberse.WebAppAutomation.WBase;
import Memberse.WebAppAutomation.WUtilities;
import WebPageObjects.DMPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class CreatorOrganicLoginTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=1)
	public void CreatorOrganicLoginTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.urlToBe("https://app-qa.memberse.com/auth/login"));
		util.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqacreator@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqacreator");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		util.apiDelay();
		
		DMPage dmp = new DMPage(driver);
		WebElement ele1 = ewait.until(ExpectedConditions.visibilityOf(dmp.creatorName()));
		String uname = ele1.getText();
		System.out.println(uname);
		Assert.assertEquals(uname, "kqacreator LN");
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
