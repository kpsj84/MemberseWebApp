package Memberse.WebAppAutomation;

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

public class wCreateTextPostTest extends WBase {
	
	@Test(groups = {"Regression"}, priority=22)
	public void wCreateTextPostTestCase()throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
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
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.titleBox())).sendKeys("Auto Generated Text Post - " +autotext);
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.descriptionBox())).sendKeys("This is an Auto-QA Text Post Description");
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.membersOnlyToggle())).click();
  		ewait.until(ExpectedConditions.elementToBeClickable(cpp.submitButton())).click();
        u.shortDelay();
        
        ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='notistack-CollapseWrapper']")));
        String Text = driver.findElement(By.xpath("//div[@class='notistack-CollapseWrapper']")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text,"Operation succesfully completed.");
	    
        u.loadDelay();                     
        WebElement Text1 = driver.findElement(By.xpath("//p[contains(text(), 'Auto Generated Text Post - " +autotext+ "')]"));
		String text2 = Text1.getText();
		System.out.println(text2);
		Assert.assertEquals(text2,"Auto Generated Text Post - " + autotext);
		
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
