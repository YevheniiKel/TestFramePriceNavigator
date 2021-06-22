Feature: User can compare several products

  Background:
    Given User opens main page
    And User opens some subcategory

  Scenario Outline: User can add three products to comparing
    When User adds <amount> products to comparing
    And User clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    Examples:
      | amount |
      | 3      |
      | 4      |

  Scenario Outline: User can delete product from the comparing list
    When User adds <amount> products to comparing
    And User clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    When One product has been deleted from the comparing
    Then Amount of comparing products should be equal "<amountMinusOne>"

    Examples:
      | amount | amountMinusOne |
      | 3      | 2              |
      | 4      | 3              |

  Scenario Outline: User can get link to current comparing page
    When User adds <amount> products to comparing
    And User clicks Compare button
    Then Amount of comparing products should be equal "<amount>"
    When Generate a Link button is clicked and popup with link appear
    And User follows with generated link
    Then User is navigated to the same comparing page

    Examples:
      | amount |
      | 3      |
      | 4      |
