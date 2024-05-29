package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PIMPage;
import utilities.Driver;
import utilities.DriverFactory;

import java.util.List;

public class HomePageSteps {

    //private WebDriver driver = DriverFactory.getDriver("chrome");
    private HomePage homePage = new HomePage();
    private PIMPage pimPage = new PIMPage();


    @Then("user can see following tabs:")
    public void user_can_see_following_tabs(List<String> expectedTabs) {

        // first we need to make sure that there is a specific number of tabs
        List<WebElement> actualTabs = homePage.tabs;
        Assert.assertEquals(
                "Tabs verification failed due to the length of lists.",
                expectedTabs.size(),
                actualTabs.size()
        );

        // make sure that each tab has a specific name
        for(int i = 0; i < expectedTabs.size(); i++){
            String expectedTab = expectedTabs.get(i);
            String actualTab = actualTabs.get(i).getText();
            Assert.assertEquals(
                    "Tab name verification failed.",
                    expectedTab,
                    actualTab
            );
        }
    }

    @When("user clicks on PIM tab with js executor")
    public void user_clicks_on_pim_tab_with_js_executor() throws InterruptedException {
        // Regular way of clicking on tab
        // homePage.pimTab.click();

        // When we want to use java script executor we will need to create an object of it
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        // document.getElementById('locator').click
        jsExecutor.executeScript("arguments[0].click()",homePage.pimTab); // [homePage.pimTab, homePage.adminTab]
        Thread.sleep(5000);
    }

    @Then("url ends with {string}")
    public void url_ends_with(String expectedEndpoint) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(expectedEndpoint));
    }

    @Then("user scrolls to the last employee on table")
    public void userScrollsToTheLastEmployeeOnTable() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView()", pimPage.lastEmployee);
        Thread.sleep(5000);
    }
}
