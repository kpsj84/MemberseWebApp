package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage {
	
	WebDriver localDriver;
	
	public ExplorePage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement LoginButton;
	
	public WebElement LoginButton() {
		return LoginButton;
	}
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/a[2]")
	private WebElement SignupButton;
	
	public WebElement SignupButton() {
		return SignupButton;
	}

}
