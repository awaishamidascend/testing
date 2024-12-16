package automate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class efficonX_login_test {
	
	private static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the EfficonX website
            driver.get("https://efficonx.com");
            
            // Wait for the page to load
            Thread.sleep(5000);  // Handle the InterruptedException

            efficonX_login_page.username(driver).sendKeys("awais.hamid@ascend.com.sa");
            efficonX_login_page.password(driver).sendKeys("eod777");
            efficonX_login_page.submit(driver).click();

            Thread.sleep(10000); 

            efficonX_login_page.options(driver).click();
            efficonX_login_page.logout(driver).click();
           
            Thread.sleep(5000); 

        }
    }

