package automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class efficonX_login_page {

	private static WebElement element = null;
	
	
	public static WebElement username (WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@id='username'])[1]"));
		return element;
		
	}

	public static WebElement password (WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@id='password'])[1]"));
		return element;
		
	}
	
	public static WebElement submit (WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//button[@class='btn'])[1]"));
		return element;
		
	}
	
	public static WebElement options (WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//*[name()='svg'][@type='button'])[1]"));
		return element;
		
	}
	
	public static WebElement logout (WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]"));
		return element;
		
	}
	
}
