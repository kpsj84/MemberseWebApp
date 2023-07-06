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
import WebPageObjects.MyCommunityPage;
import WebPageObjects.WelcomePage;

public class wCommunityPriceTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=46)
	public void wCommunityPriceTestCase() throws InterruptedException {
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
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    u.shortDelay();
		
		MyCommunityPage mcp = new MyCommunityPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.MyCommunitySubMenu())).click();
		u.shortDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.PricingTab())).click();
		u.shortDelay();
													  
		WebElement Price = driver.findElement(By.xpath("//p[text()='Monthly Membership Price']"));
		String ChkPrice = Price.getText();
		System.out.println(ChkPrice);
		Assert.assertEquals(ChkPrice,"Monthly Membership Price");
		
		WebElement Text1 = driver.findElement(By.xpath("//span[text()='Stripe Connected']"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Stripe Connected");
		
		//Test Status Flag
				super.testStatus = 1;
	}

}
