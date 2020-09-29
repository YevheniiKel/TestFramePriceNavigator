Feature: Login feature

  Scenario: User can be logged in with valid credentials
    When User opens main page with header1
    When User enters valid email and password
    Then User is logged in
