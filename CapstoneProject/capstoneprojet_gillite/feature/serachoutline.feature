Feature: Search on Gillette India homepage

  Scenario Outline: User searches for a product
    Given I am on the Gillette India homepages opendd
    When I clicked search Bar
    And I enter "<data>" into the searchbar
    And I click the product
    Then I should see search results for  check with tittle

    Examples: 
      | data   |
      | blades |
      | razor  |
