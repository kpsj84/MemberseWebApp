package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.DMPage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.StripePage;
import WebPageObjects.WelcomePage;

public class wFanSendDMTest extends WBase {
	
	@Test(priority = 1)
	public void wFanSendDMTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);	
        ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
        u.shortDelay();
        
        LoginPage lp = new LoginPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("testmem@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("testmem");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
		u.shortDelay();
		
		ExplorePage ep = new ExplorePage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("testcre");
        u.apiDelay();
        ewait.until(ExpectedConditions.elementToBeClickable(ep.ClickCreator())).click();
        u.loadDelay();
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cp.DMButton())).click();
	    u.apiDelay();
	    u.shortDelay();
	    
	    DMPage dmp = new DMPage(driver);
	    dmp.writeMessage().click();
	    u.apiDelay();
	    
	    StripePage sp = new StripePage(driver);
	    sp.Email().sendKeys("testmem@yopmail.com");
	    
	    for(Integer i=0; i<6; i++)
	    {
	    	driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys(i.toString());
	    	Thread.sleep(2000);
	    }
	    
	    sp.PayDonationButton().click();
	    u.apiDelay();
	    
	    String textToSend = "This is auto generated text in automation test case. It should be of at least 100 words. \n \n Text is tested to be written in new line as well. Happy DM!";
	    
	    dmp.dmText().sendKeys(textToSend);
	    
	    dmp.previewButton().click();
	    dmp.sendDM().click();
	    u.apiDelay();
	    
	    WebElement waitClock = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Waiting for a reply from ')]")));
	    Assert.assertEquals(waitClock.getText(), "Waiting for a reply from @testcre");
	    
	    WebElement sentText = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Happy DM!')]")));
	    Assert.assertEquals(sentText.getText(), "This is auto generated text in automation test case. It should be of at least 100 words. \n"
	    		+ "\n"
	    		+ "Text is tested to be written in new line as well. Happy DM!");
	    
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.DMMenu())).click();
	    u.shortDelay();
	    
	    WebElement dmSent = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hidden md:flex items-center'] //div[contains(text(), 'DM sent')]")));
	    Assert.assertEquals(dmSent.getText(), "DM sent");
	    
		driver.findElement(By.xpath("//span[@class='shadow-thick cursor-pointer inline-flex items-center p-0.5 rounded-full text-sm bg-pink-2000 text-neutral-1000']")).click();
		u.shortDelay();
		driver.findElement(By.xpath("//p[text()='Log out']")).click();
		driver.findElement(By.xpath("//span[text()='Confirm']")).click();
		u.loadDelay();
		
		String verifyUrl = driver.getCurrentUrl();
		Assert.assertEquals(verifyUrl, "https://app-qa.so.fa.dog/auth/signup");
		System.out.println("Test Case Completed for Fan sendind DM");
	}
	
	
	@Test(priority = 2)
	public void wCreatorRepliedDMTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);	
        ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
        u.shortDelay();
        
        LoginPage lp = new LoginPage(driver);
        ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("testcre@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("testcre");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.DMMenu())).click();
		u.shortDelay();
		
		WebElement sendDM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hidden md:flex items-center'] //div[contains(text(), 'Send DM')]")));
	    Assert.assertEquals(sendDM.getText(), "Send DM");
	    sendDM.click();
	    
	    String textToReply = "This is auto generated DM reply in automation test case. It should be of at least 100 words. \n \n Text is tested to be written in new line as well. Happy DM replied!";
	    
	    DMPage dmp = new DMPage(driver);
	    dmp.dmText().sendKeys(textToReply);
	    dmp.previewButton().click();
	    dmp.sendDM().click();
	    u.apiDelay();
	    
	    WebElement verifyDMlocked = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'DM is locked')]")));
	    Assert.assertEquals(verifyDMlocked.getText(), "DM is locked");
	    
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.DMMenu())).click();
	    
	    WebElement verifyRepliedText = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='font-normal text-gray-4000 text-xs line-clamp-1 break-all']")));
	    Assert.assertEquals(verifyRepliedText.getText(), "You: This is auto generated DM reply in automation test case. It should be of at least 100 words. Text is tested to be written in new line as well. Happy DM replied!");
	    
	    System.out.println("Test Case Completed for Creator replied to DM");
	}

}
