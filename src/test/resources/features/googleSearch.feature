Feature: Google search functionality
  Agile Story> As a user, I should be able to search whatever we want

  Scenario: Search page title verification
    When  user is on the Google search page
    Then user should see the title is Google


#  Scenario: Search functionality result title
#    Given user is on the Google search page
#    When user types apple and clicks enter
#    Then user sees apple in the title


  Scenario: Search functionality result title
    Given user is on the Google search page
    When user types "<apple>" and clicks enter
    Then user sees "<apple>" in the title
