package Memberse.WebDMonly;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Memberse.WebAppAutomation.WBase;
import Memberse.WebAppAutomation.WUtilities;
import WebPageObjects.DMPage;
import WebPageObjects.LoginPage;
import WebPageObjects.WelcomePage;

public class CreatorReplyDMTest extends WBase{

	@Test(groups = {"Regression"}, priority=4)
	public void CreatorReplyDMTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities util = new  WUtilities(driver);
		util.loadDelay();
		
		ewait.until(ExpectedConditions.titleIs("Memberse"));
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.urlToBe("https://app-qa.memberse.com/auth/login"));
		util.shortDelay();
		
		LoginPage lp = new LoginPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Email())).sendKeys("kqacreator@yopmail.com");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Password())).sendKeys("kqacreator");
		ewait.until(ExpectedConditions.elementToBeClickable(lp.Login())).click();
		util.apiDelay();
		util.loadDelay();
		
		DMPage dmp = new DMPage(driver);
		WebElement ele1 = ewait.until(ExpectedConditions.visibilityOf(dmp.creatorName()));
		String uname = ele1.getText();
		System.out.println(uname);
		Assert.assertEquals(uname, "kqacreator LN");
		
		util.loadDelay();
		List<WebElement> ele2 = ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=' divide-y divide-gray-200 border-y border-gray-200']/div")));
		System.out.println(ele2.size());
		int ttl = ele2.size();
		
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'kfn1 kln1')]"))).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.name("content"))).sendKeys("Auto Creator replying to Fan's DM - 1 on 1");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Send']"))).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Confirm']"))).click();
		String csDM = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='DM is locked']"))).getText();
		Assert.assertEquals(csDM, "DM is locked");
		
		//Test Status Flag
		super.testStatus = 1;
	}
}
