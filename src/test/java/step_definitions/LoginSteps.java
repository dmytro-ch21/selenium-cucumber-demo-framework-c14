package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class LoginSteps {

    @Given("user navigates to orangeHrm login page")
    public void user_navigates_to_orange_hrm_login_page() {
        System.out.println("Navigation step");
    }

    @When("user logs in with valid username and password")
    public void user_logs_in_with_valid_username_and_password() {
        System.out.println("Login step");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        System.out.println("Click login step");
    }

    @Then("user is redirected to the homepage")
    public void user_is_redirected_to_the_homepage() {
        System.out.println("Redirect step");
    }

}
