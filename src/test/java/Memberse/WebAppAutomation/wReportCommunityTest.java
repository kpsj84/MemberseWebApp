package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wReportCommunityTest extends WBase {
	
	@Test
	public void wReportCommunityTestCase()throws InterruptedException{
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
		hp.ExploreMenu().click();
		Thread.sleep(1000);
		
	    ExplorePage ep = new ExplorePage(driver);
        ep.SearchField().sendKeys("kqatestc3");
        Thread.sleep(7000);
        ep.ClickCreator().click();
        Thread.sleep(3000);
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        cp.threeDotsMenu().click();
        Thread.sleep(3000);
        cp.reportCommunity().click();
        Thread.sleep(3000);
        String Text = driver.findElement(By.xpath("//*[text()='Confirm']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Confirm");
		Thread.sleep(4000);
 		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(3000);
   }

}
