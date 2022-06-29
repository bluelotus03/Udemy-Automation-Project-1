@login @me
Feature: WebDriver University - Login Page

  Scenario: Validate Successful Login
    Given I access the WebDriver University login page
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click the login button
    Then I should be presented with a successful login popup

  Scenario: Validate Unsuccessful Login - Incorrect Password
    Given I access the WebDriver University login page
    When I enter a username webdriver
    And I enter a password pass123
    And I click the login button
    Then I should be presented with a unsuccessful login popup

  Scenario: Validate Unsuccessful Login - Incorrect Username
    Given I access the WebDriver University login page
    When I enter a username webdrvr
    And I enter a password webdriver123
    And I click the login button
    Then I should be presented with a unsuccessful login popup