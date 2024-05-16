@heroku_app
Feature: Practice explicit waits

  Scenario: Utilize explicit wait with condition of visibility
    Given user is on heroku dynamic loading page
    When user clicks on example one
    When user clicks start button
    Then user can see a "Hello World!" message


  Scenario: Utilize fluent wait
    Given user is on heroku dynamic loading page
    When user clicks on example two
    When user clicks start button
    Then user can see a message "Hello World!"
