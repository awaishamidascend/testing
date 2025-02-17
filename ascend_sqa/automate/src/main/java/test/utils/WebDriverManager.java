package test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;


    // Private constructor to prevent instantiation
    private WebDriverManager() {}

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver instance
        }
    }
}