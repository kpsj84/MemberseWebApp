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
	
	@FindBy(xpath="//a[@href='https://www.facebook.com/memberseapp']")
	private WebElement FacebookIcon;

	public WebElement FacebookIcon() {
	    return FacebookIcon;
	}

	@FindBy(xpath="//a[@href='https://www.instagram.com/memberse.app']")
	private WebElement InstagramIcon;

	public WebElement InstagramIcon() {
	    return InstagramIcon;
	}
	    
	    @FindBy(xpath="//a[@href='https://www.linkedin.com/company/memberse']")
	    private WebElement LinkedinIcon;

	    public WebElement LinkedinIcon() {
	    	return LinkedinIcon;
	    }
	    
	    @FindBy(xpath="//a[@href='https://www.tiktok.com/@memberse.app?lang=en']")
	    private WebElement TikTokIcon;

	    public WebElement TikTokIcon() {
	    	return TikTokIcon;
	    }
	          
	    @FindBy(xpath="//a[@href='https://memberse.com/terms-and-conditions/']")
	    private WebElement TermLink;

	    public WebElement TermLink() {
	    	return TermLink;   
	    }     
	        
	    @FindBy(xpath="//a[@href='https://memberse.com/community-guidelines/']")
	    private WebElement GuidelinesLink;

	    public WebElement GuidelinesLink() {
	        return GuidelinesLink;
	    }  
	        
	    @FindBy(xpath="//a[@href='https://memberse.com/privacy-policy-2/']")
	    private WebElement PrivacyLink;

	    public WebElement PrivacyLink() {
	        return PrivacyLink;
	    }
	    
	    @FindBy(xpath="//input[@name='name']")
	    private WebElement SearchField;

	    public WebElement SearchField() {
	        return SearchField;
	    }
	    
	    @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div[2]/div/div/div/div/a/div/div[2]/div/div/p[1]")
	    private WebElement ClickCreator ;
	    
	    public WebElement ClickCreator() {
	    	return ClickCreator;
	    }

}
