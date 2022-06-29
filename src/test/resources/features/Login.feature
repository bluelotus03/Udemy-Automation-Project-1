@login @me
Feature: WebDriver University - Login Page

  Background:
    Given I access the WebDriver University login page

#  Scenario: Validate Successful Login
#    When I enter a username webdriver
#    And I enter a password webdriver123
#    And I click the login button
#    Then I should be presented with a successful login popup
#
#  Scenario: Validate Unsuccessful Login - Incorrect Password
#    When I enter a username webdriver
#    And I enter a password pass123
#    And I click the login button
#    Then I should be presented with a unsuccessful login popup
#
#  Scenario: Validate Unsuccessful Login - Incorrect Username
#    When I enter a username webdrvr
#    And I enter a password webdriver123
#    And I click the login button
#    Then I should be presented with a unsuccessful login popup

  Scenario Outline: Validate Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click the login button
    Then I should be presented with a login validation popup <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | pass123      | validation failed      |
      | wbdrvr    | webdriver123 | validation failed      |