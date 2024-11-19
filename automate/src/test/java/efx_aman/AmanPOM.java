package efx_aman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AmanPOM extends WebDriver.webdriverSetup {
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        public static void username(String username) {

            WebElement elem = driver.findElement(By.xpath("(//input[@placeholder='Email'])[1]"));
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

    public static void profile() {

        driver.findElement(By.xpath("(//img[@alt='avatarImg'])[1]")).click();
    }

    public static void logout() {

        driver.findElement(By.xpath("(//span[@class='align-middle mx-1'])[1]")).click();
    }

    public static void Secondurl() {

        driver.get("https://dev-efficax-obligation.kakashi.app/login?isQA=true");
    }

    public static void FORM() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul[1]/li[2]/a")).click();
    }

    public static void الصيدليات() {

        driver.findElement(By.xpath("//span[contains(text(),'الصيدليات')]")).click();
    }

    public static void export() {

        driver.findElement(By.xpath("//div[contains(@class,'icon')]//figure")).click();
    }

    public static void pdf() {

        driver.findElement(By.xpath("//div[@id='row-0']//div[@class='cursorPointer']//*[name()='svg']")).click();
    }

    public static void forgot() {

        driver.findElement(By.xpath("//p[@class='my-2']")).click();
    }
    public static void forgotemail(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Email']")));

        emailField.clear();  // Clear any pre-existing value
        emailField.sendKeys(username);  // Send the email (username)
    }

    public static void forgotemailsendbutton() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public static void search() {

        driver.findElement(By.xpath("//input[@placeholder='Search in the list']")).sendKeys("jizan");

    }
    public static void filter() {

        driver.findElement(By.xpath("//input[@placeholder='Filter Date']")).click();

    }
}

