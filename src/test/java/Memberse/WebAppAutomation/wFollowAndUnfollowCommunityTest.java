package Memberse.WebAppAutomation;

import java.util.Random;
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
import WebPageObjects.RoleSelectionPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wFollowAndUnfollowCommunityTest extends WBase {
	
	public String email;
	public String password;
	
	@Test(priority=1)
	public void wFollowCommunityTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		  
	    WelcomePage wp = new WelcomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    email = autoText+emailDomain;
	    System.out.println(email);
	    password = "123456";
	    System.out.println(password);
	     
	    SignupPage sp = new SignupPage(driver);
	    u.elementToBeClickable(ewait, sp.Email()).sendKeys(email);
		u.elementToBeClickable(ewait, sp.Password()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.confirmPassword()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.SignupButton()).click();
		u.shortDelay();
		
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		RoleSelectionPage rsp = new RoleSelectionPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(rsp.AsaCreator())).click();
	    u.shortDelay();
		
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
		
	    ExplorePage ep = new ExplorePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqatestc3");
        u.apiDelay();
        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
        u.loadDelay();
        
        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(cp.followCreator())).click(); 
        u.shortDelay();
        
        ewait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")));
        String text= driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
 		System.out.println(text);
 		Assert.assertEquals(text,"Operation succesfully completed.");
 		u.shortDelay();
 		
 		ewait.until(ExpectedConditions.elementToBeClickable(hp.ProfilePic())).click();
 		ewait.until(ExpectedConditions.elementToBeClickable(hp.rightSideLogout())).click();
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		u.shortDelay();
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
        	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    		WebDriverWait ewait =  new WebDriverWait(driver, 60);
    		
    		WUtilities u = new  WUtilities(driver);
    		u.shortDelay();
        
	        WelcomePage wp = new WelcomePage(driver);	
	        ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
	        
	        LoginPage lp = new LoginPage(driver);
	        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys(email);
			ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys(password);
			ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
			u.apiDelay();
			
			HomePage hp = new HomePage(driver);
			ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
			
	        ExplorePage ep = new ExplorePage(driver);
	        ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqatestc3");
	        u.apiDelay();
	        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
	        u.loadDelay();
	        
	        CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	        ewait.until(ExpectedConditions.elementToBeClickable(cp.threeDotsMenu())).click();
	        ewait.until(ExpectedConditions.elementToBeClickable(cp.Unfollowlink())).click();
	        u.shortDelay();
	        ewait.until(ExpectedConditions.elementToBeClickable(cp.ConfirmUnfollow())).click();
	        u.shortDelay();
	        
	        ewait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")));
	        String text= driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
	 		System.out.println(text);
	 		Assert.assertEquals(text,"Operation succesfully completed.");
	    }

}
