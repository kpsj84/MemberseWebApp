package Memberse.WebAppAutomation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.MyCommunityPage;
import WebPageObjects.WelcomePage;

public class wCreatorEditInfoTest extends WBase {
	
	@Test
	public void wCreatorEditInfoTestCase() throws InterruptedException {
		Thread.sleep(7000);
		WelcomePage wp = new WelcomePage(driver);
		wp.LoginButton().click();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc3@yopmail.com");
		lp.Password().sendKeys("kqatestc3");
		Thread.sleep(1000);
	    lp.ShowPassword().click();
		lp.Login().click();
	    Thread.sleep(10000);  
		
	    HomePage hp = new HomePage(driver);
	    hp.CreatorMenu().click();
		Thread.sleep(2000);
		
		MyCommunityPage mcp = new MyCommunityPage(driver);
		mcp.MyCommunitySubMenu().click();
		mcp.EditInfoTab().click();
		Thread.sleep(2000);
		
        WebElement CommunityName = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div.flex-grow > div > div.py-5 > div > form > div.space-y-6 > div:nth-child(2) > div > input"));
	    String chkName = CommunityName.getAttribute("value");
	    System.out.println(chkName);
		Assert.assertEquals(chkName,"kqatestc3's Community");
		
		mcp.EditInfoDescription().clear();		
	    String autoText=getSaltString();
		System.out.println(autoText);
		mcp.EditInfoDescription().sendKeys("This is my QA Test Channel :- " + autoText);
		mcp.EditInfoTabSave().click();
	    
	    String Text1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[6]/div/div/div/div[2]")).getText();
	    System.out.println(Text1);
        Assert.assertEquals(Text1,"Operation succesfully completed.");
	 }
	
	 public String getSaltString() {
		  String SALTCHARS="1234567890";
		  StringBuilder salt= new StringBuilder();
		  Random rnd =new Random();
		  while(salt.length() < 5) {//length of the random string.
		  int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		  salt.append(SALTCHARS.charAt(index));
		  }
		  	String saltStr= salt.toString();
		    return saltStr;
	 }

}
