package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	WebDriver localDriver;
	
	public WelcomePage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement LoginButton;
	
	public WebElement LoginButton() {
		return LoginButton;
	}
	
	@FindBy(xpath="//span[text()='Signup']")
	private WebElement SignupButtton;
	
	public WebElement SignupButtton() {
		return SignupButtton;
	}
	
	@FindBy(xpath="//img[@src='/images/app-store-button.png']")
	private WebElement AppStoreButtton;
	
	public WebElement AppStoreButtton() {
		return AppStoreButtton;
	}
	
	@FindBy(xpath="//img[@src='/images/google-play-button.png']")
	private WebElement GooglePlayButton;
	
	public WebElement GooglePlayButton() {
		return GooglePlayButton;
	}
	
	@FindBy(xpath="//span[text()='Forgot password?']")
	private WebElement forgotPassword;
	
	public WebElement forgotPassword() {
		return forgotPassword;
	}

}
