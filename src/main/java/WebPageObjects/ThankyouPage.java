package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage {
	
WebDriver localDriver;
	
	public ThankyouPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Manage memberships']")
    private WebElement ManageMembershipButton;

    public WebElement ManageMembershipButton() {
    	return ManageMembershipButton;
    }

}
