package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnBoardingPage {
	
WebDriver localDriver;
	
	public OnBoardingPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName;
	
	public WebElement userName() {
		return userName;
	}
	
	@FindBy(name="name")
	private WebElement communityName;
	
	public WebElement communityName() {
		return communityName;
	}
	
	@FindBy(name="description")
	private WebElement communityAbout;
	
	public WebElement communityAbout() {
		return communityAbout;
	}
	
	@FindBy(name="welcome_message")
	private WebElement welcomeMsg;
	
	public WebElement welcomeMsg() {
		return welcomeMsg;
	}
	
	@FindBy(xpath="//span[contains(text(), 'Connect with Stripe')]")
	private WebElement connectStripe;
	
	public WebElement connectStripe() {
		return connectStripe;
	}
	
	@FindBy(xpath="//span[contains(text(), '$')]")
	private WebElement dmCurrencyDollar;
	
	public WebElement dmCurrencyDollar() {
		return dmCurrencyDollar;
	}
	
	@FindBy(name="ppm")
	private WebElement customDMPrice;
	
	public WebElement customDMPrice() {
		return customDMPrice;
	}

}
