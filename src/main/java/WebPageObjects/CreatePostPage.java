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
	
	@FindBy(css="#news-item-form > div > div.space-y-4 > div:nth-child(1) > div > textarea")   
	private WebElement titleBox;
	
	public WebElement titleBox() {
		return titleBox;
	}
	
	@FindBy(css="#news-item-form > div > div.space-y-4 > div:nth-child(2) > div > textarea")   
	private WebElement descriptionBox;
	
	public WebElement descriptionBox() {
		return descriptionBox;
	}
	
	@FindBy(xpath="//*[@id=\"news-item-form\"]/div/div[3]/button[1]")   
	private WebElement photoButton;
	
	public WebElement photoButton() {
		return photoButton;
	}
	
	@FindBy(xpath="html/body/div[4]/div/div/div[2]/fieldset/div/div/div/div/div/div/div/div/div/div/div/label")   
	private WebElement uploadPhoto;
	
	public WebElement uploadPhoto() {
		return uploadPhoto;
	}
	
	@FindBy(xpath="//*[@id=\"news-item-form\"]/div/div[3]/button[2]") 
	private WebElement videoButton;
	
	public WebElement videoButton() {
		return videoButton;
	}
	
	@FindBy(xpath="/html/body/div[5]/div/div/div[2]/fieldset/div/div/div/div/div/div/div/div/div/div/div/label/span")   
	private WebElement uploadVideo;
	
	public WebElement uploadVideo() {
		return uploadVideo;
	}
	
	@FindBy(xpath="//*[@id=\"news-item-form\"]/div/div[3]/button[3]") 
	private WebElement audioButton;
	
	public WebElement audioButton() {
		return audioButton;
	}
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/fieldset/div/div/div/div/div/div/div/div/div/div/div/label/span")   
	private WebElement uploadAudio;
	
	public WebElement uploadAudio() {
		return uploadAudio;
	}
	
	
	@FindBy(xpath="//*[@class='translate-x-6 bg-neutral-1000 flex items-center justify-center h-4 w-4 transform rounded-full duration-300']")   
	private WebElement membersOnlyToggle;
	
	public WebElement membersOnlyToggle() {
		return membersOnlyToggle;
	}
	
	@FindBy(css="#news-item-form > div > div:nth-child(4) > div > div.flex-shrink > button > span")   
	private WebElement submitButton;
	
	public WebElement submitButton() {
		return submitButton;
	}

}
