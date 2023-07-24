Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given user navigates to login page
When user enters valid email address <username> into email field
And user enters valid password <password> into password field
And user clicks on Login button
Then user should get successfully logged in
Examples:
|username							 |password|
|amotooricap1@gmail.com|12345|
|amotooricap2@gmail.com|12345|
|amotooricap3@gmail.com|12345|

Scenario: Login with invalid credentials
Given user navigates to login page
When user enters invalid email address into email field
And user enters invalid password "123467890" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given user navigates to login page
When user enters valid email address "amotooricap9@gmail.com" into email field
And user enters invalid password "123467890" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given user navigates to login page
When user enters invalid email address into email field
And user enters valid password "12345" into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given user navigates to login page
When user dont enters email address into email field
And user dont enters  password into password field
And user clicks on Login button
Then user should get a proper warning message about credentials mismatch
