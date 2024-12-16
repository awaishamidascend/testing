package efx_users;

import WebDriver.webdriverSetup;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import efficonx_login.efficonXLoginPOM;
import efficonx_login.efficonXLoginVO;


import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class usersTest {

    private static webdriverSetup setupClass;

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        // Initialize WebDriver once before all tests
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        setupClass.loadBaseUrl();
    }

    public static Stream<efficonXLoginVO> setUpData() {

        // Read credentials from JSON file using Gson
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("jsons/Users/Users.json")) {
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

        // Wait for website to be load
        Thread.sleep(5000);

        usersPOM.timesheets();

        // Wait for timesheets to be load
        Thread.sleep(5000);

        usersPOM.previous();
        Thread.sleep(5000);

        // Perform logout
        efficonXLoginPOM.options();
        efficonXLoginPOM.logout();

    }
}