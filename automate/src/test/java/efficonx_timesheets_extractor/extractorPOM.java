package efficonx_timesheets_extractor;

import WebDriver.webdriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static WebDriver.webdriverSetup.driver;

public class extractorPOM {

    // Locate the timesheet table body
    private static final By timesheetTable = By.xpath("//tbody[@class='responsive-table']");

    // Method to get project names dynamically
    public static List<WebElement> getProjectRows() {
        WebElement tableBody = driver.findElement(timesheetTable);
        return tableBody.findElements(By.tagName("tr"));
    }

    // Method to get project name from a row
    public static String getProjectName(WebElement row) {
        return row.findElement(By.xpath("./td[1]")).getText();
    }
}
