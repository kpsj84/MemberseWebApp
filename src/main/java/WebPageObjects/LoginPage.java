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
	
	@FindBy(xpath="(//span[text()='Login'])[2]")
	private WebElement Login;
	
	public WebElement Login() {
		return Login;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div/div/div/div/form/div[5]/div/div/button[2]")
	private WebElement GoogleLogin; 
	
	public WebElement GoogleLogin() {
		return GoogleLogin;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div/div/div/div/form/div[5]/div/div/button[3]")
	private WebElement FacebookLogin; 
	
	public WebElement FacebookLogin() {
		return FacebookLogin;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div/div[3]/main/div/div/div/div/div/form/div[5]/div/div/button[1]")
	private WebElement AppleLogin; 
	
	public WebElement AppleLogin() {
		return AppleLogin;
	}

}
