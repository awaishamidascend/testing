package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class webdriverSetup {
    private String baseUrl = "https://dev.efficonx.com";
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

            // Read headless mode from system properties
            boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

            // Configure Firefox options
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) {
                options.addArguments("--headless");
                System.out.println("Running WebDriver in headless mode...");
            }

            options.addArguments("--disable-gpu"); // Recommended for some environments

            driver = new FirefoxDriver(options);
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
                driver.get(customUrl);
            } else {
                System.out.println("Loading default base URL: " + baseUrl);
                driver.get(baseUrl);
            }
            driver.manage().window().maximize();
            System.out.println("Maximized the window.");
            Thread.sleep(3000); // Adding a small wait to allow page load
        } else {
            throw new IllegalStateException("WebDriver is not initialized. Please initialize the WebDriver before calling loadBaseUrl().");
        }
    }

    // Overloaded method for no-argument version
    public void loadBaseUrl() throws InterruptedException {
        loadBaseUrl(null);
    }

    // Quit the WebDriver
    public void quitDriver() {
        if (driver != null) {
            System.out.println("Quitting WebDriver...");
            driver.quit();
            driver = null; // Reset driver to null after quitting
            System.out.println("WebDriver quit and reset to null.");
        }
    }
}
