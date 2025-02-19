package efficonx_timesheets_extractor;

import WebDriver.webdriverSetup;
import com.google.gson.Gson;
import efficonx_login.efficonXLoginPOM;
import efficonx_login.efficonXLoginVO;
import efficonx_timesheets.timesheetsPOM;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class extractorTest {

    private static webdriverSetup setupClass;
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("Projects");
    private static int rowNum = 0;

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        setupClass.loadBaseUrl("https://efficonx.com/");
    }

    public static Stream<efficonXLoginVO> setUpData() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("jsons/Users/Users_reports.json")) {
            efficonXLoginVO wrapper = gson.fromJson(reader, efficonXLoginVO.class);
            return wrapper.getUsers().stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("setUpData")
    public void testLoginAndLogout(efficonXLoginVO obj_efficonXVO) throws InterruptedException {
        System.out.println("Executing test with user: " + obj_efficonXVO.getUsername());

        // Perform login
        efficonXLoginPOM.username(obj_efficonXVO.getUsername());
        efficonXLoginPOM.password(obj_efficonXVO.getPassword());
        Thread.sleep(3000);
        efficonXLoginPOM.submit();

        Thread.sleep(5000);
        timesheetsPOM.timesheetbtn();
        Thread.sleep(15000);
        timesheetsPOM.previousweek();
        Thread.sleep(3000);

        // Extract project names
        List<WebElement> rows = extractorPOM.getProjectRows();
        System.out.println("Projects for user: " + obj_efficonXVO.getUsername());

        for (WebElement row : rows) {
            String projectName = extractorPOM.getProjectName(row);
            System.out.println(projectName);

            // Write data to Excel
            Row excelRow = sheet.createRow(rowNum++);
            excelRow.createCell(0).setCellValue(obj_efficonXVO.getUsername());
            excelRow.createCell(1).setCellValue(projectName);
        }

        // Perform logout
        efficonXLoginPOM.options();
        efficonXLoginPOM.logout();
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDown() {
        try (FileOutputStream fileOut = new FileOutputStream("Projects.xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Excel file saved: Projects.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("AfterAll: Quitting WebDriver");
        if (setupClass != null) {
            setupClass.quitDriver();
        }
    }
}
