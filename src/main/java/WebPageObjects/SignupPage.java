package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	WebDriver localDriver;
	
	public SignupPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement Email;
	
	public WebElement Email() {
		return Email;
	}
	
	@FindBy(name="password")
	private WebElement Password;
	
	public WebElement Password() {
		return Password;
	}
	
	@FindBy(name="confirm_password")
	private WebElement confirmPassword;
	
	public WebElement confirmPassword() {
		return confirmPassword;
	}
	
	@FindBy(xpath="//span[text()='Sign up']")
	private WebElement SignupButton;
	
	public WebElement SignupButton() {
		return SignupButton;
	}

}
