package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCommunityTabsTest extends WBase {
	
	@Test
	public void wCommunityTabsTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc5@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc5");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
		HomePage hp= new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.ClickOnCreator())).click();
	    u.shortDelay();
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(cp.PlaylistTab())).click();
	    u.shortDelay();
	    
	    try
	    {
	    	List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
	    	System.out.println(verifyResult2.size());
	    	int ele1 = verifyResult2.size();
	    	if(ele1>=1) 
	    	{
	    		Assert.assertEquals(ele1>=1, ele1, "Assertion failed");
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.getMessage();
	    }
	    
	    try
	    {
	    	String noResult = driver.findElement(By.xpath("//p[contains(text(),'No results available.')]")).getText();
	    	System.out.println(noResult);
	    	if(noResult.equals("No results available."))
	    	{
	    		Assert.assertEquals("No results available.", noResult);
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.getMessage();
	    }
	    
        ewait.until(ExpectedConditions.elementToBeClickable(cp.AboutTab())).click();
        u.shortDelay();
        String Text = driver.findElement(By.xpath("//a[contains(text(),'Manage memberships >')]")).getText();
		System.out.println(Text);
		Assert.assertEquals("Manage memberships >", Text);
       
		ewait.until(ExpectedConditions.elementToBeClickable(cp.FansTab())).click();
        u.shortDelay();
        List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-2']/div"));
        System.out.println(verifyResult2.size());
        int ele2 = verifyResult2.size();
        if(!(ele2>=1))
        {
        	Assert.fail();
        }
  }
	
}
