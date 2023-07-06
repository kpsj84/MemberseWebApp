package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.DonatePage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.StripePage;
import WebPageObjects.ThankyouPage;
import WebPageObjects.WelcomePage;

public class wDonationTest extends WBase {

	@Test(groups = {"Regression"})
	public void wDonationTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);	
        ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
        
        LoginPage lp = new LoginPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc7@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc7");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
		
        ExplorePage ep = new ExplorePage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqacreator");
        u.apiDelay();
        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
        u.loadDelay();
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cp.donateButton())).click();
	    u.shortDelay();
	    
	    DonatePage dp = new DonatePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(dp.SelectDonateAmount())).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(dp.DonatePriceButton())).click();
	    u.apiDelay();
	    u.shortDelay();
	    
	    StripePage sp = new StripePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(sp.PayDonationButton())).click();
	    u.loadDelay();
	    
	    ThankyouPage tp = new ThankyouPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(tp.BacktoCoummunityButton())).click();
	    u.loadDelay();

	    String Text1 = driver.findElement(By.xpath("//p[contains(text(),'kqacreator')]")).getText();
	  	System.out.println(Text1);
	  	boolean check1 = Text1 !=null;
	  	Assert.assertTrue(check1);
	 }
	
}
