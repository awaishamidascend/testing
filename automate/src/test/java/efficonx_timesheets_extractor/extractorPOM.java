package efficonx_timesheets_extractor;

import WebDriver.webdriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static WebDriver.webdriverSetup.driver;

public class extractorPOM {

    // Locate the timesheet table body
    private static final By timesheetTable = By.xpath("//tbody[@class='responsive-table']");

    // Locator for the status button (Waiting for Approval / Approved)
    private static final By statusButton = By.xpath("//p[contains(@class, 'status-btn')]");

    // Locator for the "Submit for Approval" button
    private static final By submitForApprovalButton = By.xpath("//button[contains(., 'SUBMIT FOR APPROVAL')]");

    // Method to get project names dynamically
    public static List<WebElement> getProjectRows() {
        WebElement tableBody = driver.findElement(timesheetTable);
        return tableBody.findElements(By.tagName("tr"));
    }

    // Method to get project name from a row
    public static String getProjectName(WebElement row) {
        return row.findElement(By.xpath("./td[1]")).getText();
    }

    // Method to get the status element for submitted timesheets
    public static WebElement getStatusElement() {
        try {
            return driver.findElement(statusButton);
        } catch (Exception e) {
            return null; // Return null if no status element is found
        }
    }

    // Method to check if "Submit for Approval" button exists
    public static boolean isSubmitForApprovalPresent() {
        try {
            driver.findElement(submitForApprovalButton);
            return true;
        } catch (Exception e) {
            return false; // Return false if button is not found
        }
    }
}
