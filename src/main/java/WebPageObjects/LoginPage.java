package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver;
	
	public LoginPage(WebDriver driver)
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
	
	@FindBy(css="svg[data-icon='eye']")
	private WebElement ShowPassword;
	
	public WebElement ShowPassword() {
		return ShowPassword;
	}
	
	@FindBy(xpath="(//span[text()='Login'])[1]")
	private WebElement Login;
	
	public WebElement Login() {
		return Login;
	}
	
	@FindBy(css="svg[data-icon='google']")
	private WebElement GoogleLogin; 
	
	public WebElement GoogleLogin() {
		return GoogleLogin;
	}
	
	@FindBy(css="svg[data-icon='facebook']")
	private WebElement FacebookLogin; 
	
	public WebElement FacebookLogin() {
		return FacebookLogin;
	}
				   
	@FindBy(css="svg[data-icon='apple']")
	private WebElement AppleLogin; 
	
	public WebElement AppleLogin() {
		return AppleLogin;
	}

}
