package efficonx_timesheets;

import WebDriver.webdriverSetup;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import efficonx_login.efficonXLoginPOM;
import efficonx_login.efficonXLoginVO;

import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class timesheetsTest {

    private static webdriverSetup setupClass;

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        // Initialize WebDriver once before all tests
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        // For this specific test, load the custom URL
        setupClass.loadBaseUrl("https://efficonx.com/");
    }


    public static Stream<efficonXLoginVO> setUpData() {

        // Read credentials from JSON file using Gson
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("jsons/Users/efficonx_all_users.json")) {
            // Deserialize into UsersWrapper
            efficonXLoginVO wrapper = gson.fromJson(reader, efficonXLoginVO.class);
            // Return the stream of users
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

        // Wait for a while
        Thread.sleep(5000);

        timesheetsPOM.timesheetbtn(); //Current Week
        Thread.sleep(15000);
        /*
        timesheetsPOM.previousweek(); //One week before
        Thread.sleep(3000);
        timesheetsPOM.previousweek(); //Two week before
        Thread.sleep(3000);
        timesheetsPOM.previousweek(); //Three week before
        Thread.sleep(3000);
        timesheetsPOM.previousweek(); //Four week before
        Thread.sleep(3000);*/

        // Perform logout
        efficonXLoginPOM.options();
        efficonXLoginPOM.logout();

        // Wait before finishing the test
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver after each test
        System.out.println("AfterEach: Quitting WebDriver");
        if (setupClass != null) {
            setupClass.quitDriver();
        }
    }
}

