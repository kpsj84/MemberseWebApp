package Memberse.WebAppAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class WBase {
	
	public static boolean intelJenkinsServer = false;
	
	//Initiate Variables
	public static ChromeOptions   options;
	public static String 		  environment;
	public static FileInputStream fis;
	public static Properties 	  prop;
	public static WebDriver 	  driver;
	public static String 	  	  driverLocation;
	
	//Set Capabilities for the Browser & provide driver location
	public void  Capabilities() throws IOException {
		if(intelJenkinsServer == true)
		{
			driverLocation = (System.getProperty("user.dir")+"/src/intelChromeDriver/chromedriver");
		}
		else
		{
			driverLocation = (System.getProperty("user.dir")+"/src/chromedriver/chromedriver");
		}
		System.setProperty("webdriver.chrome.driver", driverLocation);
		
		options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless");
		//options.addArguments("--start-fullscreen");
		//options.addArguments("start-maximized");
		//options.addArguments("--disable-infobars");
		//options.addArguments("--disbale-notifications");
		//options.addArguments("--disable-extensions");
		
		environment = System.getProperty("env");
		System.out.println("Value for environment get via pom file --> " + environment);
		if(environment == null)
		{
			environment = "QA";
			System.out.println("Value Set for environment if not get from pom file --> " + environment);
		}
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Memberse/WebAppAutomation/"+environment+".properties");
		prop = new Properties();		 
		prop.load(fis);
		System.out.println("Complete value taken from properties file --> " + prop.toString());
	}
	
	@BeforeTest
	public void InvokeCapabilities() throws IOException {
		//Execute Capabilities
		Capabilities();
	}
	
	@AfterTest
	public void QuitBrowsers() throws InterruptedException {
		//Quit Driver when all Test Cases completed
		driver.quit();
	}
	
	@BeforeClass
	public void startDriver() throws InterruptedException, IOException {
		//Start new driver & Window before to every Test Class
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get((String)prop.get("Url"));
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		System.out.println("Test Case Code Executed");
		driver.close();
	}

}
