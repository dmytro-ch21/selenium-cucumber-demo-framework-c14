package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PopUpPage;
import utilities.Driver;
import utilities.WaitsUtils;

import java.time.Duration;

public class PopUpsSteps {

    private PopUpPage popUpPage = new PopUpPage();

    @Given("user lands on Entry Ad Page")
    public void user_lands_on_entry_ad_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/entry_ad");
    }

    @When("a pop - up appears")
    public void a_pop_up_appears() {
        WaitsUtils.waitForVisibilityOfElement(popUpPage.modalTitle, 10);
        Assert.assertTrue("The modal is not visible!", popUpPage.modalTitle.isDisplayed());
    }

    @Then("user is able to see {string}")
    public void user_is_able_to_see_this_is_a_modal_window(String expectedModalTitle) {
        String actualModalTitle = popUpPage.modalTitle.getText();
        Assert.assertTrue("The modal title verification failed!", actualModalTitle.equalsIgnoreCase(expectedModalTitle));
    }

    @Then("user can close the pop up")
    public void user_can_close_the_pop_up() {
        popUpPage.closeButton.click();
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(popUpPage.modalTitle));
        Assert.assertTrue("The modal is still open!", isInvisible);
    }


}
