package test.automate;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dental_Supplies_Form_NotAvailable {

	public static void main(String[] args) throws InterruptedException {


		// Initialize Extent Reports
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("rida_report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("Equipment Form", "This is efficaX Dental Test case");

		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();


		// Open the webpage
		test.pass("Web page opened");
		driver.get("https://dev-efficax-dental.kakashi.app/");

		// Wait for 5 seconds to allow the page to load fully
		System.out.println("Waiting for the page to load...");
		Thread.sleep(5000);

		// Maximize the browser window
		System.out.println("Maximizing the browser window...");
		driver.manage().window().maximize();
		test.pass("Maximizing window");

		// Entering email and password
		System.out.println("Entering email and password...");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rida.khan@ascend.com.sa");
		test.pass("Entered email");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("eod777");
		test.pass("Entered password");

		// Clicking on login button
		System.out.println("Clicking on the login button...");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		test.pass("Clicked login");
		Thread.sleep(5000);

		// Clicking on Dental supplies dropdown
		System.out.println("Clicking on the Dental supplies dropdown...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]")).click();
		Thread.sleep(2000);

		// Clicking on dental Supplies Form
		System.out.println("Clicking on the dental Supplies Form...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/ul/div[2]/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Clicking on Region Dropdown dropdown
		System.out.println("Clicking on the Region dropdown...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]/div")).click();
		Thread.sleep(2000);

		// Selecting region
		System.out.println("Selecting region...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[1]")).click();
		Thread.sleep(2000);

		// Selecting PHCs dropdown
		System.out.println("Selecting PHC dropdown...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div")).click();
		Thread.sleep(2000);

		// Selecting PHCs value
		System.out.println("Selecting PHC...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/div[3]")).click();
		Thread.sleep(2000);

		// Selecting level dropdown
		System.out.println("Clicking Level dropdown...");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div[4]/div[1]/div/div[2]/div")).click();
		Thread.sleep(2000);

		// Selecting level
		System.out.println("Selecting level...");
		WebElement optionToSelect111 = driver.findElement(By.xpath("//div[contains(text(), 'PHC Warehouse - Dental Service')]"));
		optionToSelect111.click();
		System.out.println("Level Selected...");
		Thread.sleep(2000);

		// reset form
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait
		WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Reset'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reset);
		driver.findElement(By.xpath("(//button[normalize-space()='Reset'])[1]")).click();
		System.out.println("Reset Form Clicked");
		Thread.sleep(2000);

		// reset form click
		System.out.println("click okay to reset");
		driver.findElement(By.xpath("(//button[normalize-space()='Okay'])[1]")).click();
		Thread.sleep(2000);

		// Loop through each row and perform the required actions
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait

		// Nested loop for dropdown selection
		for (int j = 0; j <= 55; j++) {

			WebElement rowXPath = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("row-" + j)));
			System.out.println(rowXPath);

			// Scroll to the row (if necessary)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowXPath);
			Thread.sleep(500);

			int dropdownId = 6 + (j * 2); // Adjusting ID increment
			WebElement dropdownInput = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-" + dropdownId + "-input")));
			dropdownInput.sendKeys("Not Available");
			dropdownInput.sendKeys(Keys.ENTER);
			System.out.println("Selected 'Available' for dropdown with ID: react-select-" + dropdownId + "-input");

			// Check and interact with "MAWARED request number" field
			WebElement mawaredField = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row-" + j + "']//div[@id='cell-4-undefined']//input[@name='amountLeft']")));
			mawaredField.clear();
			mawaredField.sendKeys("100");
			System.out.println("Entered text '100' in 'MAWARED request number' text field for row: " + j);

			Thread.sleep(500);

			WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row-" + j + "']//div[@id='cell-5-undefined']//input[@name='amountLeft']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			Thread.sleep(1000);

			// Click to open the calendar widget
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			// Now locate the desired date element in the calendar popup and click it
			WebElement dateElement = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);


			System.out.println("Date Entered " + j + "time");

			// Check and interact with "New Stock Received" field using name attribute
			WebElement newStockReceivedDiv = driver.findElement(By.id("cell-6-undefined"));
			WebElement newStockReceivedField = newStockReceivedDiv.findElement(By.xpath("//div[@id='row-" + j + "']//div[@id='cell-6-undefined']//input[@name='amountLeft']"));
			newStockReceivedField.clear();
			newStockReceivedField.sendKeys("200");
			System.out.println("Entered text '200' in 'New Stock Received' text field for row: " + j);

			// Check and interact with "Stock on hand" field using name attribute
			WebElement stockOnHandDiv = driver.findElement(By.id("cell-8-undefined"));
			WebElement stockOnHandField = stockOnHandDiv.findElement(By.xpath("//div[@id='row-" + j + "']//div[@id='cell-8-undefined']//input[@name='amountLeft']"));
			stockOnHandField.clear();
			stockOnHandField.sendKeys("300");
			System.out.println("Entered text '300' in 'Stock On Hand' text field for row: " + j);


		}

		Thread.sleep(500);  // Wait to ensure action is completed before moving to next

		//next tab Endodontic Treatment
		WebElement Endo = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Endodontic Treatment'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Endo);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Endo);
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait
		System.out.println("Clicked on Second module");


		// Nested loop for dropdown selection
		for (int i = 0; i <= 75; i++) {

			WebElement rowXPath2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("row-" + i)));
			System.out.println(rowXPath2);

			// Scroll to the row (if necessary)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowXPath2);
			Thread.sleep(500);

			int dropdownId2 = 6 + (i * 2); // Adjusting ID increment
			WebElement dropdownInput2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-" + dropdownId2 + "-input")));
			dropdownInput2.sendKeys("Not Available");
			dropdownInput2.sendKeys(Keys.ENTER);
			System.out.println("Selected 'Available' for dropdown with ID: react-select-" + dropdownId2 + "-input");

			// Check and interact with "MAWARED request number" field
			WebElement mawaredField2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row-" + i + "']//div[@id='cell-4-undefined']//input[@name='amountLeft']")));
			mawaredField2.clear();
			mawaredField2.sendKeys("100");
			System.out.println("Entered text '100' in 'MAWARED request number' text field for row: " + i);

			Thread.sleep(500);

			WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row-" + i + "']//div[@id='cell-5-undefined']//input[@name='amountLeft']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

			Thread.sleep(500);

			// Click to open the calendar widget
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

			// Now locate the desired date element in the calendar popup and click it
			WebElement dateElement2 = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement2);


			System.out.println("Date Entered " + i + "time");

			// Check and interact with "New Stock Received" field using name attribute
			WebElement newStockReceivedDiv2 = driver.findElement(By.id("cell-6-undefined"));
			WebElement newStockReceivedField2 = newStockReceivedDiv2.findElement(By.xpath("//div[@id='row-" + i + "']//div[@id='cell-6-undefined']//input[@name='amountLeft']"));
			newStockReceivedField2.clear();
			newStockReceivedField2.sendKeys("200");
			System.out.println("Entered text '200' in 'New Stock Received' text field for row: " + i);

			// Check and interact with "Stock on hand" field using name attribute
			WebElement stockOnHandDiv2 = driver.findElement(By.id("cell-8-undefined"));
			WebElement stockOnHandField2 = stockOnHandDiv2.findElement(By.xpath("//div[@id='row-" + i + "']//div[@id='cell-8-undefined']//input[@name='amountLeft']"));
			stockOnHandField2.clear();
			stockOnHandField2.sendKeys("300");
			System.out.println("Entered text '300' in 'Stock On Hand' text field for row: " + i);

		}

		Thread.sleep(500);  // Wait to ensure action is completed before moving to next


		//next tab Preventive And Restorative
		WebElement Preventive = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Preventive And Restorative'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Preventive);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Preventive);
		WebDriverWait Wait3 = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait
		System.out.println("Clicked on fourth module");
		// Nested loop for dropdown selection
		for (int k = 0; k <= 37; k++) {

			WebElement rowXPath3 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("row-" + k)));
			System.out.println(rowXPath3);

			// Scroll to the row (if necessary)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowXPath3);
			Thread.sleep(500);

			int dropdownId2 = 6 + (k * 2); // Adjusting ID increment
			WebElement dropdownInput3 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-" + dropdownId2 + "-input")));
			dropdownInput3.sendKeys("Not Available");
			dropdownInput3.sendKeys(Keys.ENTER);
			System.out.println("Selected 'Available' for dropdown with ID: react-select-" + dropdownId2 + "-input");

			// Check and interact with "MAWARED request number" field
			WebElement mawaredField3 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row-" + k + "']//div[@id='cell-4-undefined']//input[@name='amountLeft']")));
			mawaredField3.clear();
			mawaredField3.sendKeys("100");
			System.out.println("Entered text '100' in 'MAWARED request number' text field for row: " + k);

			Thread.sleep(500);

			WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row-" + k + "']//div[@id='cell-5-undefined']//input[@name='amountLeft']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

			Thread.sleep(500);

			// Click to open the calendar widget
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

			// Now locate the desired date element in the calendar popup and click it
			WebElement dateElement3 = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement3);


			System.out.println("Date Entered " + k + "time");

			// Check and interact with "New Stock Received" field using name attribute
			WebElement newStockReceivedDiv3 = driver.findElement(By.id("cell-6-undefined"));
			WebElement newStockReceivedField3 = newStockReceivedDiv3.findElement(By.xpath("//div[@id='row-" + k + "']//div[@id='cell-6-undefined']//input[@name='amountLeft']"));
			newStockReceivedField3.clear();
			newStockReceivedField3.sendKeys("200");
			System.out.println("Entered text '200' in 'New Stock Received' text field for row: " + k);

			// Check and interact with "Stock on hand" field using name attribute
			WebElement stockOnHandDiv3 = driver.findElement(By.id("cell-8-undefined"));
			WebElement stockOnHandField3 = stockOnHandDiv3.findElement(By.xpath("//div[@id='row-" + k + "']//div[@id='cell-8-undefined']//input[@name='amountLeft']"));
			stockOnHandField3.clear();
			stockOnHandField3.sendKeys("300");
			System.out.println("Entered text '300' in 'Stock On Hand' text field for row: " + k);

		}
		Thread.sleep(500);  // Wait to ensure action is completed before moving to next

		//next tab Preventive And Restorative Endodontic Treatment
		WebElement PreventiveEndodontic = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Preventive And Restorative Endodontic Treatment'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PreventiveEndodontic);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", PreventiveEndodontic);
		WebDriverWait Wait4 = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait
		System.out.println("Clicked on fourth module");
		// Nested loop for dropdown selection
		for (int r = 0; r <= 5; r++) {

			WebElement rowXPath4 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("row-" + r)));
			System.out.println(rowXPath4);

			// Scroll to the row (if necessary)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowXPath4);
			Thread.sleep(500);

			int dropdownId4 = 6 + (r * 2); // Adjusting ID increment
			WebElement dropdownInput4 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-" + dropdownId4 + "-input")));
			dropdownInput4.sendKeys("Not Available");
			dropdownInput4.sendKeys(Keys.ENTER);
			System.out.println("Selected 'Available' for dropdown with ID: react-select-" + dropdownId4 + "-input");

			// Check and interact with "MAWARED request number" field
			WebElement mawaredField4 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row-" + r + "']//div[@id='cell-4-undefined']//input[@name='amountLeft']")));
			mawaredField4.clear();
			mawaredField4.sendKeys("100");
			System.out.println("Entered text '100' in 'MAWARED request number' text field for row: " + r);

			Thread.sleep(500);

			WebElement element4 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row-" + r + "']//div[@id='cell-5-undefined']//input[@name='amountLeft']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);

			Thread.sleep(500);

			// Click to open the calendar widget
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);

			// Now locate the desired date element in the calendar popup and click it
			WebElement dateElement4 = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement4);


			System.out.println("Date Entered " + r + "time");

			// Check and interact with "New Stock Received" field using name attribute
			WebElement newStockReceivedDiv4 = driver.findElement(By.id("cell-6-undefined"));
			WebElement newStockReceivedField4 = newStockReceivedDiv4.findElement(By.xpath("//div[@id='row-" + r + "']//div[@id='cell-6-undefined']//input[@name='amountLeft']"));
			newStockReceivedField4.clear();
			newStockReceivedField4.sendKeys("200");
			System.out.println("Entered text '200' in 'New Stock Received' text field for row: " + r);

			// Check and interact with "Stock on hand" field using name attribute
			WebElement stockOnHandDiv4 = driver.findElement(By.id("cell-8-undefined"));
			WebElement stockOnHandField4 = stockOnHandDiv4.findElement(By.xpath("//div[@id='row-" + r + "']//div[@id='cell-8-undefined']//input[@name='amountLeft']"));
			stockOnHandField4.clear();
			stockOnHandField4.sendKeys("300");
			System.out.println("Entered text '300' in 'Stock On Hand' text field for row: " + r);


		}
		Thread.sleep(500);  // Wait to ensure action is completed before moving to next


		//next tab Preventive And Restorative Endodontic Treatment Oral surgery
		WebElement PreventiveEndoOral = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Preventive And Restorative Endodontic Treatment Or')])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PreventiveEndoOral);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", PreventiveEndoOral);
		WebDriverWait Wait5 = new WebDriverWait(driver, Duration.ofSeconds(2)); // Explicit wait
		System.out.println("Clicked on fourth module");
		// Nested loop for dropdown selection
		for (int m = 0; m <= 0; m++) {

			WebElement rowXPath5 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("row-" + m)));
			System.out.println(rowXPath5);

			// Scroll to the row (if necessary)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rowXPath5);
			Thread.sleep(500);

			int dropdownId5 = 6 + (m * 2); // Adjusting ID increment
			WebElement dropdownInput5 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-" + dropdownId5 + "-input")));
			dropdownInput5.sendKeys("Not Available");
			dropdownInput5.sendKeys(Keys.ENTER);
			System.out.println("Selected 'Available' for dropdown with ID: react-select-" + dropdownId5 + "-input");

			// Check and interact with "MAWARED request number" field
			WebElement mawaredField5 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row-" + m + "']//div[@id='cell-4-undefined']//input[@name='amountLeft']")));
			mawaredField5.clear();
			mawaredField5.sendKeys("100");
			System.out.println("Entered text '100' in 'MAWARED request number' text field for row: " + m);

			Thread.sleep(500);

			WebElement element5 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='row-" + m + "']//div[@id='cell-5-undefined']//input[@name='amountLeft']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);

			Thread.sleep(500);

			// Click to open the calendar widget
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);

			// Now locate the desired date element in the calendar popup and click it
			WebElement dateElement5 = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement5);


			System.out.println("Date Entered " + m + "time");

			// Check and interact with "New Stock Received" field using name attribute
			WebElement newStockReceivedDiv5 = driver.findElement(By.id("cell-6-undefined"));
			WebElement newStockReceivedField5 = newStockReceivedDiv5.findElement(By.xpath("//div[@id='row-" + m + "']//div[@id='cell-6-undefined']//input[@name='amountLeft']"));
			newStockReceivedField5.clear();
			newStockReceivedField5.sendKeys("200");
			System.out.println("Entered text '200' in 'New Stock Received' text field for row: " + m);

			// Check and interact with "Stock on hand" field using name attribute
			WebElement stockOnHandDiv5 = driver.findElement(By.id("cell-8-undefined"));
			WebElement stockOnHandField5 = stockOnHandDiv5.findElement(By.xpath("//div[@id='row-" + m + "']//div[@id='cell-8-undefined']//input[@name='amountLeft']"));
			stockOnHandField5.clear();
			stockOnHandField5.sendKeys("300");
			System.out.println("Entered text '300' in 'Stock On Hand' text field for row: " + m);
		}
		
		// Clicking on submit
				
				driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
				System.out.println("Form submitted");
				Thread.sleep(2000);

	}






	private static void selectDate(WebDriver driver, LocalDate date) {
		// TODO Auto-generated method stub

	}

}
