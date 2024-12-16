package efficonx_reports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class reportsPOM extends WebDriver.webdriverSetup {

    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    public static void reports() {

        WebElement scroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Reports'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

        driver.findElement(By.xpath("(//span[normalize-space()='Reports'])[1]")).click();

    }

    public static void export() throws InterruptedException {

        WebElement export = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Export')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", export);
        //driver.findElement(By.xpath("//button[contains(text(),'Export')]")).click();

    }

}
