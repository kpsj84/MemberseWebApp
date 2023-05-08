package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.WelcomePage;

public class wSmokeTest extends WBase{
	
	@Test(groups = {"Smoke"})
	public void wSmokeTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait = new WebDriverWait(driver, 60);
		WUtilities ut = new WUtilities(driver);
		
		ewait.until(ExpectedConditions.titleContains("Memberse"));
		System.out.println("Memberse Page title verified");
		
		String email = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[@class='text-xs'])[1]"))).getText();
		Assert.assertEquals(email, "Email address");
		
		String password = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[@class='text-xs'])[2]"))).getText();
		Assert.assertEquals(password, "Password");
		
		String signup = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='text-base font-medium leading-4'])[3]"))).getText();
		Assert.assertEquals(signup, "Sign up");
		System.out.println("Signup form Web Elements verified");
		
		String attb = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-icon='facebook-f']"))).getAttribute("data-prefix");
		Assert.assertEquals(attb, "fab");
		System.out.println("Social Media Login Buttons verified");
		
		String apps = driver.findElement(By.xpath("//p[text()='Check us out online']")).getText();
		Assert.assertEquals(apps, "Check us out online");
		//int Value = driver.findElements(By.xpath("//*[@class='flex flex-1 flex-row justify-between overflow-hidden']/a")).size();
		int Value = driver.findElements(By.cssSelector("*[class*='flex flex-1 flex-row'] a")).size();
		Assert.assertEquals(Value, 4);
		System.out.println("Social Media Links verified");
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Explore')]"))).click();
		
		String verifyExploreText = driver.findElement(By.xpath("//*[text()='Find your Content Creator']")).getText();
		System.out.println(verifyExploreText);
		Assert.assertEquals(verifyExploreText, "Find your Content Creator");
		
		WebElement searchField = driver.findElement(By.xpath("//*[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchField);
		String testText = "kqa";
		searchField.sendKeys(testText);
		ut.loadDelay();
		
		String noResult = null;
		try
		{
			noResult = driver.findElement(By.xpath("//*[text()='No results available.']")).getText();
			System.out.println(noResult);
			Assert.assertEquals(noResult, "No results available.");
		}
		catch(Exception e)
		{
			e.toString();
		}
		finally
		{
			if(noResult == "No results available.")
			{
				System.out.println(noResult);
			}
			else
			{
					int Value2 = driver.findElements(By.xpath("//*[@class='space-y-1']/div/div/div")).size();
					System.out.println("Results fetched from search = " + Value2);
					Assert.assertTrue(Value2>1);
					String row1 = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[@class=' text-sm font-semibold line-clamp-1'])[1]"))).getText();
					String row1Text = row1.substring(0, 3);
					System.out.println(row1Text);
					Assert.assertEquals(row1Text, "kqa");
					System.out.println("API's are working fine");
			}
		}
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kqacreator@yopmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).click();
		String emailText = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
		Assert.assertEquals(emailText, "kqacreator@yopmail.com");
		System.out.println("Input fields & Buttons are working");
		
		//Test Status Flag
		super.testStatus = 1;
	}

}
