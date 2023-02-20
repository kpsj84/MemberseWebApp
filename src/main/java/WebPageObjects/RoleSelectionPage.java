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
     
      @FindBy(xpath="//h3[contains(text(),'As a Member')]")
      private WebElement AsaMember ;
      
      public WebElement AsaMember() {
    	  return  AsaMember ;
      }
      
      @FindBy(xpath="//h3[contains(text(),'As a Creator')]")
      private WebElement AsaCreator ;
      
      public WebElement AsaCreator() {
    	  return  AsaCreator ;
      }

}
