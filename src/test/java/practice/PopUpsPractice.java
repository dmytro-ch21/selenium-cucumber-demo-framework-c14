package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpsPractice {

    /*
    Scenario: Verify user can see a modal pop up once landed on the page
    Given user lands on Entry Ad Page
    When a pop - up appears
    Then user is able to see "THIS IS A MODAL WINDOW"
    And user can close the pop up
    */


    @Test
    public void testModalPopUp() throws InterruptedException {
        String expectedTitle = "THIS IS A MODAL WINDOW";
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/entry_ad");
        WebElement modalTitle = driver.findElement(By.cssSelector("div.modal-title>h3"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modalTitle));
        String actualTitle = modalTitle.getText();
        System.out.println("Actual title: " + actualTitle);
        System.out.println("Expected title: " + expectedTitle);
        Assert.assertTrue("Modal title verification failed!", actualTitle.equalsIgnoreCase(expectedTitle));
        WebElement closeButton = driver.findElement(By.cssSelector("div.modal-footer>p"));
        closeButton.click();
        // Option 1
        // assert that title is not displayed.
        // boolean modalTitleIsDisplayed = modalTitle.isDisplayed();
        // Assert.assertFalse("Modal is still displayed.", modalTitleIsDisplayed);
        // Option 2
//        Wait<WebDriver> anotherWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        boolean isInvisible = anotherWait.until(ExpectedConditions.invisibilityOf(modalTitle));
//        Assert.assertTrue(isInvisible);
        driver.quit();
    }
   /*
    Scenario: Verify user can accept a simple alert
    Given user lands on https://the-internet.herokuapp.com/javascript_alerts
    When user clicks on Click for JS Alert
    And an alert appears
    Then user is able to accept the alert
    And user can see a message “You successfully clicked an alert”
    */
    @Test
    public void testBrowserAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJsAlertButton = driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']"));
        clickJsAlertButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        // How do we deal with alerts?
        // First we need to create an object of Alert type
        Alert alert = driver.switchTo().alert();
        System.out.println("alert description: "+alert.getText());
        Thread.sleep(2000);
        // Each alert can be different, simple alert, confirm, prompt
        // simple alerts have only OK button and description
        // confirm have Ok and Cancel buttons and description
        // prompt alert can have Ok, Cancel and an input box along with description
        // alert object has few methods:
        // accept() to click OK
        // dismiss() to click Cancel
        // getText() to get the description
        // sendKeys() to make an input
        alert.accept();
        Thread.sleep(2000);
        WebElement messageResult = driver.findElement(By.id("result"));
        System.out.println("messageResult: "+messageResult.getText());
        driver.quit();
        Thread.sleep(2000);
    }


    /*
    Scenario: Verify user can accept a confirm alert
    Given user lands on https://the-internet.herokuapp.com/javascript_alerts
    When user clicks on Click for JS Confirm
    And an alert appears
    Then user can see the alert message is “I am a JS Confirm”
    And user is able to decline the alert
    And user can see a message “You clicked: Cancel”
    */
    @Test
    public void testBrowserConfirmAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        WebElement jsConfirmButton = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']"));
        jsConfirmButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        Thread.sleep(2000);
        WebElement messageResult = driver.findElement(By.id("result"));
        System.out.println(messageResult.getText());
        jsConfirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        messageResult = driver.findElement(By.id("result"));
        System.out.println(messageResult.getText());
        Thread.sleep(2000);
        driver.quit();
    }



}
