package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	    ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
	    u.shortDelay();
        
        LoginPage lp = new LoginPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc4@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc4");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
		u.loadDelay();
		
	    ExplorePage ep = new ExplorePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqatestc3");
        u.apiDelay();
        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
        u.loadDelay();
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='w-8 h-8 flex items-center justify-center'])[3]"))).click();
        ewait.until(ExpectedConditions.elementToBeClickable(cp.reportCommunity())).click();
        u.shortDelay();
        String Text = driver.findElement(By.xpath("//*[text()='Confirm']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Confirm");
		u.shortDelay();
 		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
 		
 		//Test Status Flag
  		super.testStatus = 1;
   }

}
