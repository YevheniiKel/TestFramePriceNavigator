Feature: User can compare several products

  Scenario Outline: User can add three products to comparing
    Given User on the main page
    And User opens some category
    And User add "<amount>" products to comparing
    And Clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    Examples:
      | amount |
      | 3      |
      | 4      |

  Scenario Outline: User can delete product from the comparing list
    Given User on the main page
    And User opens some category
    And User add "<amount>" products to comparing
    And Clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    When One product has been deleted from the comparing
    Then Amount of comparing products should be equal "<amountMinusOne>"

    Examples:
      | amount | amountMinusOne |
      | 3      | 2              |
      | 4      | 3              |

  Scenario Outline: User can get link to current comparing page
    Given User on the main page
    And User opens some category
    And User add "<amount>" products to comparing
    And Clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    When Generate a Link button is clicked and popup with link appear
    And User put this link into address bar and press enter
    Then User is navigated on the same comparing page

    Examples:
      | amount |
      | 3      |
      | 4      |
