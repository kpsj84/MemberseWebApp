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
    
    @FindBy(xpath="(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[2]")
    private WebElement EditPost;

    public WebElement EditPost() {
    	return EditPost;
    }
                   
    @FindBy(xpath="(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[3]")
    private WebElement DeletePost;

    public WebElement DeletePost() {
    	return DeletePost;
    }
    
    @FindBy(xpath="//span[contains(text(),'Cancel')]")
    private WebElement DeletePostCancel;

    public WebElement DeletePostCancel() {
    	return DeletePostCancel;
    }
    
    @FindBy(xpath="//textarea[@name='content']")
    private WebElement PostDescription ;

    public WebElement PostDescription() {
    	return PostDescription;
    }
    
    @FindBy(xpath="//span[text()='Save']")
    private WebElement SavePost;

    public WebElement SavePost() {
    	return SavePost;
    }
    
    @FindBy(xpath="(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[1]")
    private WebElement PlaylistIcon;

    public WebElement PlaylistIcon() {
    	return PlaylistIcon;
    }
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/fieldset/div[1]/div/div[4]/div[1]/input") 
    private WebElement SavetoPlaylistCheckbox ;
    
    public WebElement SavetoPlaylistCheckbox() {
    	return SavetoPlaylistCheckbox;
    }
    
    @FindBy(xpath="//span[contains(text(),'Save')]")
    private WebElement MediaAddToPlaylistSaveButton ;
    
    public WebElement MediaAddToPlaylistSaveButton() {
    	return MediaAddToPlaylistSaveButton;
    }

}
