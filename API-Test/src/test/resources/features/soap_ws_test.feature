# new feature
# Tags: optional

Feature: Test a SOAP Web Service using Cucumber

  Scenario Outline: Verify the capital of a list of countries using ISO code
    Given I connect to the SOAP endpoint
    When I fill a ISO Country code with <isoCode>
    Then I validate if the capital name <capital> is correct

    Examples:
      | isoCode | capital      |
      | CO      | Bogota       |
      | MX      | Mexico City  |
      | AR      | Buenos Aires |
