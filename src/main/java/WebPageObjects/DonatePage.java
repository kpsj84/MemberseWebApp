package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DonatePage {
	
WebDriver localDriver;
	
	public DonatePage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[4]/div/div/div[1]/div[4]")
    private WebElement SelectDonateAmount ;

    public WebElement  SelectDonateAmount() {
    	return  SelectDonateAmount;
    }
    
    @FindBy(xpath="//*[text()='Donate 10 USD']")
    private WebElement DonatePriceButton ;

    public WebElement  DonatePriceButton() {
    	return  DonatePriceButton;
    }

}
