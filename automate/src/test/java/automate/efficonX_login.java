package automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class efficonX_login {

    public static void main(String[] args) throws InterruptedException {

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the EfficonX website
            driver.get("https://efficonx.com");

            // Wait for the page to load
            Thread.sleep(5000);  // Handle the InterruptedException

            // Find and fill in the email and password fields
            driver.findElement(By.xpath("(//input[@id='username'])[1]")).sendKeys("awais.hamid@ascend.com.sa");
            driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys("eod777");

            // Click on the login button
            driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();

            Thread.sleep(10000); 

            driver.findElement(By.xpath("(//*[name()='svg'][@type='button'])[1]")).click();
            driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
            Thread.sleep(5000); 


            
        }
    }

