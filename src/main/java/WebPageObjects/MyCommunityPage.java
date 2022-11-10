package WebPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCommunityPage {
	
	public WebDriver localdriver;
	
	public MyCommunityPage(WebDriver driver) {
		this.localdriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div[3]/main/div/div[1]/div/div[1]/div[2]/div/p[1]")
	private WebElement MyCommunitySubMenu;
	
	public WebElement MyCommunitySubMenu(){
		return MyCommunitySubMenu;
	}
	
	@FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div.flex-grow > div > div:nth-child(1) > div > div.px-4.rounded-lg.text-sm.sm\\:text-base.font-medium.cursor-pointer.flex.items-center.justify-center.py-2.bg-neutral-3000.text-neutral-9000")
	private WebElement EditInfoTab;
	
	public WebElement EditInfoTab(){
		return EditInfoTab;
	}
	
	@FindBy(css="#__next > div.h-full.text-neutral-9000.dark\\:text-neutral-1000.custom-scroll > div > div.pl-64.flex.flex-col.flex-1 > main > div > div.space-y-6.h-full > div.flex.w-full > div > div > div.flex-grow > div > div.py-5 > div > form > div.space-y-6 > div:nth-child(3) > div > textarea")
	private WebElement EditInfoDescription;
	
	public WebElement EditInfoDescription(){
		return EditInfoDescription;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement EditInfoTabSave;
	
	public WebElement EditInfoTabSave () {
		return EditInfoTabSave;
	}
	
	@FindBy(xpath="//span[text()='Pricing']")
	private WebElement PricingTab;
	
	public WebElement PricingTab(){
		return PricingTab;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement PricingTabSave;
	
	public WebElement PricingTabSave () {
		return PricingTabSave;
	}

}
