package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostHistoryPage {
	
	public WebDriver localdriver;
	
	public PostHistoryPage(WebDriver driver) {
		this.localdriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(),'Post History')]")
	private WebElement PostHistorySubMenu;
	
	public WebElement PostHistorySubMenu(){
		return PostHistorySubMenu;
	}
	
	@FindBy(xpath="//span[contains(text(),'Create')]")
    private WebElement createPost;

    public WebElement createPost() {
    	return createPost;
    }
	
	@FindBy(xpath="//p[@class='text-base font-medium line-clamp-1 leading-4 cursor-pointer']") 
    private WebElement ClickOnContent;

    public WebElement ClickOnContent() {
    	return ClickOnContent;
    }
    
    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div/div/button[2]")
    private WebElement EditPost;

    public WebElement EditPost() {
    	return EditPost;
    }
                   
    @FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div > div:nth-child(2) > div > div:nth-child(1) > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.p-4.flex.space-x-2.h-28 > div.flex.text-white > div > div > button:nth-child(3) > svg")
    private WebElement DeletePost;

    public WebElement DeletePost() {
    	return DeletePost;
    }
    
    @FindBy(xpath="/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/button[2]/span")
    private WebElement DeletePostCancel;

    public WebElement DeletePostCancel() {
    	return DeletePostCancel;
    }
    
    @FindBy(xpath="//*[@id=\"news-item-form\"]/div[3]/div/textarea")
    private WebElement PostDescription ;

    public WebElement PostDescription() {
    	return PostDescription;
    }
    
    @FindBy(xpath="//*[@id=\"news-item-form\"]/div[5]/button")
    private WebElement SavePost;

    public WebElement SavePost() {
    	return SavePost;
    }
    
    @FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div > div:nth-child(2) > div > div:nth-child(1) > div.w-full.bg-neutral-1000.dark\\:bg-purple-8000.shadow-sm.p-4.flex.space-x-2.h-28 > div.flex.text-white > div > div > button:nth-child(1) > svg")
    private WebElement PlaylistIcon;

    public WebElement PlaylistIcon() {
    	return PlaylistIcon;
    }
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/fieldset/div[1]/div/div[4]/div[1]/input") 
    private WebElement SavetoPlaylistCheckbox ;
    
    public WebElement SavetoPlaylistCheckbox() {
    	return SavetoPlaylistCheckbox;
    }
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/fieldset/div[2]/button")
    private WebElement MediaAddToPlaylistSaveButton ;
    
    public WebElement MediaAddToPlaylistSaveButton() {
    	return MediaAddToPlaylistSaveButton;
    }

}
