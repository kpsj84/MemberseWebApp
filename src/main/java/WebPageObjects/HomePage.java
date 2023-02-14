package WebPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver localDriver;
	
	public HomePage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='w-10 h-10 flex items-center justify-center']")  
	private WebElement createPost;
	
	public WebElement createPost() {
		return createPost;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[2]/div/span[2]/div/div/div")   
	private WebElement ProfilePic;
	
	public WebElement ProfilePic() {
		return ProfilePic;
	}
	
	@FindBy(xpath="//span[contains(text(), 'Filter')]")
	private WebElement filterButton;
	
	public WebElement filterButton(){
		return filterButton;
	}
	
	@FindBy(xpath="//button[@role='switch']")
	private WebElement filterToggle ;
	
	public WebElement filterToggle() {
		return filterToggle;
	}
	
	@FindBy(xpath="//span[contains(text(), 'Save')]")
	private WebElement filterSave;
	
	public WebElement filterSave() {
		return filterSave;
	}
	
	@FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div:nth-child(3) > div.space-y-2 > div > div > div:nth-child(1) > div > div:nth-child(4) > div > div.flex.items-center.text-xs.space-x-4 > div:nth-child(2) > svg")
	private WebElement commentOnPost;
	
	public WebElement commentOnPost() {
		return commentOnPost;
	}
	
	@FindBy(css="#headlessui-dialog-panel-18 > div.space-y-2.bg-neutral-2000 > div.space-y-2.bg-neutral-3000 > div > div > textarea")
	private WebElement writeComment;
	
	public WebElement writeComment(){
		return writeComment;
	}
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeMenu;
	
	public WebElement HomeMenu() {
		return HomeMenu;
	}
	
	@FindBy(xpath="//a[text()='Account']")
	private WebElement AccountMenu;
	
	public WebElement AccountMenu() {
		return AccountMenu;
	}
	
	@FindBy(xpath="//a[text()='Explore']")
	private WebElement ExploreMenu;
	
	public WebElement ExploreMenu() {
		return ExploreMenu;
	}
	
	@FindBy(xpath="//a[text()='Creator']")
	private WebElement CreatorMenu;
	
	public WebElement CreatorMenu() {
		return CreatorMenu;
	}
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div/div/p[1]/a")
    private WebElement ClickOnCreator;
    
    public WebElement ClickOnCreator() {
    	return ClickOnCreator;
    }
	
	@FindBy(xpath="//*[@class='w-8 h-8 flex items-center justify-center']")
    private WebElement ThreeDotIcon ;

    public WebElement  ThreeDotIcon () {
    	return  ThreeDotIcon;
    }
    
    @FindBy(xpath="//*[text()='Report']")
    private WebElement ReportButton ;

    public WebElement  ReportButton () {
    	return  ReportButton;
    }
    
    @FindBy(xpath="//*[text()='Cancel']")
    private WebElement CancelButton ;

    public WebElement  CancelButton () {
    	return  CancelButton;
    }
    
    @FindBy(xpath="//*[@class='svg-inline--fa fa-heart fa-w-16 fa-sm cursor-pointer']")
    private WebElement LikeButton ;

    public WebElement  LikeButton () {
    	return  LikeButton;
    }
    
    @FindBy(xpath="//*[text()='Share']")
    private WebElement ShareButton ;

    public WebElement  ShareButton () {
    	return  ShareButton;
    }

}
