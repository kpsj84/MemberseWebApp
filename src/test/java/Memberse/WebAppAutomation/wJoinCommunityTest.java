package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.RoleSelectionPage;
import WebPageObjects.SignupPage;
import WebPageObjects.StripePage;
import WebPageObjects.WelcomePage;

public class wJoinCommunityTest extends WBase {
	
	@Test
	public void wJoinCommunityTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 90);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    String email = autoText+emailDomain;
	    System.out.println(email);
	    String password="123456";
	    System.out.println(password);
	    
	    WelcomePage wp = new WelcomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
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
	    rsp.AsaMember().click();
	    Thread.sleep(10000);
		
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
	    
	    ExplorePage ep = new ExplorePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqatestc3");
        u.apiDelay();
        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
        u.loadDelay();
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cp.JoinButton())).click();
	    u.loadDelay();
	    
	    StripePage sp1= new StripePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(sp1.Email())).sendKeys(email);
	    ewait.until(ExpectedConditions.elementToBeClickable(sp1.CardNumber())).sendKeys("4242424242424242");
	    ewait.until(ExpectedConditions.elementToBeClickable(sp1.CardExpiry())).sendKeys("12/28");
	    ewait.until(ExpectedConditions.elementToBeClickable(sp1.CVCNumber())).sendKeys("12/28");
	    ewait.until(ExpectedConditions.elementToBeClickable(sp1.CardName())).sendKeys(autoText);
	    Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"billingCountry\"]")));
		drpCountry.selectByVisibleText("United States");
		ewait.until(ExpectedConditions.elementToBeClickable(sp1.ZipCode())).sendKeys("92126");
		u.loadDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(sp1.SubscribeButton())).click();
	    u.apiDelay();
	    
	    String Text = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thanks for your payment')]"))).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Thanks for your payment");
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

}
