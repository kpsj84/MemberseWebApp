package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wFeedsFilterTest extends WBase {
	
	@Test
	public void wFeedsFilterTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc4@yopmail.com");
		lp.Password().sendKeys("kqatestc4");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
	    hp.HomeMenu().click();
		Thread.sleep(4000);
		hp.filterButton().click();
	    Thread.sleep(2000);
	    hp.filterToggle().click();
	    Thread.sleep(2000);
	    hp.filterSave().click();
	    Thread.sleep(8000);
	    
	    String Kqatestc3 = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div:nth-child(3) > div.space-y-2 > div > div > div:nth-child(3) > div > div:nth-child(1) > div > div.flex.flex-grow > div > div > p.text-sm.font-semibold.line-clamp-1 > a")).getText();
		System.out.println(Kqatestc3);
		Assert.assertEquals(Kqatestc3,"kqatestc3's Community");
    }

}
