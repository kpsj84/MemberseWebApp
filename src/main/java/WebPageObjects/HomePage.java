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

}
