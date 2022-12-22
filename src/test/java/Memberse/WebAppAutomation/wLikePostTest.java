package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wLikePostTest extends WBase {
	
	@Test
	public void wLikePostTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc5@yopmail.com");
		lp.Password().sendKeys("kqatestc5");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
	    
		String likeCount = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/span")).getText();
		System.out.println(likeCount);
		Thread.sleep(2000);
	
		HomePage hp= new HomePage(driver);
		hp.LikeButton().click();
		Thread.sleep(5000);
		String newLikeCount = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/span")).getText();
		System.out.println(newLikeCount);
		Thread.sleep(2000);
		Assert.assertNotEquals(likeCount, newLikeCount);
		Thread.sleep(2000);
	}

}
