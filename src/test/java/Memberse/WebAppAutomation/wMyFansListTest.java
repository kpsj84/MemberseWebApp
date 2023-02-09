package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.MyFansPage;
import WebPageObjects.WelcomePage;

public class wMyFansListTest extends WBase {
	
	@Test
	public void wMyFansListTestCase()throws InterruptedException{
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
		Thread.sleep(3000);
			 
		MyFansPage mfp = new MyFansPage(driver);
		mfp.MyFansSubMenu().click();
		Thread.sleep(7000);
		String Members= driver.findElement(By.xpath("//*[text()='Members']")).getText();
		System.out.println(Members);
		Assert.assertEquals(Members,"Members");
		Thread.sleep(3000);
		
		List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
	    int testresult3 = verifyResult2.size()-1;
        System.out.println(testresult3);
		}

}
