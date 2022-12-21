package Memberse.WebAppAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCommunityTabsTest extends WBase {
	
	@Test
	public void wCommunityTabsTestCase()throws InterruptedException{
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
	    hp.ClickOnCreator().click();
	    Thread.sleep(5000); 
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    cp.PlaylistTab().click();
	    Thread.sleep(5000);        
        List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
        System.out.println(verifyResult2.size());
        Thread.sleep(10000);
        
        cp.AboutTab().click();
        Thread.sleep(8000);
        String Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[4]/div/div[3]/div/a")).getText();
		System.out.println(Text);
		Thread.sleep(4000);
       
		cp.FansTab().click();
        Thread.sleep(8000);
        List<WebElement> verifyResult1 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
        System.out.println(verifyResult1.size());
        Thread.sleep(4000);
  }
	
}
