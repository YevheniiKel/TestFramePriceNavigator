Feature: Login features

  Background:
    Given User opens main page
    When User opens LogIn popup

#  Scenario Outline: Registered user can log in with valid credentials
#    When User enters <userType> credentials
#    Then <userType> user is authorized
#    Examples:
#      | userType   |
#      | Registered |
#
#  Scenario Outline: User cannot log in with  not registered credentials
#    When User enters <userType> credentials
#    Then <userType> user is not authorized
#    And [Invalid credentials] notification is shown
#    Examples:
#      | userType      |
#      | NotRegistered |
#
#  Scenario Outline: Registered user can log in with valid credentials
#    When User enters <userType> credentials
#    Then <userType> user is not authorized
#    Then [Invalid email] notification is shown
#    And [Invalid credentials] notification is shown
#    Examples:
#      | userType         |
#      | InvalidInputData |
#
#  Scenario Outline: User can register with valid login and password
#    And Clicks Register button
#    When <userType> user fills all required fields
#    And Clicks SignUp button
#    Then User is authorized
#    Examples:
#      | userType |
#      | NewUser  |
