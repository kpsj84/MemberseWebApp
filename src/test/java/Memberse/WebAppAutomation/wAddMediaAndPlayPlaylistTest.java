package Memberse.WebAppAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.PlayListPage;
import WebPageObjects.PostHistoryPage;
import WebPageObjects.WelcomePage;

public class wAddMediaAndPlayPlaylistTest extends WBase {
	
	@Test
	public void wAddMediaAndPlayPlaylistTestCase()throws InterruptedException, AWTException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.LoginButton())).click();
		
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
		ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListTitleTextbox())).sendKeys("Autolist-" + autotext);
		ewait.until(ExpectedConditions.elementToBeClickable(plp.DescriptionTextbox())).sendKeys("This is an Automated QA Description");
		ewait.until(ExpectedConditions.elementToBeClickable(plp.UploadImageButton())).click();
        u.shortDelay();
        
        File fl = new File(System.getProperty("user.dir") + "/src/Pic22.jpg");
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
        rb.delay(500);
        
        //Close both the Windows
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(500);
        rb.delay(500);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListSaveButton())).click();
        u.apiDelay();
        u.loadDelay();
        
        String text= ewait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rnc__notification-content']")))).getText();
		System.out.println(text);
		Assert.assertEquals(text,"Success!\n" + "Operation succesfully completed.");
		System.out.println("PlayList Created with Name as :- " + "Autolist-" + autotext);
		driver.navigate().refresh();
		u.loadDelay();
		
		PostHistoryPage php = new PostHistoryPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(php.PostHistorySubMenu())).click();
		u.loadDelay();
        
		List<WebElement> buttonPosition = driver.findElements(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button"));
    	System.out.println(buttonPosition.size());
    	int buttonNos = buttonPosition.size();
    	if(buttonNos > 2)
    	{
    		ewait.until(ExpectedConditions.elementToBeClickable(php.PlaylistIcon())).click();
    	}
    	else
    	{
    		//driver.findElement(By.xpath("(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[2]")).click();
    		System.out.println("Playable Media is not available to add in the Playlist");
    	}
        u.loadDelay();
        
        List<WebElement> playlist = driver.findElements(By.xpath("//div[@class='space-y-4']/div"));
        System.out.println(playlist.size());
        int desiredPlaylistSize = playlist.size()-2;
        ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-describedby='playlist'][@type='checkbox'])[" + desiredPlaylistSize + "]"))).click();
        
        
       /* 
        for(WebElement readPlaylist: playlist)
        {
        	if(readPlaylist.getText().equals("Autolist-" + autotext))
        	{
        		System.out.println(readPlaylist.getText());
        		WebElement sortedElement = readPlaylist;
        		ewait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(sortedElement, By.xpath("//input[@aria-describedby='playlist'][@type='checkbox']"))).click();
        		Thread.sleep(999999);
        		u.shortDelay();
        		//readPlaylist.click();
        		break;
        	}
        }*/
		
        //ewait.until(ExpectedConditions.elementToBeClickable(php.SavetoPlaylistCheckbox())).click();
        ewait.until(ExpectedConditions.elementToBeClickable(php.MediaAddToPlaylistSaveButton())).click();
        u.apiDelay();
        
        ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListSubMenu())).click();
        u.shortDelay();
        
        List<WebElement> mainPlaylist = driver.findElements(By.xpath("//div[@class='space-y-2']/div"));
        System.out.println(mainPlaylist.size());
        for(WebElement readMainPlaylist: mainPlaylist)
        {
        	if(readMainPlaylist.getText().equals("Autolist-" + autotext))
        	{
        		System.out.println(readMainPlaylist);
        		//readMainPlaylist.click();
        		ewait.until(ExpectedConditions.elementToBeClickable(plp.playListViewButton())).click();
        		break;
        	}
        }
    	//ewait.until(ExpectedConditions.elementToBeClickable(plp.playListViewButton())).click();
    	u.loadDelay(); 
        driver.findElement(By.xpath("//p[@class='text-base font-medium line-clamp-1 leading-4 cursor-pointer']")).click();
        String Text= driver.findElement(By.xpath("//p[@class=' text-sm font-semibold line-clamp-1']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"kqatestc3's Community");
		
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CreatorMenu())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.PlayListSubMenu())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.playListDeleteButton())).click();
		ewait.until(ExpectedConditions.elementToBeClickable(plp.deleteConfirmButton())).click();
		u.shortDelay();
		System.out.println("Completed -> Test");
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
