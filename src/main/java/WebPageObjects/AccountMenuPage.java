package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountMenuPage {
	
	WebDriver localDriver;
			
	public AccountMenuPage(WebDriver driver)
		{
			this.localDriver = driver;
			PageFactory.initElements(driver, this);
		}
		
	@FindBy(xpath="//p[text()='User Info']")
	private WebElement UserInfoSubMenu;
	
	public WebElement UserInfoSubMenu() {
		return UserInfoSubMenu;
	}
	
	@FindBy(xpath="//p[text()='Memberships']")
	private WebElement MembershipsSubMenu;
	
	public WebElement MembershipsSubMenu() {
		return MembershipsSubMenu;
	}
	
	@FindBy(xpath="//p[text()='Change Password']")
    private WebElement ChangePasswordSubMenu;

    public WebElement ChangePasswordSubMenu() {
    	return ChangePasswordSubMenu;
    }
    
    @FindBy(xpath="//*[text()='Watched History']")
    private WebElement WatchedHistorySubMenu ;

    public WebElement WatchedHistorySubMenu() {
    	return WatchedHistorySubMenu;
    }		

}
