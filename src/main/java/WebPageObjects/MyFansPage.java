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
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[5]/div[2]/div/p[1]")
	private WebElement MyFansSubMenu ;
	
	public WebElement MyFansSubMenu() {
		return  MyFansSubMenu;
	}

}
