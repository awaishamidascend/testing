package test.Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Get the WebDriver instance from WebDriverManager
        driver = WebDriverManager.getDriver();
    }

//   @AfterClass
//    public void tearDown() {
//        // Quit the WebDriver instance
//        WebDriverManager.quitDriver();
//    }
}