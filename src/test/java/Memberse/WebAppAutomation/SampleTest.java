package Memberse.WebAppAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SampleTest extends abcBASE {
	
	@Test
	public void SampleTestCase() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("We are learning Automation aaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbejwkdjswidjwdjwskldjwldjwkldweldjewkdwefj");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
		Thread.sleep(3000);
	}

}
