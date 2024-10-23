package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class webdriverSetup {
    private String baseUrl = "https://dev.efficonx.com";
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

    // Initialize the WebDriver in headless mode for Ubuntu
    public void webdriverSetup() {
        try {
            System.out.println("Setting up WebDriver...");

            // Choose Firefox or Chrome (adjust based on your needs)
            boolean useFirefox = true; // Set to false if you want to use Chrome

            if (useFirefox) {
                // Path to geckodriver, assuming it's in /usr/local/bin/ for Ubuntu
                String fireFoxDriverPath = "/usr/local/bin/geckodriver";
                System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);

                // Initialize Firefox options with headless mode
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless"); // Enable headless mode

                driver = new FirefoxDriver(options); // Pass the options to FirefoxDriver
                System.out.println("Firefox WebDriver initialized in headless mode: " + (driver != null));
            } else {
                // Path to chromedriver, assuming it's in /usr/local/bin/ for Ubuntu
                String chromeDriverPath = "/usr/local/bin/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);

                // Initialize Chrome options with headless mode
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Enable headless mode
                options.addArguments("--no-sandbox"); // Recommended for Linux
                options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems

                driver = new ChromeDriver(options); // Pass the options to ChromeDriver
                System.out.println("Chrome WebDriver initialized in headless mode: " + (driver != null));
            }

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
            Thread.sleep(3000);
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
