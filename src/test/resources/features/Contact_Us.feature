Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the WebDriver University contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    Given I access the WebDriver University contact us page
    When I enter a specific first name Jane
    And I enter a specific last name Doe
    And I enter a specific email address jdoe32@mail.com
    And I enter a specific comment "How are you?"
    And I click the submit button
    Then I should be presented with a successful contact us submission message
