package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.MyCommunityPage;
import WebPageObjects.WelcomePage;

public class wCommunityEditInfoTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=44)
	public void wCommunityEditInfoTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		u.shortDelay();
		
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    u.shortDelay();
		
		MyCommunityPage mcp = new MyCommunityPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.MyCommunitySubMenu())).click();
		u.shortDelay();
		
        WebElement CommunityName = driver.findElement(By.name("name"));
	    String chkName = CommunityName.getAttribute("value");
	    System.out.println(chkName);
		Assert.assertEquals(chkName,"kqatestc3's Community");
		
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.EditInfoDescription())).clear();		
	    String autoText=getSaltString();
		System.out.println(autoText);
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.EditInfoDescription())).sendKeys("This is my QA Test Channel :- " + autoText);
		ewait.until(ExpectedConditions.elementToBeClickable(mcp.EditInfoTabSave())).click();
		u.shortDelay();
	    
	    String Text1 = ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")))).getText();
	    System.out.println(Text1);
        Assert.assertEquals(Text1,"Operation succesfully completed.");
        
      //Test Status Flag
      		super.testStatus = 1;
	 }
	
	 public String getSaltString() {
		  String SALTCHARS="1234567890";
		  StringBuilder salt= new StringBuilder();
		  Random rnd =new Random();
		  while(salt.length() < 5) {//length of the random string.
		  int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		  salt.append(SALTCHARS.charAt(index));
		  }
		  	String saltStr= salt.toString();
		    return saltStr;
	 }

}
