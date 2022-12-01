package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.AccountMenuPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wUserInfoTest extends WBase {
	
	@Test
	public void wUserInfoTestCase() throws InterruptedException {
		Thread.sleep(7000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		
		String name = "kqatestc3";
		String email = name + "@yopmail.com";
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys(email);
		lp.Password().sendKeys(name);
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
		hp.AccountMenu().click();
		Thread.sleep(1000);
		
		AccountMenuPage amp = new AccountMenuPage(driver);
		amp.UserInfoSubMenu().click();
		Thread.sleep(1000);
	
		WebElement verifyName = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div > div.flex-grow > div > div:nth-child(1) > form > div:nth-child(2) > div > input"));
		String chk1 = verifyName.getAttribute("value").toString();
		System.out.println(chk1);
		Assert.assertEquals(chk1, name);
		
		WebElement verifyUserName = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div > div.flex-grow > div > div:nth-child(2) > form > div:nth-child(1) > div > input"));
		String chk2 = verifyUserName.getAttribute("value");
		System.out.println(chk2);
		Assert.assertEquals(chk2, name);
		
		WebElement verifyEmail = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div > div.flex-grow > div > div:nth-child(3) > form > div:nth-child(1) > div > input"));
		String chk3 = verifyEmail.getAttribute("value");
		System.out.println(chk3);
		Assert.assertEquals(chk3, email);
		
		String randomNumber = getSaltString();
		System.out.println(randomNumber);
		
		driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div > div.flex-grow > div > div:nth-child(1) > form > div:nth-child(4) > div > input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div > div.flex-grow > div > div:nth-child(1) > form > div:nth-child(4) > div > input")).sendKeys(randomNumber);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/button/span")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[6]/div/div/div/div[1]")).getText(), "Success!");
		System.out.println("Edit functionality at User Info Page is working fine");
	}
	
	public String getSaltString() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
