package WebPageObjects;

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
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[2]/div/span[1]/button/span")   
	private WebElement createPost;
	
	public WebElement createPost() {
		return createPost;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[2]/div/span[2]/div/div/div")   
	private WebElement ProfilePic;
	
	public WebElement ProfilePic() {
		return ProfilePic;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/button")
	private WebElement filterButton;
	
	public WebElement filterButton(){
		return filterButton;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div[3]/button/span")
	private WebElement filterToggle ;
	
	public WebElement filterToggle() {
		return filterToggle;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div[1]/button/span")
	private WebElement filterSave;
	
	public WebElement filterSave() {
		return filterSave;
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
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/nav/div[4]/a")
	private WebElement CreatorMenu;
	
	public WebElement CreatorMenu() {
		return CreatorMenu;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div/div/p[1]/a")
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
    
    @FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div:nth-child(3) > div.space-y-2 > div > div > div:nth-child(1) > div > div:nth-child(3) > div > div.flex.items-center.text-xs.space-x-4 > div:nth-child(1) > svg")
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
