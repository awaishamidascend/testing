package test.automate;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.Base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get("https://dev-taftesh.kakashi.app/admin/login");
        LoginPage loginPage = new LoginPage(driver);
        // Perform login
        loginPage.loginUsingConfig();

        // Assertions
        Assert.assertEquals(driver.getTitle(), "Tele-inspection");
    }

//    @Test
//    public void testInvalidLogin() {
//        driver.get("https://dev-taftesh.kakashi.app/admin/login");
//        LoginPage loginPage = new LoginPage(driver);
//
//        // Perform login with invalid credentials
//        loginPage.login("admin@gmail.com", "ascendAdmin@12");
//
//        // Assertions
//        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
//    }
}