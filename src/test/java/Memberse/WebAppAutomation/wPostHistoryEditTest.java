package Memberse.WebAppAutomation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wPostHistoryEditTest extends WBase {
	
	@Test
	public void wPostHistoryEditTestCase()throws InterruptedException{
		Thread.sleep(8000);
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(4000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		Thread.sleep(1000);
	    lp.ShowPassword().click();
		lp.Login().click();
	    Thread.sleep(15000);  
	    
	    HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(3000);
    	
		PostHistoryPage php = new PostHistoryPage(driver);
        php.PostHistorySubMenu().click();
    	Thread.sleep(10000);
    	php.EditPost().click();
        Thread.sleep(8000);
        
        String Text= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[1]/h3")).getText();
	    System.out.println(Text);
	    Assert.assertEquals(Text,"Edit Post"); 
	    
		php.PostDescription().clear();
		String autotext=getSaltString();
		System.out.println(autotext);
		php.PostDescription().sendKeys("This is a QA Description-" + autotext);
		php.SavePost().click();
		Thread.sleep(7000);
		
		WebElement Text1 = driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message"));
		String text2 = Text1.getText();
		System.out.println(text2);
	    Assert.assertEquals(text2,"Operation succesfully completed.");     
	}
	
	public String getSaltString() {
		   String SALTCHARS="1234567890566";
		   StringBuilder salt= new StringBuilder();
		   Random rnd =new Random();
		   while(salt.length() < 10) {//length of the random string.
			   int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			   salt.append(SALTCHARS.charAt(index));
		   }
		   String saltStr= salt.toString();
		    return saltStr;    
	}
		
}
