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
import WebPageObjects.DMPage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class FanBioLinkLoginTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=2)
	public void FanBioLinkLoginTestCase() throws InterruptedException {
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
		
			util.shortDelay();
			driver.findElement(By.xpath("//img[@data-nimg='1'][1]")).click();
			driver.findElement(By.xpath("//*[contains(text(), 'My Account')]")).click();
			String msg1 = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
			System.out.println(msg1);
			Assert.assertEquals(msg1, "kamal@memberse.com");
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
