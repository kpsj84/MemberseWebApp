package WebPageObjects;

import java.util.List;

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
	
	@FindBy(css="div[class='opacity-100 duration-1000 transition h-9 w-9 rounded-full bg-cover bg-center']")   
	private WebElement ProfilePic;
	
	public WebElement ProfilePic() {
		return ProfilePic;
	}
	
	@FindBy(xpath="//span[contains(text(),'Edit profile')]")   
	private WebElement rightSideEditProfile;
	
	public WebElement rightSideEditProfile() {
		return rightSideEditProfile;
	}
	
	@FindBy(xpath="//p[contains(text(),'Creator')]")   
	private WebElement rightSideCreator;
	
	public WebElement rightSideCreator() {
		return rightSideCreator;
	}
	
	@FindBy(xpath="//p[contains(text(),'Log out')]")   
	private WebElement rightSideLogout;
	
	public WebElement rightSideLogout() {
		return rightSideLogout;
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
	
	@FindBy(xpath="//*[@data-icon='comment']")
	private WebElement commentOnPost;
	
	public WebElement commentOnPost() {
		return commentOnPost;
	}
	
	@FindBy(name="comment")
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
	
	@FindBy(xpath="//p[@class=' text-sm font-semibold line-clamp-1'] //a")
    private WebElement ClickOnCreator;
    
    public WebElement ClickOnCreator() {
    	return ClickOnCreator;
    }
	
	@FindBy(xpath="//span[@class='w-8 h-8 flex items-center justify-center']")
    private List<WebElement> ThreeDotIcon ;

    public List<WebElement>  ThreeDotIcon () {
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
    
    @FindBy(xpath="//*[@data-icon='heart']")
    private WebElement LikeButton ;

    public WebElement  LikeButton () {
    	return  LikeButton;
    }
    
    @FindBy(xpath="//*[text()='Share']")
    private List<WebElement> ShareButton ;

    public List<WebElement>  ShareButton () {
    	return  ShareButton;
    }

}
