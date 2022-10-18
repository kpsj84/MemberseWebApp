package Memberse.WebAppAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wMembershipsTest extends WBase {
	
	@Test
	public void wMembershipsTestCase() throws InterruptedException {
		Thread.sleep(15000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		lp.Login().click();
		Thread.sleep(17000);
		
		HomePage hp = new HomePage(driver);
		hp.AccountMenu().click();
		Thread.sleep(2000);
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		amp.MembershipsSubMenu().click();
		Thread.sleep(5000);
		
		try
		{
			String verifyText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/ul[1]/li/div")).getText();
			System.out.println(verifyText);
			Assert.assertEquals(verifyText, "No memberships were found.");
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			List<WebElement> verifyActive = driver.findElements(By.xpath("(//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/ul[1]/li/div)/div"));
			int msglog = verifyActive.size()/2;
			if(msglog <1)
			{
				System.out.println("Active Memberships List is Empty");
			}
			else
			{
				System.out.println("Active Memberships List Count is : " + msglog);
			}
		}
		
		try
		{
			Thread.sleep(2000);
			String verifyText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/ul[2]/li/div")).getText();
			System.out.println(verifyText);
			Assert.assertEquals(verifyText, "No memberships were found.");
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			List<WebElement> verifyCancelled = driver.findElements(By.xpath("(//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/ul[2]/li/div)/div"));
			int msglog = verifyCancelled.size()/2;
			if(msglog < 1)
			{
				System.out.println("Cancelled Memberships List is Empty");
			}
			else
			{
				System.out.println("Cancelled Memberships List Count is : " + msglog);
			}
		}
	}

}
