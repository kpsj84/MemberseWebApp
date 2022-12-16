package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.RoleSelectionPage;
import WebPageObjects.SignupPage;
import WebPageObjects.StripePage;
import WebPageObjects.ThankyouPage;
import WebPageObjects.WelcomePage;

public class wJoinCommunityTest extends WBase {
	
	@Test
	public void wJoinCommunityTestCase()throws InterruptedException{
	    Thread.sleep(7000);
	    
	    String autoText=getSaltString();
	    System.out.println(autoText);
	    String emailDomain = "@yopmail.com";
	    String email = autoText+emailDomain;
	    System.out.println(email);
	    String password="123456";
	    System.out.println(password);
	    
	    WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(1000);
		
		SignupPage sp = new SignupPage(driver);
		sp.Email().sendKeys(email);
		sp.Password().sendKeys(password);
		sp.confirmPassword().sendKeys(password);
		sp.SignupButton().click();
		Thread.sleep(5000);
		
		wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
			
		RoleSelectionPage rsp = new RoleSelectionPage(driver);
	    rsp.AsaMember().click();
	    Thread.sleep(10000);
		
	    HomePage hp = new HomePage(driver);
	    hp.ExploreMenu().click();
	    Thread.sleep(1000);
	    
	    ExplorePage ep = new ExplorePage(driver);
		ep.SearchField().sendKeys("kqatestc3");
		Thread.sleep(10000);      
		ep.ClickCreator().click();
	    Thread.sleep(13000);
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    cp.JoinButton().click();
	    Thread.sleep(7000);
	    
	    StripePage sp1= new StripePage(driver);
	    sp1.Email().sendKeys(email);
	    Thread.sleep(2000);
	    sp1.CardNumber().sendKeys("4242424242424242");
	    Thread.sleep(2000);
	    sp1.CardExpiry().sendKeys("12/28");
	    Thread.sleep(2000);
	    sp1.CVCNumber().sendKeys("12/28");
	    Thread.sleep(2000);
	    sp1.CardName().sendKeys(autoText);
	    Thread.sleep(2000);
	    Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"billingCountry\"]")));
		drpCountry.selectByVisibleText("United States");
		Thread.sleep(3000);
		sp1.ZipCode().sendKeys("92126");
		Thread.sleep(3000);
	    sp1.SubscribeButton().click();
	    driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
	     
	    ThankyouPage tp= new ThankyouPage(driver);
	    tp.ManageMembershipButton().click();
	    Thread.sleep(7000);
	    String Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul[1]/li/div/div[1]/div/div[2]/div/div/p")).getText();
		System.out.println(Text);
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
