package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HerokuAppPage;
import utilities.Driver;

import java.time.Duration;

public class HerokuAppSteps {

    private final HerokuAppPage herokuAppPage = new HerokuAppPage();

    @Given("user is on heroku dynamic loading page")
    public void user_is_on_heroku_dynamic_loading_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
    }

    @When("user clicks on example one")
    public void userClicksOnExampleOne() {
        herokuAppPage.exampleOneLink.click();
    }

    @When("user clicks start button")
    public void user_clicks_start_button() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(herokuAppPage.startButton));
        herokuAppPage.startButton.click();
    }

    @Then("user can see a {string} message")
    public void user_can_see_a_message(String expectedMessage) {
        // These two lines will be same for any element so they should be moved to utilities
        Wait<WebDriver> explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOf(herokuAppPage.message));

        Assert.assertEquals("Message verification failed.", expectedMessage, herokuAppPage.message.getText());
    }

    @When("user clicks on example two")
    public void user_clicks_on_example_two() {
        herokuAppPage.exampleTwoLink.click();
    }
    @Then("user can see a message {string}")
    public void user_can_see_a_message_fluent(String expectedMessage) {
        Wait<WebDriver> fluentWait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .withMessage("The locator for element failed with polliung time of 250 mills and a 10 seconds max limit");

        fluentWait.until(ExpectedConditions.visibilityOf(herokuAppPage.message));

    }


}
