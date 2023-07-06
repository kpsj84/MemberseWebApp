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

public class wLikePostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=41)
	public void wLikePostTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc5@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc5");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp= new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
	    u.loadDelay();
	    
		List<WebElement> countNos = driver.findElements(By.xpath("//span[@class='font-normal text-xs']"));
		String likeCount = countNos.get(0).getText();
		System.out.println(likeCount);
		u.shortDelay();
	
        List<WebElement> likeButtons = ewait.until(ExpectedConditions.visibilityOfAllElements(hp.LikeButton()));
		//System.out.println(likeButtons.size());
		likeButtons.get(0).click();
		u.loadDelay();
		
		List<WebElement> newcountNos = driver.findElements(By.xpath("//span[@class='font-normal text-xs']"));
		String newLikeCount = newcountNos.get(0).getText();
		System.out.println(newLikeCount);
		u.shortDelay();
		Assert.assertNotEquals(likeCount, newLikeCount);
		
		//Test Status Flag
				super.testStatus = 1;
	}

}
