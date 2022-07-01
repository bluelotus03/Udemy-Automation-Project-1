@login @me
Feature: WebDriver University - Login Page

  Background:
    Given I access the WebDriver University login page

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