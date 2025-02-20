package test.automate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.ConfigReader;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for the username field
    @FindBy(css = "input[placeholder='admin@gmail.com']")
    WebElement usernameField;

    // Locator for password field (uncomment and modify if needed)
    @FindBy(xpath = "//*[@id=\":r1:\"]")
    WebElement passwordField;

    // Locator for login button (uncomment and modify if needed)
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div/div[2]/div/div/form/button")
    WebElement loginButton;

    // Locator for error message (uncomment and modify if needed)
    @FindBy(xpath = "//*[@id=\":r0:-helper-text\"]")
    WebElement errorMessage;

    // Wait for element to be visible
    private void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // 10 seconds wait
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Methods
    public void enterUsername(String username) {
        waitForElementToBeVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementToBeVisible(loginButton);
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void loginUsingConfig() {
        String email = ConfigReader.getProperty("login.email");
        String password = ConfigReader.getProperty("login.password");
        System.out.println("Using email: " + email);
        System.out.println("Using password: " + password);
        login(email, password);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

}
