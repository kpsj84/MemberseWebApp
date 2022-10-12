package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLogintTest extends WBase{
	
	@Test
	public void wLogintTestCase() throws InterruptedException {
		Thread.sleep(15000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		lp.Login().click();
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		Thread.sleep(3000);
		String verifyText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/div/label")).getText();
		System.out.println(verifyText);
		Assert.assertEquals(verifyText, "First name");
		System.out.println("Test Case Completed");
	}

}
