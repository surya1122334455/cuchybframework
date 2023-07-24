Feature: Registertion functionality

Scenario: User creates an account only with mandatory fields
Given user navigates to register account page
When user enters the details into the below fields
|firstName |Arun											|
|lastName  |Motoori										|
|telephone |1234567890								|
|password	 |12345							  			|
And user selects privacy policy
And clicks on continue button
Then user account shoud be created successfully

Scenario: User creates an account with all fields
Given user navigates to register account page
When user enters the details into the below fields
|firstName|Arun											  |
|lastName |Motoori										|
|telephone|1234567890									|
|password	|12345											|
And user selects Yes for Newsletter
And user selects privacy policy
And clicks on continue button
Then user account shoud be created successfully

Scenario: User creates with dupicate email/account
Given user navigates to register account page
When user enters the details into the below fields with duplicate email
|firstName |Arun											|
|lastName  |Motoori										|
|email		 |amotooricap9@gmail.com    |
|telephone |1234567890								|
|password	 |1234											|
And user selects Yes for Newsletter
And user selects privacy policy
And clicks on continue button
Then user should get a proper warning message about duplicate email

Scenario: User creates an account without filling any details
Given user navigates to register account page
When user dont enters any details into fields
And clicks on continue button
Then user should get a proper warning messages for every mandatory fields