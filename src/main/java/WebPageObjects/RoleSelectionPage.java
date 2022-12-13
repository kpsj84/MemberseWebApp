package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoleSelectionPage {
	
	 public WebDriver localdriver;

     public RoleSelectionPage(WebDriver driver) 
     {
    	 this.localdriver=driver;
    	 PageFactory.initElements(driver, this);
     }
     
      @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div[1]/div[1]/div[1]/h3")
      private WebElement AsaMember ;
      
      public WebElement AsaMember() {
    	  return  AsaMember ;
      }
      
      @FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div/div/div/div[2]/div[1]/div[1]/h3")
      private WebElement AsaCreator ;
      
      public WebElement AsaCreator() {
    	  return  AsaCreator ;
      }

}
