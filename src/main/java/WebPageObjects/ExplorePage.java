package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage {
	
	WebDriver localDriver;
	
	public ExplorePage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement LoginButton;
	
	public WebElement LoginButton() {
		return LoginButton;
	}
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/a[2]")
	private WebElement SignupButton;
	
	public WebElement SignupButton() {
		return SignupButton;
	}
	
	 @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[3]/div/a[1]")
	    private WebElement FacebookIcon;

	    public WebElement FacebookIcon() {
	    	return FacebookIcon;
	    }

	    @FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div/div[3]/div/a[2]")
	    private WebElement InstagramIcon;

	    public WebElement InstagramIcon() {
	    	return InstagramIcon;
	    }
	    
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[3]/div/a[3]")
	    private WebElement LinkedinIcon;

	    public WebElement LinkedinIcon() {
	    	return LinkedinIcon;
	    }
	    
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[3]/div/a[4]")
	    private WebElement TikTokIcon;

	    public WebElement TikTokIcon() {
	    	return TikTokIcon;
	    }
	          
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[4]/div/a[1]")
	    private WebElement TermLink;

	    public WebElement TermLink() {
	    	return TermLink;   
	    }     
	        
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[4]/div/a[2]")
	    private WebElement GuidelinesLink;

	    public WebElement GuidelinesLink() {
	        return GuidelinesLink;
	    }  
	        
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[1]/div[2]/div/div/div[4]/div/a[3]")
	    private WebElement PrivacyLink;

	    public WebElement PrivacyLink() {
	        return PrivacyLink;
	    }
	    
	    @FindBy(xpath="//input[@name='name']")
	    private WebElement SearchField;

	    public WebElement SearchField() {
	        return SearchField;
	    }

}
