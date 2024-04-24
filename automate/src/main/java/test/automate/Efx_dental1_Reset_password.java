package test.automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Efx_dental1_Reset_password {
	 public static void main(String[] args) throws InterruptedException {
	        // Setup WebDriver
	        WebDriverManager.chromedriver().setup();
	        
	        // Create a new instance of ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        
	        // Open the webpage
	        driver.get("https://efficax-dental.ascend.com.sa/");
	        
	        // Wait for 10 seconds to allow the page to load fully
	            Thread.sleep(10000);
	       
	        // Maximize the browser window
	        driver.manage().window().maximize();
	        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div[1]/div[2]/div/div/form/div/div[4]/div/div[2]/a")); element.click();
	        
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/div/div/div/form/div/div[2]/div/input")).sendKeys("rida.khan@ascend.com.sa");
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/div/div/div/form/div/button[1]")).click();
	        Thread.sleep(10000);

	        		
	 }
}
