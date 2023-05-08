package Memberse.WebAppAutomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPageObjects.OnBoardingPage;
import WebPageObjects.SignupPage;
import WebPageObjects.StripePage;
import WebPageObjects.WelcomePage;

public class wSignupTest extends WBase {
	
	@Test(groups = {"Regression"})
	public void wSignupTestCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait ewait =  new WebDriverWait(driver, 60);
		
		WUtilities u = new  WUtilities(driver);
		u.loadDelay();
		
		WelcomePage wp = new WelcomePage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(wp.SignupButtton())).click();
		
		String email = getSaltString();
		System.out.println(email);
		String password = "123456";
		String uname = email.substring(0,6);
		System.out.println(uname);
		
		SignupPage sp = new SignupPage(driver);
		u.elementToBeClickable(ewait, sp.Email()).sendKeys(email);
		u.elementToBeClickable(ewait, sp.Password()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.confirmPassword()).sendKeys(password);
		u.elementToBeClickable(ewait, sp.SignupButton()).click();
		u.apiDelay();
		
		String fan = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Fan')]"))).getText();
		Assert.assertEquals(fan, "Fan");
		String creator = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Creator')]"))).getText();
		Assert.assertEquals(creator, "Creator");
		ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Creator')]"))).click();
		
		//Modal Screen 1
		OnBoardingPage obp = new OnBoardingPage(driver);
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[form='creator-info-form']"))).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(), 'This field is required.')])[1]")));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(text(), 'This field is required.')])[2]")));
		System.out.println("Creator form validations are working fine");
		
		u.elementToBeClickable(ewait, obp.userName()).sendKeys("Auto-" + uname);
		u.elementToBeClickable(ewait, obp.communityName()).sendKeys("Auto-" + uname + "'s Community");
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[form='creator-info-form']"))).click();
		
		//Modal Screen 2
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[form='creator-extra-info-form']"))).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'This field is required.')]")));
		System.out.println("Community About validation is working fine");
		
		u.elementToBeClickable(ewait, obp.communityAbout()).sendKeys("Auto-" + uname + " About / Description");
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[form='creator-extra-info-form']"))).click();
		u.loadDelay();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(), 'Back')])[2]"))).click();
		String welcomeMessage = u.elementToBeClickable(ewait, obp.welcomeMsg()).getAttribute("value");
		Assert.assertEquals(welcomeMessage, "Welcome and thank you for joining our community! Your support means a lot. If you have any questions, feel free to send me a Paid DM and I can personally assist you. I'm thrilled to have you here as part of our community!");
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[form='creator-extra-info-form']"))).click();
		
		//Modal Screen 3
		u.elementToBeClickable(ewait, obp.connectStripe()).click();
		u.apiDelay();
		StripePage stp = new StripePage(driver);
		u.elementToBeClickable(ewait, stp.testPhoneNumber()).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Continue')]"))).click();
		u.loadDelay();
		u.elementToBeClickable(ewait, stp.testPhoneCode()).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Continue')]"))).click();
		u.elementToBeClickable(ewait, stp.firstName()).sendKeys("Auto-" + uname);
		u.elementToBeClickable(ewait, stp.lastName()).sendKeys("Ln");
		u.elementToBeClickable(ewait, stp.bussinessUrl()).sendKeys("www." + uname + ".com");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Continue')]"))).click();
		u.elementToBeClickable(ewait, stp.testAccount()).click();
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Agree & submit')])[2]"))).click();
		u.apiDelay();
		String stripeConnected = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Stripe Connected')]"))).getText();
		Assert.assertEquals(stripeConnected, "Stripe Connected");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Next')])[3]"))).click();
		
		//Modal Screen 4
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(), 'All done')]")));
		System.out.println("OnBoarding verification working fine upto Stripe Connection");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button']//span[contains(text(), \"Let's go\")])[1]"))).click();
		u.loadDelay();
		
		//Modal Screen 5 - DM Screen1
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(), 'Paid DMs!')]")));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']//span[contains(text(), 'Get Started')]"))).click();
		
		//Modal Screen 6 - DM Screen2
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Your followers pay to send every new message, which keeps things fun and exciting!')]")));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'You have 48 hours to respond to each message.')]")));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), \"If you reply, you get paid. If you don't, your followers won't be charged.\")]")));
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@form='creator-extra-info-form'])[2]"))).click();
		System.out.println("DM Steps info text is verified for visibility");
		
		//Modal Screen 7 - DM Screen3
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Pick your currency')]")));
		u.elementToBeClickable(ewait, obp.dmCurrencyDollar()).click();
		u.shortDelay();
		String fiveDollar = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='text-4xl font-bold tracking-tight text-gray-900'])[1]"))).getText();
		Assert.assertEquals(fiveDollar, "$5");
		String tenDollar = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='text-4xl font-bold tracking-tight text-gray-900'])[2]"))).getText();
		Assert.assertEquals(tenDollar, "$10");
		String twentyDollar = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='text-4xl font-bold tracking-tight text-gray-900'])[3]"))).getText();
		Assert.assertEquals(twentyDollar, "$20");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(), 'Select')])[1]"))).click();
		u.shortDelay();
		String customDMprice = u.elementToBeClickable(ewait, obp.customDMPrice()).getAttribute("value");
		Assert.assertEquals(customDMprice, "5");
		u.elementToBeClickable(ewait, obp.customDMPrice()).clear();
		u.elementToBeClickable(ewait, obp.customDMPrice()).sendKeys("15");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@form='creator-dm-form']"))).click();
		u.loadDelay();
		
		//Modal Screen 8 - DM Screen4
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='All done!']"))).click();
		//String dmLink = ewait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).getAttribute("disabled value");
		//Assert.assertEquals(dmLink, "https://app-qa.so.fa.dog/dm/@" + uname);
		ewait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[data-icon='copy']"))).click();
		String dmLinkCopied = ewait.until(ExpectedConditions.elementToBeClickable(By.id("notistack-snackbar"))).getText();
		Assert.assertEquals(dmLinkCopied, "Link copied to clipboard.");
		ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='View DMs']"))).click();
		
		//Landing on DM Page
		u.loadDelay();
		String dmPageText = ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='Share My Link']"))).getText();
		Assert.assertEquals(dmPageText, "Share My Link");
		
		//Test Status Flag
		super.testStatus = 1;
	}
	
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "@yopmail.com";
        return saltStr;
    }

}
