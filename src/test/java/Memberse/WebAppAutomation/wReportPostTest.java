package Memberse.WebAppAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class wReportPostTest extends WBase {
	
	@Test
	public void wReportPostTestCase()throws InterruptedException{
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
	    
	    HomePage hp= new HomePage(driver);
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.HomeMenu())).click();
	    u.apiDelay();
	    //List<WebElement> dotsMenus = ewait.until(ExpectedConditions.visibilityOfAllElements(hp.ThreeDotIcon()));
	    //System.out.println(dotsMenus.size());
	    //dotsMenus.get(1).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='w-8 h-8 flex items-center justify-center'])[1]"))).click();
	    ewait.until(ExpectedConditions.elementToBeClickable(hp.ReportButton())).click();
	    u.shortDelay();
	    String Text = driver.findElement(By.xpath("//*[text()='Confirm']")).getText();
		System.out.println(Text);
		ewait.until(ExpectedConditions.elementToBeClickable(hp.CancelButton())).click();
		u.shortDelay();
		
		//Test Status Flag
				super.testStatus = 1;
   }

}
