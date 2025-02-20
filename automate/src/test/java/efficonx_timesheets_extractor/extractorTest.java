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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class extractorTest {

    private static webdriverSetup setupClass;
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("Projects");
    private static int rowNum = 0;

    private static Map<String, List<String>> timesheetData = new LinkedHashMap<>();
    private static Map<String, String> statusData = new LinkedHashMap<>();

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        setupClass.loadBaseUrl("https://efficonx.com/");
    }

    public static Stream<efficonXLoginVO> setUpData() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("jsons/Users/Users.json")) {
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

        efficonXLoginPOM.username(obj_efficonXVO.getUsername());
        efficonXLoginPOM.password(obj_efficonXVO.getPassword());
        Thread.sleep(3000);
        efficonXLoginPOM.submit();

        Thread.sleep(5000);
        timesheetsPOM.timesheetbtn();
        Thread.sleep(15000);
        timesheetsPOM.previousweek();
        Thread.sleep(3000);

        List<WebElement> rows = extractorPOM.getProjectRows();
        System.out.println("Projects for user: " + obj_efficonXVO.getUsername());

        List<String> projectList = new ArrayList<>();
        for (WebElement row : rows) {
            String projectName = extractorPOM.getProjectName(row);
            System.out.println(projectName);
            projectList.add(projectName);
        }

        String status = "Not Submitted";
        WebElement statusElement = extractorPOM.getStatusElement();
        if (statusElement != null) {
            status = statusElement.getText().trim();
        }

        timesheetData.put(obj_efficonXVO.getUsername(), projectList);
        statusData.put(obj_efficonXVO.getUsername(), status);

        efficonXLoginPOM.options();
        efficonXLoginPOM.logout();
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDown() {
        try (FileOutputStream fileOut = new FileOutputStream("Projects.xlsx")) {

            // Create header row
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Status");
            headerRow.createCell(2).setCellValue("Projects");

            // Create a cell style to enable text wrapping
            CellStyle wrapStyle = workbook.createCellStyle();
            wrapStyle.setWrapText(true);

            for (Map.Entry<String, List<String>> entry : timesheetData.entrySet()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(statusData.get(entry.getKey()));

                // Join all project names with new lines
                String projectsCombined = String.join("\n", entry.getValue());
                Cell projectCell = row.createCell(2);
                projectCell.setCellValue(projectsCombined);
                projectCell.setCellStyle(wrapStyle); // Apply wrap style
            }

            // Auto-size columns
            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

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
