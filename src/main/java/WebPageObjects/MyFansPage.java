package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyFansPage {

	public WebDriver localdriver;
		
	public MyFansPage(WebDriver driver) {
		this.localdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='My Fans']")
	private WebElement MyFansSubMenu ;
	
	public WebElement MyFansSubMenu() {
		return  MyFansSubMenu;
	}

}
