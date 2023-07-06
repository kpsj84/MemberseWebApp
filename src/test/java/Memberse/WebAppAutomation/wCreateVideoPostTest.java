package Memberse.WebAppAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class wCreateVideoPostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=24)
	public void wCreatVideoPostTestCase()throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 90);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
	    WelcomePage wp = new WelcomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
	    u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc5@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc5");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
    	
		HomePage hp = new HomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.createPost())).click();
		
    	String autotext=getSaltString();
  		System.out.println(autotext);
  		
  		CreatePostPage cpp = new CreatePostPage(driver);
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.titleBox())).sendKeys("Auto Generated Video Post - " +autotext);
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.descriptionBox())).sendKeys("This is an Auto-QA Description");
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.membersOnlyToggle())).click();
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.videoButton())).click();
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.uploadVideo())).click();
        
        File fl = new File(System.getProperty("user.dir") + "/src/samples/SampleVideo_2MB.mp4");
        StringSelection str = new StringSelection(fl.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        u.shortDelay();
        
        Robot rb = new Robot();
        //This required as in Automation, Focus loose from open file upload window, this code not required if Java app already opened in Background by previous test
        /*
        rb.keyPress(KeyEvent.VK_META);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_META);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.delay(500);
        */
        
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
        u.loadDelay();
       
        ewait.until(ExpectedConditions.elementToBeClickable(cpp.submitButton())).click();
        u.apiDelay();
        
        ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='notistack-CollapseWrapper']")));
        String Text = driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Operation succesfully completed.");
	    
		u.loadDelay();
        driver.findElement(By.xpath("//a[@href='/content-creator/posts/unpublished']")).click();
        u.shortDelay();
	    WebElement Text1 = driver.findElement(By.xpath("//p[contains(text(), 'Auto Generated Video Post - " +autotext+ "')]"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Auto Generated Video Post - " + autotext);
		
		//Test Status Flag
		super.testStatus = 1;
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
