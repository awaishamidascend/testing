package test.automate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.ParticipantEmailReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class CreateRoomPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CreateRoomPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set explicit wait
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div[3]/div/ul/li[2]/a/div[2]/p")
    WebElement create_room;

    @FindBy(id = "meetingTitle-id")
    WebElement meeting_title;

    @FindBy(id = "participant-id")
    WebElement participants;

    @FindBy(css = "svg.iconify.iconify--gala.mouse-pointer")
    WebElement plus_button;

    @FindBy(xpath = "//input[@type='email']")
    List<WebElement> emailfields;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[2]/main/form/div/div[2]/button")
    WebElement room_create;

    // Helper method to wait for an element
    private void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Method to click on "Create Room"
    public void clickCreateRoom() {
        waitForElement(create_room);
        create_room.click();
        System.out.println("Clicked on 'Create Room'.");
    }

    // Method to create a meeting room
    public void Room_creation() {
        // Step 1: Wait for and enter the meeting title
        waitForElement(meeting_title);
        String randomTitle = "Meeting_" + UUID.randomUUID().toString().substring(0, 8);
        meeting_title.sendKeys(randomTitle);
        System.out.println("Meeting title added successfully: " + randomTitle);

        // Step 2: Generate and enter participant count
        waitForElement(participants);
        int randomParticipants = new Random().nextInt(11) + 2;
        participants.sendKeys(String.valueOf(randomParticipants));
        participants.sendKeys(String.valueOf(randomParticipants));
        System.out.println("Participant count added: " + randomParticipants);

        // Step 3: Click the plus button (Wait and Click each time)
        for (int i = 1; i < randomParticipants; i++) { // Start from 1 because one field exists
            waitForElement(plus_button);
            plus_button.click();
            System.out.println("Added email field " + (i + 1));
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(emailfields));
        System.out.println("Total email fields found: " + emailfields.size());

        // Shuffle the email fields randomly
        Collections.shuffle(emailfields);

// Put emails in the first two fields from the shuffled list
        List<String> emails = ParticipantEmailReader.getEmails();

        // Step 1: Read emails from the file


        // Step 2: Shuffle and select 2 random emails
        Collections.shuffle(emails);
        int emailsToAdd = 2;

        // Step 3: Add emails to random fields
        for (int i = 0; i < emailfields.size() && i < emailsToAdd; i++) {
            emailfields.get(i).sendKeys(emails.get(i));
            System.out.println("Added email to field " + (i+1) + ": " + emails.get(i));
        }

        // Step 4: Click on "Create Room"
        scrollToElement(create_room);
        waitForElement(room_create);
        room_create.click();
        System.out.println("Room creation process completed.");
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
        System.out.println("Scrolled to element.");
    }
}
