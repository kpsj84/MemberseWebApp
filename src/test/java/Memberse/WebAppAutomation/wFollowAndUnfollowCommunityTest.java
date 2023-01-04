package Memberse.WebAppAutomation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.RoleSelectionPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wFollowAndUnfollowCommunityTest extends WBase {
	
	public String email;
	public String password;
	
	@Test(priority=1)
	public void wFollowCommunityTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		  
	    WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(2000);
		
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    email = autoText+emailDomain;
	    System.out.println(email);
	    password = "123456";
	    System.out.println(password);
	     
	    SignupPage sp = new SignupPage(driver);
		sp.Email().sendKeys(email);
		sp.Password().sendKeys(password);
		sp.confirmPassword().sendKeys(password);
		sp.SignupButton().click();
		Thread.sleep(4000);
		
		wp.LoginButton().click();
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(7000);
		
		RoleSelectionPage rsp = new RoleSelectionPage(driver);
	    rsp.AsaCreator().click();
	    Thread.sleep(3000);
		
	    HomePage hp = new HomePage(driver);
		hp.ExploreMenu().click();
		Thread.sleep(2000);
		
	    ExplorePage ep = new ExplorePage(driver);
        ep.SearchField().sendKeys("kqatestc3");
        Thread.sleep(10000);
        ep.ClickCreator().click();
        Thread.sleep(5000);
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        cp.followCreator().click(); 
        
        WebDriverWait w = new WebDriverWait(driver,120);
        w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")));
        String text= driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"Operation succesfully completed.");
 		Thread.sleep(3000);
 		
 		hp.ProfilePic().click();
 		Thread.sleep(1000);
 		driver.findElement(By.xpath("//p[text()='Log out']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		Thread.sleep(4000);
	 }
	
        public String getSaltString() {
        	String SALTCHARS="Abcdefhijklmn0987654";
        	StringBuilder salt= new StringBuilder();
        	Random rnd =new Random();
        	while(salt.length() < 10) {//length of the random string.
        		int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        		salt.append(SALTCHARS.charAt(index));
        	}
        	String saltStr= salt.toString();
        	return saltStr;
        }  
        
        
     //2nd Test case started from here
        @Test(dependsOnMethods="wFollowCommunityTestCase")
        public void wUnfollowCommunityTestCase() throws InterruptedException { 
        Thread.sleep(3000);
        
        WelcomePage wp = new WelcomePage(driver);	
        wp.LoginButton().click();
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
		hp.ExploreMenu().click();
		Thread.sleep(2000);
		
        ExplorePage ep = new ExplorePage(driver);
        ep.SearchField().sendKeys("kqatestc3");
        Thread.sleep(10000);
        ep.ClickCreator().click();
        Thread.sleep(5000);
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        cp.threeDotsMenu().click();
        Thread.sleep(3000);
        cp.Unfollowlink().click();
        Thread.sleep(3000);
        cp.ConfirmUnfollow().click();
        WebDriverWait w = new WebDriverWait(driver,120);
        w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")));
        String text= driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"Operation succesfully completed.");
        }

}
