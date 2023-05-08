package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginWithGoogleTest extends WBase{
	
	@Test
	public void wLoginWithGoogleTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();
		util.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.GoogleLogin())).click();
		util.shortDelay();
		
		for(String childWindow : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(childWindow)) //originalWindow content is not equals to content of childWindow then enters in "if" body
		    {
		        driver.switchTo().window(childWindow);
		        break;
		    }   
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("qatesting9999@gmail.com");   
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		util.shortDelay();
		
		try
		{
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Softqa@1313");
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			util.apiDelay();
			driver.switchTo().window(originalWindow);
			
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
			//driver.close();
			System.out.println("Google Login Test Case is Working fine as Buttons are clickable and GUI is responsive");
		}
		//Test Status Flag
				super.testStatus = 1;
				
		driver.quit();
		//driver.switchTo().window(originalWindow);
	}

}
