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
	
	@FindBy(xpath="//div[@class='bg-neutral-2000 text-neutral-9000  text-base font-medium cursor-pointer flex justify-center rounded-lg py-2 px-5 flex-grow'][4]")
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
