@Regression @smoke
#This is how we add comments to feature files. Y
# You can add as many tags as you like. Whatever you put here on top of feature, it will execute all the scenarios

Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts and dashboard should be displayed.

  Background: For the scenarios in this feature file, user is expected to be on the login page.
    Given user is on the library login page

  @Librarian @login
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @Admin @db
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard

  @Student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard
