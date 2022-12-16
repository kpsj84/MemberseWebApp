package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wSharePostTest extends WBase {
	
	@Test
	public void wSharePostTestCase()throws InterruptedException{
		Thread.sleep(7000);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc5@yopmail.com");
		lp.Password().sendKeys("kqatestc5");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(10000);
	    
	    HomePage hp= new HomePage(driver);
        hp.ThreeDotIcon().click();
	    Thread.sleep(2000); 
        hp.ShareButton().click();
	    Thread.sleep(2000);
	    String Text = driver.findElement(By.xpath("//*[text()='Link copied to clipboard.']")).getText();
		System.out.println(Text);
	    Thread.sleep(3000);
	    
	    hp.createPost().click();
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"news-item-form\"]/div/div[2]/div[1]/div/textarea")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        Thread.sleep(2000);
		WebElement verifysharelink = driver.findElement(By.cssSelector("#news-item-form > div > div.space-y-4 > div:nth-child(1) > div > textarea"));
		String chk = verifysharelink.getAttribute("value");
		System.out.println(chk);
		Thread.sleep(3000); 
	}

}
