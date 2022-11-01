package Memberse.WebAppAutomation;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.RoleSelectionPage;
import WebPageObjects.SignupPage;
import WebPageObjects.WelcomePage;

public class wBecomeCreatorTest extends WBase {
	
	@Test
	public void WBecomeCreatorTestCase()throws InterruptedException {
		Thread.sleep(8000);
		
		String autoText=getSaltString();
		System.out.println(autoText);
		String emailDomain = "@yopmail.com";
		String email = autoText+emailDomain;
		System.out.println(email);
		String password="123456";

		WelcomePage wp = new WelcomePage(driver);
		wp.SignupButtton().click();
		Thread.sleep(4000);
		
		SignupPage sp = new SignupPage(driver);
		sp.Email().sendKeys(email);
		sp.Password().sendKeys(password);
		sp.confirmPassword().sendKeys(password);
		sp.SignupButton().click();
		Thread.sleep(5000);
		    
		wp.LoginButton().click();
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(password);
		lp.Login().click();
		Thread.sleep(12000);
		     
		RoleSelectionPage rsp = new RoleSelectionPage(driver);
	    rsp.AsaMember().click();
	    Thread.sleep(10000);
		    
		HomePage hp = new HomePage(driver);
		hp.CreatorMenu().click();
		Thread.sleep(2000);
	    
	    CreatorMenuPage cmp = new CreatorMenuPage(driver);
		cmp.checkbox().click();
		Thread.sleep(3000);
		cmp.CheckboxSave().click();
		Thread.sleep(7000);
		
		hp.CreatorMenu().click();
		String Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[1]/div[2]/div/p[1]")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"My Community");
	}
		 
	public String getSaltString() {
		   String SALTCHARS="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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
