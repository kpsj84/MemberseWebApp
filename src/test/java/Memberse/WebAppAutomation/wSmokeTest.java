package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wSmokeTest extends WBase{
	
	@Test
	public void wSmokeTestCase() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(15000);
		
		WebElement searchField = driver.findElement(By.xpath("//*[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchField);
		String testText = "Smoke Testing is in Progress";
		searchField.sendKeys(testText);
		
		driver.findElement(By.xpath("//span[text()='Trending']")).click();
		Thread.sleep(7000);
		int Value = driver.findElements(By.className("space-y-2")).size();
		if(Value == 0)
		{
			System.out.println("Size of Result is Nill");
			Assert.assertFalse(true);
		}
		else
		{
			System.out.println(Value);
		}
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(testText);
		driver.navigate().back();
		
		wp.SignupButtton().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(testText);
		driver.navigate().back();
		Thread.sleep(3000);
		
		String apps = driver.findElement(By.xpath("//p[text()='Download the Memberse app for an optimized experience']")).getText();
		Assert.assertEquals(apps, "Download the Memberse app for an optimized experience");
		System.out.println("Smoke Test Pass for Web App");
		System.out.println("Web hook trigger one");
	}

}
