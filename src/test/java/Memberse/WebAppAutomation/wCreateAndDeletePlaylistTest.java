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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PlayListPage;
import WebPageObjects.WelcomePage;

public class wCreateAndDeletePlaylistTest extends WBase {
	
	@Test
	public void wCreateAndDeletePlaylistTestCase()throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		u.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqatestc3@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqatestc3");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.ShowPassword())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		u.apiDelay();
		
	    HomePage hp = new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
	    u.shortDelay();
    	
		PlayListPage plp = new PlayListPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListSubMenu())).click();
        u.shortDelay();
        
        ewait.until(ExpectedConditions.elementToBeClickable(plp.createPlayList())).click();
        String autotext = getSaltString();
		System.out.println(autotext);
		u.shortDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListTitleTextbox())).sendKeys("Autolist - " + autotext);
		ewait.until(ExpectedConditions.elementToBeClickable(plp.DescriptionTextbox())).sendKeys("This is an Automated QA Description");
		ewait.until(ExpectedConditions.elementToBeClickable(plp.UploadImageButton())).click();
        u.shortDelay();
        
        File fl = new File(System.getProperty("user.dir") + "/src/samples/Pic1.jpg");
        StringSelection str = new StringSelection(fl.getAbsolutePath());
        //StringSelection str = new StringSelection("C:\\Users\\QA\\Desktop\\MusicFile.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        u.shortDelay();
        
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
        
        //Close both the Windows
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(500);
        rb.delay(500);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListSaveButton())).click();
        u.loadDelay();
        
        String text= ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")))).getText();
		System.out.println(text);
		Assert.assertEquals(text,"Operation succesfully completed.");
		System.out.println("PlayList Created with Name as :- " + "Autolist - " + autotext);
		
		u.shortDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.playListDeleteButton())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.deleteConfirmButton())).click();
		u.shortDelay();
		System.out.println("PlayList with Name as :- " + "Autolist - " + autotext + "deleted too.");
		
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
