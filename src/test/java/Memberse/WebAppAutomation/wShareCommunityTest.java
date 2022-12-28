package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wShareCommunityTest extends WBase{
	
	@Test
	public void wShareCommunityTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
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
        cp.shareCommunitylink().click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String text= driver.findElement(By.cssSelector(" #__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"Link copied to clipboard.");
 		
 		hp.CreatorMenu().click();
 		Thread.sleep(1000);
 		
 		PostHistoryPage php = new PostHistoryPage(driver);
    	Thread.sleep(3000);
    	php.PostHistorySubMenu().click();
        php.createPost().click();
    	Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"news-item-form\"]/div/div[2]/div[1]/div/textarea")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        Thread.sleep(3000);
		WebElement verifysharelink = driver.findElement(By.cssSelector("#news-item-form > div > div.space-y-4 > div:nth-child(1) > div > textarea"));
		String chk = verifysharelink.getAttribute("value");
		System.out.println(chk);
     }
	
}
