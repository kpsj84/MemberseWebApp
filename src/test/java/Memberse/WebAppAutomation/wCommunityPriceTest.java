package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.MyCommunityPage;
import WebPageObjects.WelcomePage;

public class wCommunityPriceTest extends WBase {
	
	@Test
	public void wCommunityPriceTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		Thread.sleep(1000);
	    lp.ShowPassword().click();
		lp.Login().click();
	    Thread.sleep(10000);  
		
	    HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(2000);
		
		MyCommunityPage mcp = new MyCommunityPage(driver);
		mcp.MyCommunitySubMenu().click();
		Thread.sleep(2000);
		mcp.PricingTab().click();
		Thread.sleep(5000);
													  
		WebElement Price = driver.findElement(By.xpath("//p[text()='Monthly Membership Price']"));
		String ChkPrice = Price.getText();
		System.out.println(ChkPrice);
		Assert.assertEquals(ChkPrice,"Monthly Membership Price");
		Thread.sleep(2000);
		
		WebElement Text1 = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div.flex-grow > div > div.mt-4 > div > div > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.p-4.space-y-2 > div:nth-child(2) > div.text-right.space-y-1 > div > div > span"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Stripe connected");
	}

}
