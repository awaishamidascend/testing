package test.automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateRoomPage {
    WebDriver driver;

    // Constructor
    public CreateRoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div[3]/div/ul/li[2]/a/div[2]/p")
    WebElement create_room;

    @FindBy(id = "meetingTitle-id")
    WebElement meeting_title;

    @FindBy(id = "participant-id")
    WebElement participants;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/main/form/div/div[2]/button")
    WebElement room_create;


    private void waitForElementToBeVisible(WebElement... elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10-second wait
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    // Methods
    public void clickCreateRoom() {
        waitForElementToBeVisible(create_room);
        create_room.click();

    }
    public void Room_creation(String title, String participant) {
        waitForElementToBeVisible(meeting_title, participants, room_create);

        meeting_title.sendKeys(title);
        participants.sendKeys(participant);
        participants.sendKeys(participant);
        room_create.click();
    }

}
