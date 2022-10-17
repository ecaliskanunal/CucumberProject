Feature: Web table order feature

  Scenario: User should be able to place order see in the web table
    Given user is on the order page
    When user selects product type "Familybea"
    And user enters quantity "2"
    And user enters name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects card "MasterCard"
    And user enters card number "111222333444"
    And user enters expiration date "12/23"
    And user clicks process order button
    Then user should see "Sherlock Holmes" in the first row of the web table

  @loginWithCre
   Scenario Outline: User should be able to place order in the web table
    Given user is on the order page
    When user selects product type "<productType>"
    And user enters quantity "<quantity>"
    And user enters name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zip>"
    And user selects card "<cardType>"
    And user enters card number "<cardNumber>"
    And user enters expiration date "<cardExp>"
    And user clicks process order button
    Then user should see "<expectedName>" in the first row of the web table

#    @femaleScientists
#    Examples: Famous female scientists
#      | productType | quantity | customerName     | street        | city   | state   | zip   | cardType         | cardNumber   | cardExp | expectedName     |
#      | MoneyCog    | 4        | Marie Curie      | London Street | London | England | 34567 | Visa             | 112233445566 | 12/27   | Marie Curie      |
#      | Screenable  | 5        | Rosalin Franklin | Oxford Street | Oxford | England | 23455 | MasterCard       | 112233445566 | 10/27   | Rosalin Franklin |
#      | Familybea   | 3        | List Meitner     | Camb Street   | Camb   | England | 33337 | American Express | 112233445566 | 12/23   | List Meitner     |

    @maleScientists
    Examples: Famous male scientists
      | productType | quantity | customerName | street        | city   | state   | zip   | cardType         | cardNumber   | cardExp | expectedName |
      | MoneyCog    | 4        | Einstein     | London Street | London | England | 34567 | Visa             | 112233445566 | 12/27   | Einstein     |
      | Screenable  | 5        | Newton       | Oxford Street | Oxford | England | 23455 | MasterCard       | 112233445566 | 10/27   | Newton       |
      | Familybea   | 3        | Galileo      | Camb Street   | Camb   | England | 33337 | American Express | 112233445566 | 12/23   | Galileo      |
