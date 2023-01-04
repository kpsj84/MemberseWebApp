package Memberse.WebAppAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.CreatePostPage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wCreatePhotoPostTest extends WBase {
	
	@Test
	public void wCreatePhotoPostTestCase()throws InterruptedException, AWTException{
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
		Thread.sleep(7000);
    	
		HomePage hp = new HomePage(driver);
		hp.createPost().click();
		Thread.sleep(2000);
		
    	String autotext=getSaltString();
  		System.out.println(autotext);
  		
  		CreatePostPage cpp = new CreatePostPage(driver);
  		cpp.titleBox().sendKeys("Auto Generated Audio Post - " +autotext);
        cpp.descriptionBox().sendKeys("This is an Auto-QA Description");
        Thread.sleep(1000);
        cpp.membersOnlyToggle().click();
        Thread.sleep(2000);
        cpp.photoButton().click();
        Thread.sleep(1000);        
        cpp.uploadPhoto().click();
        
        File fl = new File(System.getProperty("user.dir") + "/src/Pic22.jpg");
        StringSelection str = new StringSelection(fl.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);
        
        Robot rb = new Robot();
        //This required as in Automation, Focus loose from open file upload window
        rb.keyPress(KeyEvent.VK_META);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_META);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.delay(500);
        
        //Open Goto window
        rb.keyPress(KeyEvent.VK_META);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_G);
        rb.keyRelease(KeyEvent.VK_META);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyRelease(KeyEvent.VK_G);
        rb.delay(500);
        
        //Paste the clipboard value
        rb.keyPress(KeyEvent.VK_META);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_META);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(500);
        
        //Close both the Windows
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(500);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(500);
        Thread.sleep(3000);
      
        cpp.submitButton().click();
        Thread.sleep(10000);
        
        WebDriverWait w = new WebDriverWait(driver,90);
        w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")));
        String Text = driver.findElement(By.cssSelector("#__next > div.rnc__base > div.rnc__notification-container--bottom-right > div > div > div > div.rnc__notification-message")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Operation succesfully completed.");
	    
		Thread.sleep(10000);
        WebElement Text1 = driver.findElement(By.xpath("//p[text()='Auto Generated Audio Post - " +autotext+ "']"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Auto Generated Audio Post - " + autotext);
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

}
