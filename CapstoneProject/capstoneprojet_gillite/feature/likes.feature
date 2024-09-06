Feature: Search on Gillette India homepage product page liking

  Scenario: Test the user liking sysyem
    Given I am on the Gillette India homepage product
    When I dragdown the page
    And I liked any two products
    And I dragup the page
    And I clicked the likedbutton
    Then I validate the two products is here
  