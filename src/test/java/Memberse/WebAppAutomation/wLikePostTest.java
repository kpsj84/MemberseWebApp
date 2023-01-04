package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc5@yopmail.com");
		lp.Password().sendKeys("kqatestc5");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(17000);
		
		HomePage hp= new HomePage(driver);
		hp.HomeMenu().click();										    
		String likeCount = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[4]/div/div[1]/div[1]/span")).getText();
		System.out.println(likeCount);
		Thread.sleep(3000);
	
		WebDriverWait w = new WebDriverWait(driver,60);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='svg-inline--fa fa-heart fa-w-16 fa-sm cursor-pointer']")));
		hp.LikeButton().click();
		Thread.sleep(5000);
		String newLikeCount = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[4]/div/div[1]/div[1]/span")).getText();
		System.out.println(newLikeCount);
		Thread.sleep(2000);
		Assert.assertNotEquals(likeCount, newLikeCount);
	}

}
