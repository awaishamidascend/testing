package efficonx_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class projectsPOM extends WebDriver.webdriverSetup {

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

    public static void projects() throws InterruptedException {

        WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Projects'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", project);
        project.click();
        System.out.println("Opened Projects");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[normalize-space()='New Project']")).click();
        System.out.println("Opened New Projects");

    }

    public static void create_projects() throws InterruptedException {

        //Entering Name
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='name'])[1]")));
        name.sendKeys("Awais Hamid");

        //Entering Code
        WebElement code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='code'])[1]")));
        code.sendKeys("555");

        //Entering Date
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='date'])[1]")));
        //date.click();
        System.out.println("Clicked Date");
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '12/09/2024';", date);
        date.sendKeys("12092024");

        date.sendKeys("11111111");
        System.out.println("Entered Date");

        //Entering Client
        WebElement client = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Select client'])[1]")));
        client.click(); // Click to open the dropdown
        client.sendKeys("NUPCO");
        System.out.println("Sent keys NUPCO");

        // Wait for the option to become visible and clickable
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/div[2]/input[1]")));
        // Click the option once it's visible
        optionToSelect.click();
        System.out.println("Opened New Projects");

    }

}
