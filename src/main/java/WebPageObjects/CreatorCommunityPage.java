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
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div[4]/div/div[1]/div/button")
    private WebElement JoinButton ;

    public WebElement  JoinButton () {
    	return  JoinButton;
    }
	
	@FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.relative > div.absolute.z-20.w-full.py-4 > div.flex.items-center.space-x-4.mt-2 > div > div:nth-child(2) > div > button > span")
	private WebElement followCreator;
	
	public WebElement followCreator() {
		return followCreator;
	}
	
	@FindBy(xpath="//*[@class='w-8 h-8 flex items-center justify-center']")
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
