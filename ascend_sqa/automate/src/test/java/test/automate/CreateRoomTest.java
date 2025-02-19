package test.automate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.Base.BaseTest;

public class CreateRoomTest extends BaseTest{

    @Test
    public void testCreateRoom() throws InterruptedException {
        CreateRoomPage create_room = new CreateRoomPage(driver);
        // Add Selenium code here to test "Create Room" feature
        create_room.clickCreateRoom();
        create_room.Room_creation();
    }

//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(20000);
//        driver.quit();
//    }
}
