package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginWithFacebookTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=6)
	public void wLoginWithFacebookTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.apiDelay();
		
		String originalWindow = driver.getWindowHandle();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.FacebookLogin())).click();
		u.loadDelay();
		
		for(String childWindow : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(childWindow)) //originalWindow content is not equals to content of childWindow then enters in "if" body
		    {
		        driver.switchTo().window(childWindow);
		        break;
		    }   
		}
		
		driver.findElement(By.id("email")).sendKeys("qatesting9999@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Softqa1313");   
		driver.findElement(By.id("loginbutton")).click();
		u.apiDelay();
		u.loadDelay();
		driver.switchTo().window(originalWindow);
		
		try
		{
			driver.findElement(By.xpath("//a[text()='Account']")).click();
			String msg1 = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
			System.out.println(msg1);
			Assert.assertEquals(msg1, "qatesting9999@gmail.com");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Facebook Login Test Case is Working fine");
		}
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
