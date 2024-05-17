@heroku_app
Feature: Practice Explicit Waits

  Scenario: Utilize explicit wait with a condition of visibility
    Given user is on heroku dynamic loading page
    When user clicks on example one link
    And user clicks on start button
    Then user can see a "Hello World!" message