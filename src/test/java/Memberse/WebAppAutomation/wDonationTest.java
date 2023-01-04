package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import WebPageObjects.CreatorCommunityPage;
import WebPageObjects.DonatePage;
import WebPageObjects.ExplorePage;
import WebPageObjects.HomePage;
import WebPageObjects.LoginPage;
import WebPageObjects.StripePage;
import WebPageObjects.ThankyouPage;
import WebPageObjects.WelcomePage;

public class wDonationTest extends WBase {

	@Test
	public void wDonationTestCase()throws InterruptedException{
		WUtilities u = new  WUtilities(driver);
		u.timeDelayToLoadWebsite();
		
	    WelcomePage wp = new WelcomePage(driver);
	    wp.LoginButton().click();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.Email().sendKeys("kqatestc7@yopmail.com");
		lp.Password().sendKeys("kqatestc7");
		lp.ShowPassword().click();
		lp.Login().click();
		Thread.sleep(7000);
		
		HomePage hp = new HomePage(driver);
	    hp.ExploreMenu().click();
		Thread.sleep(2000);
	    
	    ExplorePage ep = new ExplorePage(driver); 
	    ep.SearchField().sendKeys("kqacreator");
	    Thread.sleep(13000); 
	    ep.ClickCreator().click();
	    Thread.sleep(5000);
	    
	    CreatorCommunityPage cp = new CreatorCommunityPage(driver);
	    cp.donateButton().click();
	    Thread.sleep(5000);
	    
	    DonatePage dp = new DonatePage(driver);
	    dp.SelectDonateAmount().click();
	    Thread.sleep(2000);
	    dp.DonatePriceButton().click();
	    Thread.sleep(8000);
	    
	    StripePage sp = new StripePage(driver);
	    sp.PayDonationButton().click();
	    Thread.sleep(5000);
	    
	    String Text = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.pt-8 > div > div > div > p.text-center.font-bold.text-lg.mb-2")).getText();
		System.out.println(Text);
	    Thread.sleep(6000);
	    
	    ThankyouPage tp = new ThankyouPage(driver);
	    tp.BacktoCoummunityButton().click();
	    Thread.sleep(6000);

	    String Text1 = driver.findElement(By.cssSelector("#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.relative > div.absolute.z-20.w-full.py-4 > div.flex.justify-center.mt-4.px-4 > p")).getText();
	  	System.out.println(Text1);
	  	Thread.sleep(4000);
	 }
	
}
