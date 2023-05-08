package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wSearchCreatorTest extends WBase {
	
	@Test
	public void wSearchCreatorTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc7@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc7");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		 
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.ExploreMenu())).click();
		
		ExplorePage ep = new ExplorePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(ep.SearchField())).sendKeys("kqatestc4");
		u.apiDelay();      
		
	    String Text= driver.findElement(By.xpath("//p[@class=' text-sm font-semibold line-clamp-1']")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"kqatestc4's Community");    
	   
	    String Text1=driver.findElement(By.xpath("//p[@class=' text-xs font-medium text-gray-5000']")).getText();
	    System.out.println(Text1);
	    Assert.assertEquals(Text1,"@kqatestc4");
	     
	    int verifyResult = driver.findElements(By.xpath("//*[@class='space-y-1']/div/div/div")).size();
        System.out.println(verifyResult);
     
        List<WebElement> verifyResult2 = driver.findElements(By.xpath("//*[@class='space-y-1']/div/div/div"));
        int testresult2 = verifyResult2.size();
        System.out.println(verifyResult2.size());
     
        if(testresult2 == 0)
        {
        	String noResult = driver.findElement(By.xpath("//*[contains(text(),'No results available.')]")).getText();
        	System.out.println(noResult);
        	Assert.assertEquals(noResult, "No results available.");
        }
        else
        {
        	System.out.println("Got Results from the Search field");
        }
        
      //Test Status Flag
      		super.testStatus = 1;
	}

}
