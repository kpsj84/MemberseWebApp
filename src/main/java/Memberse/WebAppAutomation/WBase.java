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
	
	//For Jenkin Server
	public static boolean intelJenkinsServer = false;
	
	//Initiate Variables
	public static ChromeOptions   options;
	public static String 		  environment;
	public static FileInputStream fis;
	public static Properties 	  prop;
	public static WebDriver 	  driver;
	public static String 	  	  driverLocation;
	
	//Set Capabilities or Options for the Browser & provide driver location
	public static void  Capabilities() throws IOException {
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
		options.addArguments("--start-maximized");			//Its working, Browser window becomes to maximum size but not fullscreen
		options.addArguments("--disable-notifications");  	//This is to stop appearing Push notifications messages on browser window, may it not work in Mac OS
		//options.addArguments("--headless");			  	//Its working, for UI less testing
		//options.addArguments("--start-fullscreen");		//Its for Fullscreen which is greater than Maximized mode and working
		//options.addArguments("--disable-infobars");  	  	//This is to remove the line at top of browser window which inform that browser is controlled by automated software, may deprecated
		//options.addArguments("--disable-extensions");	  	//This is to disable extensions installed to Chrome browser
		
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
	
	//Annotation's for xml file
	@BeforeTest
	public void InvokeCapabilities() throws IOException {
		//Execute Capabilities
		Capabilities();
	}
	
	@AfterTest
	public void endSuite() {
		//Print Message
		System.out.println("Test Suite Executed");
		driver.quit();
	}
	
	@BeforeClass
	public void startDriver() throws IOException {
		//Start new driver & Window before to every Test Class
		driver = new ChromeDriver(options);
		driver.get((String)prop.get("Url"));
	}
	
	@AfterClass
	public void quitDriver() {
		//Quit Driver after each Test Case Executed
		//driver.close();		//This just close current active window
		driver.quit();
		System.out.println("Test case execution complete");
	}

}
