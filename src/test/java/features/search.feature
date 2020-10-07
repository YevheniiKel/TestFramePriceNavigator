Feature: Search field in the header

  Scenario Outline: Test ProductNotFound Page
    When User opens main page
    When User searches for "<searchQuery>"
    Then Product not found page is displayed
    Examples:
      | searchQuery       |
      | fjbhjgjsdkjfglsdf |

