Feature: Homework Feature

  @tabs
  Scenario: User can see all tabs on home page
    Given user navigates to orangeHrm login page
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    And user clicks login button
    Then user is redirected to the homepage
    And user can see following tabs:
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |