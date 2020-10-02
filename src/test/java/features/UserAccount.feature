Feature: Login features

  Background:
    Given User opens main page
    When User opens LogIn popup
#revert. It was bad idea. -> notification asserts are missed
  Scenario Outline: Registered user can log in with valid credentials
    When User enters <userType> credentials
    Then User is authorized is "<authorized>"
    Examples:
      | userType         | authorized |
      | registered       | true       |
      | notRegistered    | false      |
      | invalidInputData | false      |
#revert. It was bad idea. -> notification asserts are missed

  Scenario Outline: User can register with valid login and password
    And Clicks Register button
    When <userType> user fills all required fields
    And Clicks SignUp button
    Then User is authorized is "true"
    Examples:
      | userType      |
      | newUser |
