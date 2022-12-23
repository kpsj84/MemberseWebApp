package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLogintTest extends WBase{
	
	@Test
	public void wLogintTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc7@yopmail.com");
		lp.Password().sendKeys("kqatestc7");
		Thread.sleep(1000);
		lp.Login().click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		Thread.sleep(1000);
		WebElement verifyText = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div.flex-grow > div > div:nth-child(3) > form > div:nth-child(1) > div > input"));
		String chkText = verifyText.getAttribute("value");
		System.out.println(chkText);
		Assert.assertEquals(chkText, "kqatestc7@yopmail.com");
		System.out.println("Test Case Completed");
	}

}
