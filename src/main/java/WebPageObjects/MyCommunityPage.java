package WebPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCommunityPage {
	
	public WebDriver localdriver;
	
	public MyCommunityPage(WebDriver driver) {
		this.localdriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(),'My Community')]")
	private WebElement MyCommunitySubMenu;
	
	public WebElement MyCommunitySubMenu(){
		return MyCommunitySubMenu;
	}
	
	@FindBy(xpath="//*[contains(text(),'Edit info')]")
	private By EditInfoTab;
	
	public By EditInfoTab(){
		return EditInfoTab;
	}
	
	@FindBy(name="description")
	private WebElement EditInfoDescription;
	
	public WebElement EditInfoDescription(){
		return EditInfoDescription;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement EditInfoTabSave;
	
	public WebElement EditInfoTabSave () {
		return EditInfoTabSave;
	}
	
	@FindBy(xpath="//span[text()='Pricing']")
	private WebElement PricingTab;
	
	public WebElement PricingTab(){
		return PricingTab;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement PricingTabSave;
	
	public WebElement PricingTabSave () {
		return PricingTabSave;
	}

}
