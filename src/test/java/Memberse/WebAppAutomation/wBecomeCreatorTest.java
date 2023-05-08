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
		u.apiDelay();
		    
		String fan = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Fan')]"))).getText();
		Assert.assertEquals(fan, "Fan");
		String creator = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Creator')]"))).getText();
		Assert.assertEquals(creator, "Creator");
		ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Fan')]"))).click();
		u.shortDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button']//span[text()=\"Let's go\"])[2]"))).click();
		u.loadDelay();
		    
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    
	    CreatorMenuPage cmp = new CreatorMenuPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cmp.checkbox())).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(cmp.CheckboxSave())).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Confirm']"))).click();
		u.apiDelay();
		
		WebElement ele = ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h1[text()='1. Setup your Account']"))));
		String Text = ele.getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"1. Setup your Account");
		
		//Test Status Flag
				super.testStatus = 1;
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
