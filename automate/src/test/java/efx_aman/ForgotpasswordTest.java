package efx_aman;

import WebDriver.webdriverSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ForgotpasswordTest {

    private static webdriverSetup setupClass;

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        // Initialize WebDriver once before all tests
        System.out.println("BeforeAll: Initializing WebDriver");
        setupClass = webdriverSetup.getInstance();
        setupClass.webdriverSetup();
        setupClass.loadBaseUrl();
    }

    // Method source to provide user data from the JSON class
    public static Stream<AmanVO> setUpData() {
        return json.setUpData();  // Call the setUpData method from the Json class
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("setUpData")
    public void testForgotPassword(AmanVO user) throws InterruptedException {
        System.out.println("Executing forgot password flow for user: " + user.getUsername());

        // Forgot password flow
        AmanPOM.forgot();
        Thread.sleep(2000);
        AmanPOM.forgotemail(user.getUsername());
        Thread.sleep(2000);
        AmanPOM.forgotemailsendbutton();
        Thread.sleep(2000);
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
