package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DMPage {
	
	WebDriver localDriver;
	
	public DMPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[class*='group relative w-full flex'] span[class='text-base font-medium leading-4']")   
	private WebElement writeMessage;
	
	public WebElement writeMessage() {
		return writeMessage;
	}
	
	@FindBy(xpath="//textarea[@name='content']")   
	private WebElement dmText;
	
	public WebElement dmText() {
		return dmText;
	}
	
	@FindBy(xpath="//span[contains(text(), 'Preview')]")   
	private WebElement previewButton;
	
	public WebElement previewButton() {
		return previewButton;
	}
	
	@FindBy(xpath="//*[@data-icon='paper-plane']")   
	private WebElement sendDM;
	
	public WebElement sendDM() {
		return sendDM;
	}
	
	@FindBy(xpath="(//span[text()='kqacreator LN'])")   
	private WebElement creatorName;
	
	public WebElement creatorName() {
		return creatorName;
	}

}
