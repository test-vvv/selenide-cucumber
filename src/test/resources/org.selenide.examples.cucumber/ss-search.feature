Feature: ss.com functionality

  Scenario: user can search and add to favorites

    Given I open browser with ss.com home page
    And I switch language
    And I accept cookies

    When I click "electronics" main category link
    And I click "search" link from main panel
    Then I should see "search" page loaded

    When I enter "mobile" to search input field
    And I choose "riga_f" option for "city" filter
    And I click "Search" button
    Then I should see "Search results" page loaded
    And I should see ads from "Рига" only

    When I sort results by "Price"
    And I filter results by "deal type" with "Продажа" option

    When I click "Advanced search" link
    And I set price filter min "160" max "300"
    And I click "Search" button
    Then I should see "Search results" page loaded

    When I select 3 random ads
    And I add selected ads to favorites
    And I click "favorites" link from main panel
    Then I should see "favorites" page loaded
    And I should see the same ads