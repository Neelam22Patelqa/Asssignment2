import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\TestingTools\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		
		try{
			driver.switchTo().alert().accept();
		}catch(Exception e) {
			System.out.println("alert not present");
		}
		if(driver.findElement(By.xpath("//input[@id='OneWay']")).isSelected())
			{
			System.out.println("it is selected");
			}else {
				driver.findElement(By.xpath("//input[@id='OneWay']")).click();
				}
		/*driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Det");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@class,'child list')]/a"));
		
		for(WebElement option: options) {
			if(option.getText().equalsIgnoreCase("Detroit, US - Detroit Metro Wayne Cnty (DTW)")){
				option.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> optionsTo= driver.findElements(By.xpath("//li[@class='list']"));
		for(WebElement optionTo: optionsTo) {
			if(optionTo.getText().equalsIgnoreCase("Ahmedabad, IN - Sardar Vallabh Bhai Patel (AMD)"));
			break;
			
		}*/
		
		try{
			driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		}catch(Exception e) {
			System.out.println("can not find Dates");
		}
		
		Select adult =new Select(driver.findElement(By.id("Adults")));
		adult.selectByIndex(3);
		Select children =new Select(driver.findElement(By.id("Childrens")));
		children.selectByIndex(2);
		Select infants =new Select(driver.findElement(By.id("Infants")));
		infants.selectByIndex(0);
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		driver.findElement(By.xpath("//input[@name='airline']")).sendKeys("Del");
		Thread.sleep(2000);
		List<WebElement> Airlines= driver.findElements(By.xpath("//li[@class='list']/a"));
		for (WebElement Airline:Airlines) {
			if(Airline.getText().equalsIgnoreCase("Delta (DL)")) {
				Airline.click();
				break;
				
			}
		}
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		String actualText=driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText();
		System.out.println(actualText);
	}

}
