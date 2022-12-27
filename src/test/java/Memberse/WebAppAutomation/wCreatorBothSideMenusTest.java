package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCreatorBothSideMenusTest extends WBase {

	@Test
	public void wCreatorBothSideMenusTestCase() throws InterruptedException {
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc7@yopmail.com");
		lp.Password().sendKeys("kqatestc7");
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
		String home = hp.HomeMenu().getText();
		System.out.println(home);
		Assert.assertEquals(home, "Home");
		
		String explore = hp.ExploreMenu().getText();
		System.out.println(explore);
		Assert.assertEquals(explore, "Explore");
		
		String account = hp.AccountMenu().getText();
		System.out.println(account);
		Assert.assertEquals(account, "Account");
		
		String creator = hp.CreatorMenu().getText();
		System.out.println(creator);
		Assert.assertEquals(creator, "Creator");
		
		driver.findElement(By.xpath("//span[@class='shadow-thick cursor-pointer inline-flex items-center p-0.5 rounded-full text-sm bg-pink-2000 text-neutral-1000']")).click();
		Thread.sleep(2000);
		String editProfile = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/a/span")).getText(); //Edit profile
		System.out.println(editProfile);
		Assert.assertEquals(editProfile, "Edit profile");
		
		String creator2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div/p[1]")).getText(); //Creator
		System.out.println(creator2);
		Assert.assertEquals(creator2, "Creator");
		
		String logout = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/div[2]/div/p[1]")).getText(); //Log out
		System.out.println(logout);
		Assert.assertEquals(logout, "Log out");
	}
}
