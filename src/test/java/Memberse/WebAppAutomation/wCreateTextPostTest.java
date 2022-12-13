package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatePostPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCreateTextPostTest extends WBase {
	
	@Test
	public void wCreateTextPostTestFree()throws InterruptedException{
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
    	
		HomePage hp = new HomePage(driver);
		hp.createPost().click();
		Thread.sleep(2000);
		
    	String autotext=getSaltString();
  		System.out.println(autotext);
  		
  		CreatePostPage cpp = new CreatePostPage(driver);
  		cpp.titleBox().sendKeys("Auto Generated Post - " +autotext);
        cpp.descriptionBox().sendKeys("This is an auto-QA Description");
        Thread.sleep(1000);
        cpp.membersOnlyToggle().click();
        Thread.sleep(1000);
        cpp.submitButton().click();
        Thread.sleep(5000); 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    String Text = driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Operation succesfully completed.");
	    
        Thread.sleep(2000);
	    WebElement Text1 = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div > div:nth-child(2) > div > div:nth-child(1) > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.p-4.flex.space-x-2.h-28 > div.flex.flex-grow > div > div.block.relative > p"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Auto Generated Post - " + autotext);
    }
	
	    public String getSaltString() {
		String SALTCHARS="369852147";
		StringBuilder salt= new StringBuilder();
		   Random rnd =new Random();
		   while(salt.length() < 4) {//length of the random string.
			   int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			   salt.append(SALTCHARS.charAt(index));
		   }
		   String saltStr= salt.toString();
		   return saltStr;    
	}	
	    
	    
	    @Test
	    public void wCreateTextPostTestPaid() throws InterruptedException {
	    	Thread.sleep(3000);
	    	
	    	HomePage hp = new HomePage(driver);
			hp.createPost().click();
			Thread.sleep(2000);
			
	    	String autotext=getSaltString();
	  		System.out.println(autotext);
	  		
	  		CreatePostPage cpp = new CreatePostPage(driver);
	  		cpp.titleBox().sendKeys("Auto Generated Paid Post - " +autotext);
	        cpp.descriptionBox().sendKeys("This is an auto-QA Description");
	        Thread.sleep(2000);
	        cpp.submitButton().click();
	        Thread.sleep(5000); 
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		    String Text = driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
			System.out.println(Text);
			Assert.assertEquals(Text,"Operation succesfully completed.");
		    
	        Thread.sleep(2000);
		    WebElement Text1 = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div > div:nth-child(2) > div > div:nth-child(1) > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.p-4.flex.space-x-2.h-28 > div.flex.flex-grow > div > div.block.relative > p"));
			String text2 = Text1.getText();
			System.out.println(text2);
			Assert.assertEquals(text2,"Auto Generated Paid Post - " + autotext);
			Thread.sleep(3000);
	    }
	    
}
