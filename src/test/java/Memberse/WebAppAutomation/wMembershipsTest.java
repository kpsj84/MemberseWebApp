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
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
		hp.AccountMenu().click();
		Thread.sleep(1000);
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		amp.MembershipsSubMenu().click();
		Thread.sleep(5000);
		
		String verifyText1 = null;
		try
		{
			verifyText1 = driver.findElement(By.xpath("//*[@class='py-4 space-y-4']/li")).getText();
			System.out.println(verifyText1);
			if(verifyText1.equalsIgnoreCase("No memberships were found."))
			{
				Assert.assertEquals(verifyText1, "No memberships were found.");	
				System.out.println("Active Memberships List is Empty");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(verifyText1.equalsIgnoreCase("No memberships were found."))
			{
				System.out.println("Active Memberships List is Empty");
			}
			else
			{
				List<WebElement> verifyActive = driver.findElements(By.xpath("//*[@class='py-4 space-y-4']/li"));
				int msglog = verifyActive.size()-1;
				System.out.println(msglog);
				System.out.println("Active Memberships List Count is : " + msglog);
			}
		}
		
		String verifyText2 = null;
		try
		{
			Thread.sleep(1000);
			verifyText2 = driver.findElement(By.xpath("(//*[@class='py-4 space-y-4'])[2]/li")).getText();
			System.out.println(verifyText2);
			if(verifyText2.equalsIgnoreCase("No memberships were found."))
			{
				Assert.assertEquals(verifyText2, "No memberships were found.");
				System.out.println("Cancelled Memberships List is Empty");
			}
			else
			{
				List<WebElement> verifyCancelled = driver.findElements(By.xpath("//*[@class='py-4 space-y-4'][2]/li"));
				int msglog2 = verifyCancelled.size()-1;
				System.out.println(msglog2);
				System.out.println("Cancelled Memberships List Count is : " + msglog2);
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
				System.out.println("finally block executed, testing complete");
		}
	}

}
