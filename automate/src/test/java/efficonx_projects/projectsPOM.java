package efficonx_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.format.DateTimeFormatter;


import java.time.Duration;
import java.time.LocalDate;


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
        Thread.sleep(2000);

        //(JavascriptExecutor) driver).executeScript("arguments[0].value = '12092024';", date);
        //date.sendKeys("12092024");

        //On change method of entering date

        // Step 1: Locate and click the calendar icon to open the date picker
        WebElement calendarIcon = driver.findElement(By.xpath("//input[@id='date']"));
        calendarIcon.click();

        // Step 2: Wait for the calendar to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'calendar-container')]")));

        // Step 3: Select the desired date (e.g., 15th of the current month)
        WebElement desiredDate = driver.findElement(By.xpath("//td[@aria-label='Choose Friday, December 15th, 2024']"));
        desiredDate.click();

        // Step 4: Verify if the date has been set (optional)
        String enteredDate = calendarIcon.getAttribute("value");
        System.out.println("Selected Date: " + enteredDate);


        // Entering Start Date
        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='date']")));
        String jsFormattedStartDate = "2024-09-12"; // yyyy-MM-dd format
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", startDate, jsFormattedStartDate);
        System.out.println("Start Date set using JS Executor: " + jsFormattedStartDate);
        Thread.sleep(2000);

        // Entering End Date
        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Enddate']")));
        String jsFormattedEndDate = "2025-12-12"; // yyyy-MM-dd format
        js.executeScript("arguments[0].value = arguments[1];", endDate, jsFormattedEndDate);
        System.out.println("End Date set using JS Executor: " + jsFormattedEndDate);
        Thread.sleep(2000);

        // Entering Client
        WebElement client = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select client']")));
        client.click(); // Click to open the dropdown
        System.out.println("Clicked Dropdown");

        Thread.sleep(2000);
        WebElement drop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-controls='listbox-null']")));

        // Find the search field within the dropdown (assuming it's an input element)
        drop.sendKeys("NPHIES"); // Type the client name
        System.out.println("Sent keys NPHIES");

        // Press Enter to select the option
        drop.sendKeys(Keys.ENTER);

        System.out.println("Pressed Enter");

        // Wait for the option to become visible and clickable
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Select Project Owner'])[1]")));
        // Click the option once it's visible
        optionToSelect.click();
        System.out.println("Opened Project Owner");

        Thread.sleep(2000);
        WebElement drop1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Project Owner' and @class='multiselect__input' and @aria-controls='listbox-null']")));

        // Find the search field within the dropdown (assuming it's an input element)
        drop1.sendKeys("Awais Hamid"); // Type the client name
        System.out.println("Sent keys Awais Hamid");

        // Press Enter to select the option
        drop1.sendKeys(Keys.ENTER);

        System.out.println("Pressed Enter");

        driver.findElement(By.xpath("(//button[@class='btn btn-size'])[1]")).click();


    }

}
