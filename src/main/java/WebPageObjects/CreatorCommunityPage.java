package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatorCommunityPage {
	
	WebDriver localDriver;
	
	public CreatorCommunityPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'join')]")
    private WebElement JoinButton ;

    public WebElement  JoinButton () {
    	return  JoinButton;
    }
    
    @FindBy(xpath="//*[text()='Donate']")
    private WebElement donateButton ;

    public WebElement  donateButton() {
    	return  donateButton;
    }
	
	@FindBy(xpath="//span[contains(text(),'Follow')]")
	private WebElement followCreator;
	
	public WebElement followCreator() {
		return followCreator;
	}
	
	@FindBy(xpath="//span[contains(text(),'DM')]")
	private WebElement DMButton;
	
	public WebElement DMButton() {
		return DMButton;
	}
	
	@FindBy(xpath="(//*[@class='w-8 h-8 flex items-center justify-center'])[2]") 
	private WebElement threeDotsMenu;
	
	public WebElement threeDotsMenu() {
		return threeDotsMenu;
	}
	
	@FindBy(xpath="//a[text()='Unfollow']")
    private WebElement Unfollowlink ;

    public WebElement  Unfollowlink () {
    	return  Unfollowlink;
    }
    
    @FindBy(xpath="//*[text()='Confirm']")
    private WebElement ConfirmUnfollow ;

    public WebElement  ConfirmUnfollow () {
    	return  ConfirmUnfollow;
    }
    
    @FindBy(xpath="//a[text()='Share Community']")
    private WebElement shareCommunitylink ;

    public WebElement  shareCommunitylink () {
    	return  shareCommunitylink;
    }
    
    @FindBy(xpath="//a[text()='Report Community']")
    private WebElement reportCommunity ;

    public WebElement  reportCommunity() {
    	return  reportCommunity;
    }
    
    @FindBy(xpath="//*[text()='Playlists']")
    private WebElement PlaylistTab ;

    public WebElement  PlaylistTab () {
    	return  PlaylistTab;
    
    }

    @FindBy(xpath="//*[text()='About']")
    private WebElement AboutTab ;

    public WebElement  AboutTab() {
    	return  AboutTab;
    }
    
    @FindBy(xpath="//*[text()='Fans']")
    private WebElement FansTab ;

    public WebElement  FansTab() {
    	return  FansTab;
    }

}
