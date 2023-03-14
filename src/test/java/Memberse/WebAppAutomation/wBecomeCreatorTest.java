package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void wBecomeCreatorTestCase()throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();

		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
		String autoText=getSaltString();
		System.out.println(autoText);
		String emailDomain = "@yopmail.com";
		String email = autoText+emailDomain;
		System.out.println(email);
		String password="123456";
		
		SignupPage sp = new SignupPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.confirmPassword())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(sp.SignupButton())).click();
		u.shortDelay();
		    
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys(email);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys(password);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		     
		RoleSelectionPage rsp = new RoleSelectionPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(rsp.AsaMember())).click();
	    u.apiDelay();
		    
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    
	    CreatorMenuPage cmp = new CreatorMenuPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cmp.checkbox())).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(cmp.CheckboxSave())).click();
		u.apiDelay();
		
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
		WebElement ele = ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[text()='My Community'])[1]"))));
		String Text = ele.getText();
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
