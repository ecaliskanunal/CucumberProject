Feature: Examples of Cucumber data table implementations

  Scenario: List of fruits I like
    Then user should see fruits I like
      | melon       |
      | strawberry  |
      | banana      |
      | pomegranate |

      #to beautify the pipes Ctrl Alt L

  Scenario: User should be able to see months
    Given user is on the dropdowns page
    Then user should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |

    #these months will be automatically passed into the method in DataTableStepDefinitions