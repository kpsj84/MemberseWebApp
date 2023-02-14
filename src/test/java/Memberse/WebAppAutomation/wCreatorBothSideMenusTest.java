package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCreatorBothSideMenusTest extends WBase {

	@Test
	public void wCreatorBothSideMenusTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc7@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc7");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
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
		
		List<WebElement> ele = driver.findElements(By.cssSelector("div[class='opacity-100 duration-1000 transition h-9 w-9 rounded-full bg-cover bg-center']"));
		ele.get(0).click();
		u.shortDelay();
		
		String editProfile = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Edit profile')]"))).getText(); //Edit profile
		System.out.println(editProfile);
		Assert.assertEquals(editProfile, "Edit profile");
		
		String creator2 = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Creator')]"))).getText(); //Creator
		System.out.println(creator2);
		Assert.assertEquals(creator2, "Creator");
		
		String logout = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Log out')]"))).getText(); //Log out
		System.out.println(logout);
		Assert.assertEquals(logout, "Log out");
	}
}
