package Memberse.WebAppAutomation;

import java.util.List;
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

public class wFeedsFilterTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=21)
	public void wFeedsFilterTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc4@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc4");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
		
		ewait.until(ExpectedConditions.elementToBeClickable(hp.filterButton())).click();
	    u.shortDelay();
		List<WebElement> ele = driver.findElements(By.xpath("//button[@role='switch']"));
		ele.get(1).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.filterSave())).click();
	    u.apiDelay();
	    
	    List<WebElement> ele3 = driver.findElements(By.cssSelector("p[class=' text-sm font-semibold line-clamp-1']"));
	    String Kqatestc3 = ele3.get(0).getText();
	    System.out.println(Kqatestc3);
		Assert.assertEquals(Kqatestc3,"kqatestc3's Community");
		
		//Test Status Flag
				super.testStatus = 1;
    }

}
