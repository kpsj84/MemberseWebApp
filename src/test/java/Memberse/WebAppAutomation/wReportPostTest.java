package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wReportPostTest extends WBase {
	
	@Test
	public void wReportPostTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc5@yopmail.com");
		lp.Password().sendKeys("kqatestc5");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
	    
	    HomePage hp= new HomePage(driver);
	    hp.HomeMenu().click();
	    Thread.sleep(6000);
        hp.ThreeDotIcon().click(); //failure
	    Thread.sleep(2000); 
        hp.ReportButton().click();
	    Thread.sleep(3000); 
	    String Text = driver.findElement(By.xpath("//*[text()='Confirm']")).getText();
		System.out.println(Text);
		Thread.sleep(2000);
		hp.CancelButton().click();
		Thread.sleep(3000);
   }

}
