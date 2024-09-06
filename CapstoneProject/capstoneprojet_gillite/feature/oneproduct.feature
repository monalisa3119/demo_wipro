Feature: Search on Gillette India homepage product pages

  Scenario: User searches for products
    Given I am on the Gillett India homepage products
    When I dragdowned the pages
    And I clicked on GilletteLabs Guard shaving Razor  products
    And I clicked on Buy Onlines
    Then I should see search results for razor check the with titles
  