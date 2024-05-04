# 📝 Selenium-Cucumber-Demo-Framework Documentation

---

| Tool     | Intention                            |      Version       |                         Docs                          |
|:---------|:-------------------------------------|:------------------:|:-----------------------------------------------------:|
| Java     | Programming Language                 | JDK - 20 or higher |  [JDK20](https://docs.oracle.com/en/java/javase/20/)  |
| Maven    | Build Tool and Dependency Management |  3.9.5 or higher   | [Maven 3](https://maven.apache.org/guides/index.html) |
| Selenium | UI Test Automation                   |  4.15.0 or higher  | [Selenium 4](https://www.selenium.dev/documentation/) |
| JUnit    | Test Framework                       |  4.13.2 or higher  |         [JUnit 4](https://junit.org/junit4/)          |
| Cucumber | BDD Framework                        | 7.15.0  or higher  |   [Cucumber 7](https://cucumber.io/docs/cucumber/)    |

---

## 🛠 Framework Creation

1. **Create a new project with:**
    - Java as programming language 🌐
    - Maven as build tool 🛠
    - Git for source version control 🔄
    - 

2. **Add necessary dependencies** 📦
    - Selenium, JUnit 4, Cucumber - Java, Cucumber - JUnit

3. **Create folder structure** 📁
    - pages, step_definitions, utilities, runner, resources.features
    - ```text
         test
         ├── java
         │   ├── pages
         │   ├── runner
         │   ├── step_definitions
         │   └── utilities
         └── resources
            └── features
      ```

4. **Start by creating your first Cucumber file** 🥒
    - feature-name.feature
    - make sure the file extension is `.feature`

5. **Add necessary plugins** 🔄
    - Cucumber for Java
    - Ensure Gherkin is installed

6. **Running your first feature:** 🏃
    - I. Create a StepDefinition class containing Java methods that define each step from the feature file
      ```java
      package step_definitions;
      public class LoginSteps(){
          // Example of a Step Definition in Java
          @Given("user is on the login page")
          public void userIsOnLoginPage() {
             // code to navigate to login page
          }
      }
      ```
    - II. Create a TestRunner class connecting feature file steps with Java methods from step definitions
        - TestRunner uses JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
            - Customize binding and framework execution with @CucumberOptions():
                - `feature = "path/to/features"`: provides the path to features of the framework
                - `glue = "step definitions location"`: connects the step definitions with feature files steps
                - `dryRun = true/false` options:
                    - If set to true, it checks if all steps in the feature file are defined but doesn't run test cases
                    - If set to false, it runs the test cases and throws an error if steps aren't defined
                - `tags = "@smoke"` options: we can specify what tag to run with this property
                  - We can run a specific tag only: `tags = "@smoke"`
                  - We can run multiple tags: `tags = "@smoke or @regression"`
                  - We can run scenarios with combination of tags: `tags = "@smoke and @login"`
                  - We can skip tags: `tags = "@smoke and not @ignore"`
                    ```java
                    @RunWith(Cucumber.class)
                    @CucumberOptions(
                      features = "src/test/resources/features",
                      glue = "step_definitions",
                      dryRun = false,
                      tags = ("@runValid and @smoke")
                    )
                    public class TestRunner {
                    // no need to add code here
                    }
                    ```
7. **Cucumber Keywords definitions in feature files** 🗝️
    - **`Feature`:** _Short description of the feature to be tested_
        - Examples:
          ```gherkin
          #Example 1: 
          Feature: User Login Functionality
          #Example 2:
          Feature: Reset Password Functionality
          ```  
    - **`Background`** _Will run the steps of background before each Scenario_
        - Examples:
          ```gherkin
          #Example 1:
          Background: Preliminary Steps
             Given user navigates to hrm login page
           ```
    - **`Scenario`:** _Brief use case description from a user perspective_
        - Examples:
            ```gherkin
          #Example 1: 
          Scenario: Login with valid credentials
          #Example 2:
          Scenario: Login with invalid credentials
          ```
    - **Given, When, Then, And, But, \* Keywords:**
        - **`Given`** - _Preconditions or starting points_
            - Examples:
              ```gherkin
              #Example 1:
              Given user navigates to login page
              #Example 2:
              Given admin user lands on the home page
              ```
        - **`When`** - _Main actions performed_
            - Examples:
              ```gherkin
              #Example 1:
              When user enters username and password
              #Example 2:
              When user clicks on admin tab
              ```
        - **`Then`** - _Outcome or result of actions, usually at this step you need to perform an assertion_
            - Examples:
              ```gherkin
              #Example 1:
              Then user is redirected to the homepage
              #Example 2:
              Then user can see an error message
              ```
        - **`And`** - _Connects multiple steps within Given, When, or Then_
            - _Used to add more detail or steps without repeating the Given, When, or Then keywords_
            - Examples:
              ```gherkin
              #Example: notice how And keyword connects any steps on Given, When, Then
              Scenario: Login with valid credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                And user receives a welcome message
              ```
        - **`But`** - _Describes an exception or a contrasting scenario_
            - Example:
              ```gherkin
              #Example: notice how But keyword provides a logical output when the credentials 
              # are about to expire you still can login but a message will be shown
              Scenario: Login with expiring credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                But user can see a warning message to change credentials
              ```
        - **`*`** - _Asterisks:_
            - _The asterisk * is a more generic step keyword that can be used in place of any of the other keywords (
              Given, When, Then, And, But)._
            - _It is often used when the specific type of step (setup, action, or assertion) is either clear from
              context
              or not important to the clarity of the scenario._
            - _The use of * doesn't imply a technical or undefined behavior; it's more about flexibility in writing
              the scenario._
              ```gherkin
                  # Example using steps with keywords:
                      Given user is logged in
                      And user has items in my cart
                      When user navigates to the checkout page
                      Then user should see the total price
                  # Example using steps with asterisks:
                      * user is logged in
                      * user has items in my cart
                      * user navigates to the checkout page
                      * user should see the total price
              ```

8. > ### More information about Gherkin syntax can be found here:
   > [Cucumber - Gherkin Syntax](https://cucumber.io/docs/gherkin/reference/)

---


### Framework Definition
- Framework - In IT world it used extensively 
- A framework referees to a set of pre-written code, tools, and guidelines that help us when dealing with a ""problem""

> Analogy: Building a bookshelf
- Build by yourself from scratch:
  - Buy wood, screws
  - Make measurements 
  - Painting 
  - Putting all together 
- Go to IKEA and get a flatbox of the bookshelf
  - You get all the materials, tools ready assemble
  - You also get a guideline how to build it up 

> Framework reality:
- We can use no framework and that would require us to build all the details from scratch
- On the other hand, we can use a framework that gives us something to work with 
  - Also, it will give us guidelines. 
    - Selenium - gives guidelines and pre-written code for automation
    - JUnit - gives guidelines how to create and run test cases
    - Cucumber - gives us guidelines how to write proper Scenarios



#### ATDD - acceptance driven development 

##### 1. **User Story**: "As a user, I want to reset my password so that I can access my account if I forget my password."
   **Acceptance Criteria**:
    - The user should be able to request a password reset from the login page.
    - The system should send a password reset link to the user's registered email address.
    - The password reset link should expire after 24 hours.
    - The user must be able to set a new password using the reset link.

#### BDD - behavior driven development (compliments the ATDD)
- What bdd suggests is that you describe the AC from the perspective of user

##### 1. **User Story**: "As a user, I want to reset my password so that I can access my account if I forget my password."

BDD Acceptance Criteria (Scenarios):

- Scenario: Requesting a password reset
    - Given user is on the login page
    - When user clicks on "Forgot Password"
    - Then user should be prompted to enter my registered email address
  
- Scenario: Receiving a password reset email
    - Given user had requested a password reset
    - When user enters registered email address
    - Then user should receive a password reset email within 5 minutes
  
- Scenario: Resetting the password using the link
    - Given user has received a password reset email
    - When user clicks on the reset link in the email
    - And users enters a new password
    - Then user password should be updated, and user should be redirected to the login page


### Tags in cucumber 
- We add a new property to TestRunner CucumberOptions called tags
- It will have a value as a string 
- If we include a specific tag like tags = "@smoke" it will run all the scenarios tagged with smoke tag
- Sometimes we want to run a scenario that has two tags at the same time, we can do it with and operator
  - tags = "@smoke and @login"
- Sometimes we want to run scenarios that have any of the tags provided, this can be archived with or operator
  - tags = "@validLogin or @invalidLogin"
- You also can disable or ignore certain scenarios 
  - We can do that with "and not" operator
  - tags = "@regression and not @brokenScenario"


#### Background Keyword
We use Background to run a step or steps before each Scenario
























