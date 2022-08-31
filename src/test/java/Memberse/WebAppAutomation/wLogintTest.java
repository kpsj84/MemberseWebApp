package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
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
		String verifyText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/div/label")).getText();
		System.out.println(verifyText);
		Assert.assertEquals(verifyText, "First name");
		System.out.println("Test Case Completed");
	}

}
