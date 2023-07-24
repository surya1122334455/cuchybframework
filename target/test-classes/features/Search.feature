Feature: Search Functionality

Scenario: User searches for valid Product
Given user opens the application
When user enters valid product "HP" in the search field
And user clicks on search button
Then user should get valid product displayed in the search results

Scenario: User searches for invalid Product
Given user opens the application
When user enters invalid product "Honda" in the search field
And user clicks on search button
Then user should get a message about no product matching

Scenario: User searches with entering any product
Given user opens the application
When user dont enter any product in the search
And user clicks on search button
Then user should get a message about no product matching