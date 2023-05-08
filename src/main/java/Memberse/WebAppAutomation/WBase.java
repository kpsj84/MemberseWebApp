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
	public static boolean intelMacJenkinsServer = true;
	public static boolean winJenkinsServer = false;
	
	//Initiate Variables
	public static ChromeOptions   options;
	public static String 		  environment;
	public static FileInputStream fis;
	public static Properties 	  prop;
	public static WebDriver 	  driver;
	public static String 	  	  driverLocation;
	public 		  int 			  testStatus = 2;
	
	//Set Capabilities or Options for the Browser & provide driver location
	public static void  Capabilities() throws IOException {
		if(intelMacJenkinsServer == true)
		{
			driverLocation = (System.getProperty("user.dir")+"/src/intelMacChromeDriver/chromedriver");
		}
		else if(winJenkinsServer == true)
		{
			driverLocation = (System.getProperty("user.dir")+"/src/winChromeDriver/chromedriver.exe");
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
		
		//Get property "env" from pom.xml file
		environment = System.getProperty("env");
		System.out.println("Value for environment get via pom file --> " + environment);
		if(environment == null)
		{
			environment = "QA";
			System.out.println("Value Set for environment if not get from pom file --> " + environment);
		}
		
		//Ref to file which is to read or taken some from it
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Memberse/WebAppAutomation/"+environment+".properties");
		prop = new Properties();		 
		prop.load(fis); 									//Load reference of that file which is to read
		System.out.println("Complete value taken from properties file --> " + prop.toString());
	}
	
	//Annotation's for testng.xml file
	@BeforeTest
	public void InvokeCapabilities() throws IOException {
		//Execute Capabilities
		Capabilities();
	}
	
	@AfterTest
	public void endSuite() {
		//Print Message
		System.out.println("Test Suite Execution Done");
		driver.quit();
	}
	
	@BeforeClass
	public void startDriver() throws IOException {
		//Start new driver & open new Window before to every Test Class
		driver = new ChromeDriver(options);
		driver.get((String)prop.get("Url"));
	}
	
	@AfterClass
	public void quitDriver() {
		//Quit Driver after each Test Case Executed
		//driver.close();									//This just close current active window
		driver.quit();
		
		if(testStatus == 2)
		{
			System.out.println("Test case is Fail");
		}
		else
		{
			System.out.println("Test case is QA Pass");	
		}
	}

}
