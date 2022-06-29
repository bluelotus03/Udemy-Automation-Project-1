@login @me
Feature: WebDriver University - Login Page

  Scenario: Validate Successful Login
    Given I access the WebDriver University login page
    When I enter the correct username of an existing account webdriver
    And I enter the correct password for that username webdriver123
    And I click the login button
    Then I should be presented with a successful login popup

  Scenario: Validate Unsuccessful Login - Incorrect Password
    Given I access the WebDriver University login page
    When I enter the correct username of an existing account webdriver
    And I enter an incorrect password for that username pass123
    And I click the login button
    Then I should be presented with a unsuccessful login popup

  Scenario: Validate Unsuccessful Login - Incorrect Username
    Given I access the WebDriver University login page
    When I enter a username that is misspelled webdrvr
    And I enter the correct password for that username webdriver123
    And I click the login button
    Then I should be presented with a unsuccessful login popup