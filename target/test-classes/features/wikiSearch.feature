Feature: Wikipedia search functionality and verifications

  #WSF-US007 You can pass here the ticket number along with the Agile User Story
  Scenario: Wikipedia Search Functionality Title Verification
    Given user is on wiki home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks search button
    Then user sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Given user is on wiki home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks search button
    Then user sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on wiki home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks search button
    Then user sees "Steve Jobs" is in the wiki image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Image Header Verification
    Given user is on wiki home page
    When user types "<searchValue>" in the wiki search box
    And user clicks search button
    Then user sees "<expectedTitle>" is in the wiki image header
    Then user sees "<expectedMainHeader>" is in the wiki image header
    Examples: search values we are going to be using in this scenario is as below
      | searchValue | expectedTitle | expectedMainHeader |
      | Steve Jobs  | Steve Jobs    | Steve Jobs         |
      | Elon Musk   | Elon Musk     | ELon Musk          |
      | Lady Gaga   | Lady Gaga     | Lady Gaga          |