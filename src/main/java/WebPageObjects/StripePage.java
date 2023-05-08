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
	    
	    @FindBy(xpath="//div[@class='SubmitButton-IconContainer' and //span[contains(text(),'Pay')]]")
	    private WebElement PayDonationButton;

	    public WebElement PayDonationButton() {
	    	return PayDonationButton;
	    }
	    
	    @FindBy(xpath="//span[contains(text(), 'the test phone number')]")
	    private WebElement testPhoneNumber;

	    public WebElement testPhoneNumber() {
	    	return testPhoneNumber;
	    }
	    
	    @FindBy(xpath="//span[contains(text(), 'Use test code')]")
	    private WebElement testPhoneCode;

	    public WebElement testPhoneCode() {
	    	return testPhoneCode;
	    }
	    
	    @FindBy(id="first_name")
	    private WebElement firstName;

	    public WebElement firstName() {
	    	return firstName;
	    }
	    
	    @FindBy(id="last_name")
	    private WebElement lastName;

	    public WebElement lastName() {
	    	return lastName;
	    }
	    
	    @FindBy(id="business_profile[url]")
	    private WebElement bussinessUrl;

	    public WebElement bussinessUrl() {
	    	return bussinessUrl;
	    }
	    
	    @FindBy(xpath="//span[contains(text(), 'Use test account')]")
	    private WebElement testAccount;

	    public WebElement testAccount() {
	    	return testAccount;
	    }

}
