Feature: Login feature

  Background:
    Given User opens main page

  Scenario: Registered user can log in with valid credentials
    When User enters valid email and password
    Then User is logged in

  Scenario: User can't log in with not registered credentials
    When User enters not registered email and password
    Then [Incorrect email or password] notification is shown
    Then User is not logged in

  Scenario: User can't log in with invalid email
    When User enters invalid email and password
    Then [Incorrect email] notification is shown
    Then User is not logged in
