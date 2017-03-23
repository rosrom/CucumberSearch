Feature: SearchFeature
  This feature test the search in google page for a couple of words

  Scenario: Search for a word
    Given I navigate to google page
    And I enter "potato" in field search
    And I click search button
    Then I should see the results page

