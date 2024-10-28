package efx_timesheets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class timesheetsPOM extends WebDriver.webdriverSetup{

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

    public static void timesheetbtn() {

        driver.findElement(By.xpath("//span[contains(text(),'Timesheets')]")).click();
    }

    public static void previousweek() {

        driver.findElement(By.xpath("//div[@class='weekContainer']//div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")).click();
    }

}
