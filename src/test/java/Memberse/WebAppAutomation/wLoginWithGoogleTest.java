package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLoginWithGoogleTest extends WBase{
	
	@Test
	public void wLoginWithGoogleTestCase() throws InterruptedException {
		Thread.sleep(20000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(13000);
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();
		lp.GoogleLogin().click();
		Thread.sleep(4000);
		for(String windowHandle : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(windowHandle)) 
		    {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("qatesting9999@gmail.com");   
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(3000);
		try
		{
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Softqa@1313");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(30000);
			driver.switchTo().window(originalWindow);
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		try
		{
			driver.findElement(By.xpath("//a[text()='Account']")).click();
			Thread.sleep(3000);
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
			System.out.println("Google Login Test Case Completed");
		}
	}

}
