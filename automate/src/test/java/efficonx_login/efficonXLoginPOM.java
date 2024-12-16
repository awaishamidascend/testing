package efficonx_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class efficonXLoginPOM extends WebDriver.webdriverSetup {

    public static void username(String username) {

        WebElement elem = driver.findElement(By.xpath("(//input[@id='username'])[1]"));
        elem.clear();
        elem.sendKeys(username);
    }

    public static void password(String password) {

        WebElement elem = driver.findElement(By.xpath("(//input[@id='password'])[1]"));
        elem.clear();
        elem.sendKeys(password);
    }

    public static void submit() {

        driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
    }

    public static void options() {

        driver.findElement(By.xpath("(//*[name()='svg'][@type='button'])[1]")).click();

    }

    public static void logout() {

        driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();

    }

}
