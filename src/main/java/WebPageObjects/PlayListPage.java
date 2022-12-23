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
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[3]/div[2]/div/p[1]")
	private WebElement PlayListSubMenu;
	
	public WebElement PlayListSubMenu() {
		return  PlayListSubMenu;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[1]/div/a")
	private WebElement createPlayList;
	
	public WebElement createPlayList() {
		return  createPlayList;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[1]/div/textarea")
	private WebElement PlayListTitleTextbox;
	
	public WebElement PlayListTitleTextbox() {
		return  PlayListTitleTextbox;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div/textarea")
    private WebElement DescriptionTextbox ;
    
    public WebElement DescriptionTextbox() {
    	return DescriptionTextbox;	
    }
    
    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[2]/div/div/div/div/div/div/div/div/div/label/span")
    private WebElement UploadImageButton ;
    
    public WebElement UploadImageButton() {
    	return UploadImageButton;
    }
    
    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[4]/button/span")
    private WebElement PlayListSaveButton ;
    
    public WebElement PlayListSaveButton() {
    	return PlayListSaveButton;
    }
    
    @FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div.space-y-2 > div:nth-child(4) > div.flex.text-white > div > div > button:nth-child(1)")
    private WebElement playListViewButton ;
    
    public WebElement playListViewButton() {
    	return playListViewButton;
    }
    
    @FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div.pb-10 > div.flex-grow > div.space-y-2 > div:nth-child(7) > div.flex.text-white > div > div > button:nth-child(2) > svg > path")
    private WebElement playListDeleteButton ;
    
    public WebElement playListDeleteButton() {
    	return playListDeleteButton;
    }
    
    @FindBy(xpath="//*[text()='Confirm']")
    private WebElement deleteConfirmButton;
    
    public WebElement deleteConfirmButton() {
    	return deleteConfirmButton;
    }
    
    @FindBy(xpath="/html/body/div[1]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[3]/div/div/button")
    private WebElement PlaylistEditButton;
    
    public WebElement PlaylistEditButton() {
    	return PlaylistEditButton;
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[2]/div/textarea")
    private WebElement EditDescriptionTextbox ;

    public WebElement EditDescriptionTextbox() {
    	return EditDescriptionTextbox;
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div/div[2]/form/div[4]/button")
    private WebElement EditSaveButton2 ;

    public WebElement EditSaveButton2() {
    	return EditSaveButton2;
    }

}
