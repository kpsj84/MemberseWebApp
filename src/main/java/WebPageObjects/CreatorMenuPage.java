package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatorMenuPage {
	
	WebDriver localDriver;
	
	public CreatorMenuPage(WebDriver driver)
	{
		this.localDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//input[@type='checkbox']")
     private WebElement checkbox ;
     
     public WebElement checkbox(){
   	  return checkbox;
     }

     @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[2]/div[1]/div/div[2]/div[2]/form/button")
     private WebElement CheckboxSave;
     
     public WebElement CheckboxSave(){
   	  return CheckboxSave;
     }
     
     
     @FindBy(xpath="/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div/div[1]/nav/div[4]/a")
     private WebElement creator1 ;
     
     public WebElement creator1(){
   	  return creator1;
     }

}
