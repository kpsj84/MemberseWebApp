package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePostPage {
	
	WebDriver localDriver;
	
	public CreatePostPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="title")   
	private WebElement titleBox;
	
	public WebElement titleBox() {
		return titleBox;
	}
	
	@FindBy(name="content")   
	private WebElement descriptionBox;
	
	public WebElement descriptionBox() {
		return descriptionBox;
	}
	
	@FindBy(xpath="//button[@type='button' and .//span[contains(text(), 'Photo')]]")   
	private WebElement photoButton;
	
	public WebElement photoButton() {
		return photoButton;
	}
	
	@FindBy(xpath="//label[@for='file-upload' and .//span[contains(text(), 'Upload a file')]]")   
	private WebElement uploadPhoto;
	
	public WebElement uploadPhoto() {
		return uploadPhoto;
	}
	
	@FindBy(xpath="//button[@type='button' and .//span[contains(text(), 'Video')]]") 
	private WebElement videoButton;
	
	public WebElement videoButton() {
		return videoButton;
	}
	
	@FindBy(xpath="//label[@for='file-upload' and .//span[contains(text(), 'Upload a file')]]")   
	private WebElement uploadVideo;
	
	public WebElement uploadVideo() {
		return uploadVideo;
	}
	
	@FindBy(xpath="//button[@type='button' and .//span[contains(text(), 'Audio')]]") 
	private WebElement audioButton;
	
	public WebElement audioButton() {
		return audioButton;
	}
	
	@FindBy(xpath="//label[@for='file-upload' and .//span[contains(text(), 'Upload a file')]]")   
	private WebElement uploadAudio;
	
	public WebElement uploadAudio() {
		return uploadAudio;
	}
	
	
	@FindBy(xpath="//button[@role='switch']")   
	private WebElement membersOnlyToggle;
	
	public WebElement membersOnlyToggle() {
		return membersOnlyToggle;
	}
	
	@FindBy(xpath="//span[contains(text(),'Submit')]")   
	private WebElement submitButton;
	
	public WebElement submitButton() {
		return submitButton;
	}

}
