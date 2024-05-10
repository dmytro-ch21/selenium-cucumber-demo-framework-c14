@IBM-5546 @regression
Feature: Login Functionality
  This is the description for functionality that we will test

  Background: Preliminary steps
    Given user navigates to orangeHrm login page

  @validLogin @smoke
  Scenario: User can login with valid credentials
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    And user clicks login button
    Then user is redirected to the homepage
    * quit the driver

  # To make a Scenario data driven we call it in cucumber: Scenario Outline or Scenario Template
  # To extract a specific data from examples table will be by using <> - angle brackets
  @invalidLogin
  Scenario Outline: User cannot login with invalid credentials <testCase>
    When user logs in with username "<username>" and password "<password>"
    And user clicks login button
    Then user can see an error message "<errorMessage>"
    * quit the driver
    Examples:
      | username | password | errorMessage             | testCase       |
      | invalid  | invalid  | Invalid credentials      | both invalid   |
      |          | invalid  | Username cannot be empty | username empty |
      | invalid  |          | Password cannot be empty | password empty |
      |          |          | Username cannot be empty | both empty     |