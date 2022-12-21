package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wReportPostTest extends WBase {
	
	@Test
	public void wReportPostTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities();
		u.timeDelayToLoadWebsite(driver);
		
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
        hp.ThreeDotIcon().click();
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
