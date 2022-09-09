package Memberse.WebAppAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class WBase {
	
	//Initiate Variables
	public static ChromeOptions   opt;
	public static String 		  environment;
	public static FileInputStream fis;
	public static Properties 	  prop;
	public static WebDriver 	  driver;
	
	//Set Capabilities for the Browser & provide driver location
	public void  Capabilities() throws IOException {
		String driverLocation = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
		System.setProperty("webdriver.chrome.driver", driverLocation);
		
		//opt = new ChromeOptions();
		//opt.addArguments("--start-maximized");
		//opt.addArguments("disable-infobars");
		//opt.addArguments("--disbale-notifications");
		//opt.addArguments("--disable-extensions");
		
		environment = System.getProperty("env");
		System.out.println("Value for environment get via pom file --> " + environment);
		if(environment == null)
		{
			environment = "INT";
			System.out.println("Value Set for environment if not get from pom file --> " + environment);
		}
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Memberse/WebAppAutomation/"+environment+".properties");
		prop = new Properties();		 
		prop.load(fis);
		System.out.println("Complete value to get from properties file --> " + prop.toString());
	}
	
	@BeforeTest
	public void InvokeCapabilities() throws IOException {
		//Execute Capabilities
		Capabilities();
	}
	
	@AfterTest
	public void QuitBrowsers() {
		//Quit Driver when all Test Cases completed
		driver.quit();
	}
	
	@BeforeClass
	public void startDriver() throws InterruptedException, IOException {
		//Start new driver & Window before to every Test Class
		//driver = new ChromeDriver(opt);
		driver = new ChromeDriver();
		driver.get((String)prop.get("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void CloseBrowser() {
		System.out.println("Test Case Code Executed");
		driver.close();
	}

}
