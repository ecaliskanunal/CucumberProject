Feature: User should be able to login using correct credentials

  Background:
    Given user is on the login page of the web table application


  Scenario: Positive login scenario
    When user enters username "username"
    And user enters password "password"
    And user clicks to login
    Then user should see url contains orders

  Scenario: Positive login scenario
    When user enters username "username" and password "password", and logins
    Then user should see url contains orders


  Scenario: User should be able to login with right credentials
    When user enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders

