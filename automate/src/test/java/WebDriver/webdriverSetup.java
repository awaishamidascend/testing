package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverSetup {
    private String baseUrl = "https://dev-efficax-obligation.kakashi.app/login?isQA=true";
    public static WebDriver driver;
    private static webdriverSetup driverManager;

    // Singleton pattern to ensure only one instance of webdriverSetup exists
    public static webdriverSetup getInstance() {
        if (driverManager == null) {
            System.out.println("Creating new instance of webdriverSetup");
            driverManager = new webdriverSetup();
        }
        return driverManager;
    }

    // Initialize the WebDriver
    public void webdriverSetup() {
        try {
            System.out.println("Setting up WebDriver...");
            String fireFoxDriverPath = "src/test/resources/drivers/geckodriver.exe"; // Adjust path as necessary
            System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
//            ChromeOptions options = new ChromeOptions();
//            // If Chrome is in a non-standard location, set the binary path
//            options.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe"); // Replace with your Chrome path if different
            driver = new FirefoxDriver();
            System.out.println("WebDriver initialized: " + (driver != null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load the base URL
    public void loadBaseUrl() throws InterruptedException {
        if (driver != null) {
            System.out.println("Loading base URL: " + baseUrl);
            driver.get(baseUrl);
            driver.manage().window().maximize();
            Thread.sleep(5000);
        } else {
            throw new IllegalStateException("WebDriver is not initialized. Please initialize the WebDriver before calling loadBaseUrl().");
        }
    }

    // Quit the WebDriver
    public void quitDriver() {
        if (driver != null) {
            System.out.println("Quitting WebDriver...");
            driver.quit();
            driver = null; // Reset driver to null after quitting
        }
    }
}