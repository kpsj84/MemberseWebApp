package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StripePage {
		
	WebDriver localDriver;
			
		public StripePage(WebDriver driver)
		{
			this.localDriver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id=\"email\"]")
	    private WebElement Email;

	    public WebElement Email() {
	    	return Email;
	    }
	    
	    @FindBy(xpath="//*[@id=\"cardNumber\"]")
	    private WebElement CardNumber;

	    public WebElement CardNumber() {
	    	return CardNumber;
	    }
	    
	    @FindBy(xpath="//*[@id=\"cardExpiry\"]")
	    private WebElement CardExpiry;

	    public WebElement CardExpiry() {
	    	return CardExpiry;
	    }	
	    	
	    @FindBy(xpath="//*[@id=\"cardCvc\"]")
	    private WebElement CVCNumber;

	    public WebElement CVCNumber() {
	    	return CVCNumber;
	    }
	    
	    @FindBy(xpath="//*[@id=\"billingName\"]")
	    private WebElement CardName;

	    public WebElement CardName() {
	    	return CardName;
	    }
	    
	    @FindBy(xpath="//*[@id=\"billingPostalCode\"]")
	    private WebElement ZipCode;

	    public WebElement ZipCode() {
	    	return ZipCode;
	    }
	    
	    @FindBy(xpath="//button[@class='SubmitButton SubmitButton--complete' and //span[contains(text(),'Subscribe')]]")
	    private WebElement SubscribeButton;

	    public WebElement SubscribeButton() {
	    	return SubscribeButton;
	    }
	    
	    @FindBy(css="#root > div > div.App.App--keyboardInteractionMode.App--singleItem > div.App-Payment > div > div.PaymentFormFixedHeightContainer.flex-container.direction-column > form > div.PaymentForm-confirmPaymentContainer.mt4.flex-item.width-grow > div > div:nth-child(2) > button > div.SubmitButton-IconContainer")
	    private WebElement PayDonationButton;

	    public WebElement PayDonationButton() {
	    	return PayDonationButton;
	    }

}
