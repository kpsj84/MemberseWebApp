package Memberse.WebAppAutomation;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import WebPageObjects.LoginPage;

public class wLogintTest extends WBase{
	
	@Test
	public void wLogintTestCase() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Login']")).click(); 
		//ExplorePage ep = new ExplorePage(driver);
		//ep.LoginButton();
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc2@yopmail.com");
		lp.Password().sendKeys("kqatestc2");
		lp.Login().click();
		Thread.sleep(10000);
		
		//HomePage hp = new HomePage(driver);
		//hp.ProfilePic().click();
		driver.findElement(By.xpath("//a[text()='Account']")).click();
		System.out.println("Test Case Completed");
	}

}
