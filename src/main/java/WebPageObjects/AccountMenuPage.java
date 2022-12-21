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
		
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[1]/div[2]/div/p[1]")
	private WebElement UserInfoSubMenu;
	
	public WebElement UserInfoSubMenu() {
		return UserInfoSubMenu;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[2]/div[2]/div/p[1]")
	private WebElement MembershipsSubMenu;
	
	public WebElement MembershipsSubMenu() {
		return MembershipsSubMenu;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[4]/div[2]/div/p[1]")
    private WebElement ChangePasswordSubMenu;

    public WebElement ChangePasswordSubMenu() {
    	return ChangePasswordSubMenu;
    }
    
    @FindBy(xpath="//*[text()='Watched history']")
    private WebElement WatchedHistorySubMenu ;

    public WebElement WatchedHistorySubMenu() {
    	return WatchedHistorySubMenu;
    }		

}
