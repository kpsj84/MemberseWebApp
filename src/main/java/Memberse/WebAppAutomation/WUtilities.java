package Memberse.WebAppAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WUtilities {
	
	WebDriver localDriver;
	
	public WUtilities(WebDriver driver) {
		this.localDriver = driver;
	}
	
	public void loadDelay() throws InterruptedException {
		System.out.println("From load delay method, loading in progress...");
		Thread.sleep(7000);
		System.out.println("load delay completed");
	}
	
	public void apiDelay() throws InterruptedException {
		System.out.println("From api call delay method, response awaiting...");
		Thread.sleep(10000);
		System.out.println("api call delay completed");
	}
	
	public void shortDelay() throws InterruptedException {
		System.out.println("From api call delay method, response awaiting...");
		Thread.sleep(4000);
		System.out.println("api call delay completed");
	}

	public WebDriverWait callExplicitWait() {
		int seconds = 60;
		System.out.println("From Explicit Wait method, please wait...");
		WebDriverWait ewait = new WebDriverWait(localDriver, seconds);
		return ewait;
	}
	
	public WebDriver callImplicitWait() {
		WebDriver iWait = (WebDriver) localDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return iWait;
	}
	
	public WebElement elementToBeClickable(WebDriverWait ewait, WebElement webElement) {
		WebElement resElement = ewait.until(ExpectedConditions.elementToBeClickable(webElement));
		return resElement;
	}
	
	public WebElement visibilityOfElementLocated(WebDriverWait ewait, By obj) {
		WebElement resElement = ewait.until(ExpectedConditions.visibilityOfElementLocated(obj));
		return resElement;
	}
	
	public WebElement presenceOfElementLocated(WebDriverWait ewait, By obj) {
		WebElement resElement = ewait.until(ExpectedConditions.presenceOfElementLocated(obj));
		return resElement;
	}
}
