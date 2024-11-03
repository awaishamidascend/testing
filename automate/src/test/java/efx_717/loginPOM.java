package efx_717;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPOM extends WebDriver.webdriverSetup {

    public static void username(String username) {
        WebElement elem = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        elem.clear();
        elem.sendKeys(username);
    }

    public static void password(String password) {
        WebElement elem = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        elem.clear();
        elem.sendKeys(password);
    }

    public static void submit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void OTP(String otp) {
        // Loop through each digit of the OTP and enter it into the input field
        for (int i = 0; i < otp.length(); i++) {
            char digit = otp.charAt(i);
            String digitAsString = Character.toString(digit);
            // Construct XPath for locating each box of the OTP input field
            String xpath = "//input[@aria-label='Please enter OTP character " + (i + 1) + "']";
            WebElement otpBox = driver.findElement(By.xpath(xpath));
            otpBox.sendKeys(digitAsString);
        }
    }

    public static void SubmitOTP() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void openDropdown() {
        driver.findElement(By.xpath("//div[@class='select__indicator select__dropdown-indicator css-qj08tm-indicatorContainer']")).click();
    }
    public static void selectRole(){
        driver.findElement(By.xpath("//div[contains(@class, 'select__option') and contains(@class, 'css-6ie4tr-option') and text()='Admin']")).click();
    }
    public static void SubmitRole(){
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
    }
    public static void Dashboard(){
        driver.findElement(By.xpath("//li[@class='nav-item']/a[@href='/Dashboard' and contains(@class, 'active')]/span[text()='Dashboard']")).click();
    }
}
