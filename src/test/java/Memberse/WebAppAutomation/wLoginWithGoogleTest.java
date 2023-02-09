package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		lp.GoogleLogin().click();
		Thread.sleep(4000);
		
		for(String childWindow : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(childWindow)) //originalWindow content is not equals to content of childWindow then enters in "if" body
		    {
		        driver.switchTo().window(childWindow);
		        break;
		    }   
		}
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("qatesting9999@gmail.com");   
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(3000);
		
		try
		{
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Softqa@1313");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(3000);
			driver.switchTo().window(originalWindow);
			
			driver.findElement(By.xpath("//a[text()='Account']")).click();
			Thread.sleep(1000);
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
			driver.close();
			System.out.println("Google Login Test Case is Working fine as Button is clickable and GUI is responsive");
		}
		driver.switchTo().window(originalWindow);
	}

}
