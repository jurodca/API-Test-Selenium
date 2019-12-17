Feature: Login into GitHub Account
      Existing github user should be able to login into account using correct credentials

  Scenario: Login into GitHub account with correct credentials
    Given I navigate to GitHub website
    And   I click on the Sign in link on homepage
    And   I enter a valid username
    And   I enter a valid password
    When  I click on the Sign in button
    Then  I should be taken to the successful user page

