package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
	public WebDriver localdriver;
    
    public ChangePasswordPage(WebDriver driver) 
    {
		this.localdriver= driver;
		PageFactory.initElements(driver, this);

    }
    
    @FindBy(xpath="//input[@name='password']")
    private WebElement ChangePassword;

    public WebElement ChangePassword() {
        return ChangePassword;
    }
    
    @FindBy(xpath="//input[@name='confirm_password']")
    private WebElement ConfirmPassword;

    public WebElement ConfirmPassword() {
        return ConfirmPassword;
    }
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement SaveButton;

    public WebElement SaveButton() {
        return SaveButton;
    }

}
