Feature: Search field in the header

  Scenario Outline: Test ProductNotFound Page
    When Open main page with header
    When Enter "<searchQuery>" into search field and press enter
    Then Product not found page is displayed
    Examples:
      | searchQuery       |
      | fjbhjgjsdkjfglsdf |

