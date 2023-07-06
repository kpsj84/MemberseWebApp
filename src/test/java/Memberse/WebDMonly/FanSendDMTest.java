package Memberse.WebDMonly;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Memberse.WebAppAutomation.WBase;
import Memberse.WebAppAutomation.WUtilities;
import WebPageObjects.LoginPage;
import WebPageObjects.StripePage;
import WebPageObjects.WelcomePage;

public class FanSendDMTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=3)
	public void FanSendDMTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.urlToBe("https://app-qa.memberse.com/auth/login"));
		util.shortDelay();
		
		String creatorBioLink = "https://app-qa.memberse.com/dm/@kqacreator";
		driver.get(creatorBioLink);
		util.shortDelay();
		WebElement handle = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[text()='@kqacreator'])")));
		String handleText = handle.getText();
		System.out.println(handleText);
		Assert.assertEquals(handleText, "@kqacreator");
		
		String originalWindow = driver.getWindowHandle();
		util.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.FacebookLogin())).click();
		util.loadDelay();
		
		for(String childWindow : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(childWindow)) //originalWindow content is not equals to content of childWindow then enters in "if" body
		    {
		        driver.switchTo().window(childWindow);
		        break;
		    }   
		}
		
		driver.findElement(By.id("email")).sendKeys("kamal@memberse.com");
		driver.findElement(By.id("pass")).sendKeys("kamal123");   
		driver.findElement(By.id("loginbutton")).click();
		util.apiDelay();
		util.loadDelay();
		driver.switchTo().window(originalWindow);
		
		String clockText = null;
		try 
		{
			WebElement waitClock = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Waiting for a reply from ')]")));
		    clockText = waitClock.getText();
		    System.out.println(clockText);
			Assert.assertEquals(clockText, "Waiting for a reply from @kqacreator");
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
		
		if(clockText==null)
		{
			System.out.println(clockText);
			ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='content']"))).sendKeys("I am test auto fan and sending DM to Creartor in automation process");
			ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Send')]"))).click();
			ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Confirm')]"))).click();
			
			StripePage sp = new StripePage(driver);
		    sp.Email().sendKeys("testmem@yopmail.com");
		    
		    for(Integer i=0; i<6; i++)
		    {
		    	driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys(i.toString());
		    	Thread.sleep(2000);
		    }
		    sp.PayDonationButton().click();
		    util.apiDelay();
		    
		    WebElement waitClock = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Waiting for a reply from ')]")));
		    Assert.assertEquals(waitClock.getText(), "Waiting for a reply from @kqacreator");
		}
		else
		{
			System.out.println("Fan already sent a message to creator for which awaiting reply");
		}
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
