package efx_717;

import WebDriver.webdriverSetup;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class loginTest {
    private static webdriverSetup setupClass;

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        // Initialize WebDriver once before all tests
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        setupClass.loadBaseUrl();
    }

    public static Stream<loginVO> setUpData() {
        // Read credentials from JSON file using Gson
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("jsons/Users/717_Users.json")) {
            // Deserialize into UsersWrapper or list directly
            loginVO wrapper = gson.fromJson(reader, loginVO.class);
            return wrapper.getUsers().stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("setUpData")
    public void testLoginAndLogout(loginVO objLoginVO) throws InterruptedException {
        System.out.println("Executing test with user: " + objLoginVO.getUsername());

        // Perform login
        loginPOM.username(objLoginVO.getUsername());
        loginPOM.password(objLoginVO.getPassword());
        Thread.sleep(3000); // Consider replacing with WebDriverWait
        loginPOM.submit();

        Thread.sleep(3000); // Consider replacing with WebDriverWait
        // Retrieve OTP from the user object
        String otp = objLoginVO.getOtp(); // Now we can get the OTP directly from objLoginVO
        loginPOM.OTP(otp); // Input OTP
        Thread.sleep(3000); // Wait for OTP input to complete (use WebDriverWait if possible)
        loginPOM.SubmitOTP(); // Submit OTP
        Thread.sleep(3000); // Wait for OTP input to complete (use WebDriverWait if possible)
//rida test 3 nov
    }


    @AfterAll
    public static void tearDown() {
        // Quit the driver after all tests
        System.out.println("AfterAll: Quitting WebDriver");
        if (setupClass != null) {
            setupClass.quitDriver();
        }
    }
}
