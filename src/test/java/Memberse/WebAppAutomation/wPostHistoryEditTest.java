package Memberse.WebAppAutomation;

import java.util.List;
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
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPostHistoryEditTest extends WBase {
	
	@Test
	public void wPostHistoryEditTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
	    
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    u.shortDelay();
    	
		PostHistoryPage php = new PostHistoryPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(php.PostHistorySubMenu())).click();
		u.shortDelay();
    	
    	List<WebElement> buttonPosition = driver.findElements(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button"));
    	System.out.println(buttonPosition.size());
    	int buttonNos = buttonPosition.size();
    	if(buttonNos > 2)
    	{
    		php.EditPost().click();
    	}
    	else
    	{
    		driver.findElement(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[1]")).click();
    	}
        u.shortDelay();
        
        String Text= driver.findElement(By.xpath("//h3[contains(text(),'Edit Post')]")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Edit Post"); 
	    
	    ewait.until(ExpectedConditions.elementToBeClickable(php.PostDescription())).clear();
		String autotext=getSaltString();
		System.out.println(autotext);
		ewait.until(ExpectedConditions.elementToBeClickable(php.PostDescription())).sendKeys("This is a QA Description-" + autotext);
		ewait.until(ExpectedConditions.elementToBeClickable(php.SavePost())).click();
		u.loadDelay();
		
		WebElement Text1 = ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rnc__notification-content']"))));
		String text2 = Text1.getText();
		System.out.println(text2);
	    Assert.assertEquals(text2,"Success!\n" + "Operation succesfully completed.");     
	}
	
	public String getSaltString() {
		   String SALTCHARS="1234567890566";
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
