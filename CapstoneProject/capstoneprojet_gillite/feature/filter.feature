Feature: Search on Gillette India homepage and filter

  Scenario: User searches for a product using the filters
    Given I am on the Gillette India homepage
    When I dragdown the page visbile filter
    When I clicked filter
    When I clicked razor type
    And I select the Manula selector
    When I clicked By brands
    And I select Guard
    When I click Apply filters
    And I click got it
    Then I should see search results

