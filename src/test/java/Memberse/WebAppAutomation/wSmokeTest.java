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
		Thread.sleep(4000);
		
		String verifyExploreText = driver.findElement(By.xpath("//*[text()='Find your Content Creator']")).getText();
		System.out.println(verifyExploreText);
		Assert.assertEquals(verifyExploreText, "Find your Content Creator");
		
		WebElement searchField = driver.findElement(By.xpath("//*[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchField);
		String testText = "kqatest";
		searchField.sendKeys(testText);
		Thread.sleep(3000);
		
		String noResult = null;
		try
		{
			noResult = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
			System.out.println(noResult);
			Assert.assertEquals(noResult, "No results available.");
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(noResult == "No results available.")
			{
				System.out.println(noResult);
			}
			else
			{
					int Value = driver.findElements(By.xpath("(//*[@class='space-y-2'])[1]/div")).size();
					System.out.println("Results fetched from search = " + Value);
			}
		}
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(testText);
		driver.navigate().back();
		Thread.sleep(1000);
		
		wp.SignupButtton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(testText);
		driver.navigate().back();
		Thread.sleep(1000);
		
		String apps = driver.findElement(By.xpath("//p[text()='Download the Memberse app for an optimized experience']")).getText();
		Assert.assertEquals(apps, "Download the Memberse app for an optimized experience");
		System.out.println("Smoke Test Pass for Web App");
	}

}
