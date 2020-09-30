Feature: Catalogue page sorting and filters

  Scenario: User can see catalogue with products after choosing some subcategory on the main page
    Given User opens main page
    When User opens some subcategory
    Then Catalogue is displayed
