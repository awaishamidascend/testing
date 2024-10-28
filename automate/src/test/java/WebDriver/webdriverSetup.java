package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverSetup {
    private String baseUrl = "https://efficonx.com";
    protected static WebDriver driver;
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

    // Load either the default base URL or a custom URL if provided
    public void loadBaseUrl(String customUrl) throws InterruptedException {
        if (driver != null) {
            if (customUrl != null && !customUrl.isEmpty()) {
                System.out.println("Loading custom URL: " + customUrl);
                driver.get(customUrl);  // Load custom URL
            } else {
                System.out.println("Loading default base URL: " + baseUrl);
                driver.get(baseUrl);  // Load default URL
            }
            driver.manage().window().maximize();
            System.out.println("Maximized the window.");
            Thread.sleep(3000);  // Adding a small wait to allow page load
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