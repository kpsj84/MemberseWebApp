package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayListPage {
	
	public WebDriver localdriver;
	
	public PlayListPage(WebDriver driver) {
		this.localdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//p[contains(text(),'Playlists')])[1]")
	private WebElement PlayListSubMenu;
	
	public WebElement PlayListSubMenu() {
		return  PlayListSubMenu;
	}
	
	@FindBy(xpath="(//span[contains(text(),'Create')])[1]")
	private WebElement createPlayList;
	
	public WebElement createPlayList() {
		return  createPlayList;
	}
	
	@FindBy(xpath="//textarea[@name='title']")
	private WebElement PlayListTitleTextbox;
	
	public WebElement PlayListTitleTextbox() {
		return  PlayListTitleTextbox;
	}
	
	@FindBy(xpath="//textarea[@name='content']")
    private WebElement DescriptionTextbox ;
    
    public WebElement DescriptionTextbox() {
    	return DescriptionTextbox;	
    }
    
    @FindBy(xpath="//span[contains(text(),'Upload')]")
    private WebElement UploadImageButton ;
    
    public WebElement UploadImageButton() {
    	return UploadImageButton;
    }
    
    @FindBy(xpath="//span[contains(text(),'Create')]")
    private WebElement PlayListSaveButton ;
    
    public WebElement PlayListSaveButton() {
    	return PlayListSaveButton;
    }
    
    @FindBy(xpath="(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[1]")
    private WebElement playListViewButton ;
    
    public WebElement playListViewButton() {
    	return playListViewButton;
    }
    
    @FindBy(xpath="(//div[@class='flex space-x-3 items-center justify-end'])[1]/button[2]")
    private WebElement playListDeleteButton ;
    
    public WebElement playListDeleteButton() {
    	return playListDeleteButton;
    }
    
    @FindBy(xpath="//*[text()='Confirm']")
    private WebElement deleteConfirmButton;
    
    public WebElement deleteConfirmButton() {
    	return deleteConfirmButton;
    }
    
    @FindBy(xpath="//button[@class=' text-neutral-9000 hover:text-gray-6000']")
    private WebElement PlaylistEditButton;
    
    public WebElement PlaylistEditButton() {
    	return PlaylistEditButton;
    }

    @FindBy(xpath="//textarea[@name='content']")
    private WebElement EditDescriptionTextbox ;

    public WebElement EditDescriptionTextbox() {
    	return EditDescriptionTextbox;
    }

    @FindBy(xpath="//span[@class='text-base font-medium leading-4']")
    private WebElement EditSaveButton2 ;

    public WebElement EditSaveButton2() {
    	return EditSaveButton2;
    }
    
    @FindBy(xpath="//textarea[@name='comment']")  
    private WebElement PlaylistMediaComment ;
    
    public WebElement PlaylistMediaComment() {
    return PlaylistMediaComment;
    }

}
