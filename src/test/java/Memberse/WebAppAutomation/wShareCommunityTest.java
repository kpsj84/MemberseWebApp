package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatePostPage;
import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wShareCommunityTest extends WBase{
	
	@Test
	public void wShareCommunityTestCase()throws InterruptedException{
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
        u.apiDelay();
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='w-8 h-8 flex items-center justify-center'])[3]"))).click();
        ewait.until(ExpectedConditions.elementToBeClickable(cp.shareCommunitylink())).click();
        u.shortDelay();
        
        String text= driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")).getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"Link copied to clipboard.");
 		
 		ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
 		u.loadDelay();
 		ewait.until(ExpectedConditions.elementToBeClickable(hp.createPost())).click();
 		
 		CreatePostPage cpp = new CreatePostPage(driver);
 		ewait.until(ExpectedConditions.elementToBeClickable(cpp.titleBox())).click();
 		u.shortDelay();
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.titleBox())).sendKeys(Keys.chord(Keys.COMMAND, "v"));
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.descriptionBox())).click();
  		WebElement verifysharelink = ewait.until(ExpectedConditions.elementToBeClickable(cpp.titleBox()));
		String chk = verifysharelink.getAttribute("value");
		System.out.println(chk);
		
		//Test Status Flag
  		super.testStatus = 1;
     }
	
}
