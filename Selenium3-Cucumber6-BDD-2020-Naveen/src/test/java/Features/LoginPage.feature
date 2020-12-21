Feature: To test Login feature

  In order to perform the login functionality with valid and invalid scenario's
  As a customer
  I want to enter the email and password filed as per the condition

    Scenario: Navigate on the login page
    Given User is launching the browser and enter the URL "https://gocommerce.kmms.com.au"
    When User is clicks on the MyAccount dropdown
    And User is clicks on the Login link
    Then User should navigate on the login page
    And User gets the title of the page
    And Page title should be "Account Login"


    Scenario: Forgotten Password link is present on the login page
    Given User is on login page
    Then Forgotten Password link should be displayed


    Scenario: User can able to navigate on the Registration page after clicking on the continue button
    Given User is on login page
    When User is clicks on the continue button from the New customer section
    Then User should navigate on the Registration page
    And User gets the title of the page
    And Page title should be "Register Account"


    Scenario: User is able to login with valid email and valid password
    Given User is on login page
    When User enters valid email "mahendi.customer1@grr.la"
    And User enters valid password "India@123"
    And User is clicks on the login button
    Then User should be redirected on the Account page
    And User gets the title of the page
    And Page title should be "My Account"


    Scenario: Validation message is displayed while login when email is correct and password is incorrect
    Given User is on login page
    When User enters valid email "mahendi.customer1@grr.la"
    And User enters invalid password "India@1234567890"
    And User is clicks on the login button
    Then Validation message should displayed
    And User should remain on the login and title should be "Account Login"


    Scenario: Validation message is displayed while login when email is incorrect and password is correct
    Given User is on login page
    When User enters valid email "mahendi.customer12345@grr.la"
    And User enters invalid password "India@123"
    And User is clicks on the login button
    Then Validation message should displayed
    And User should remain on the login and title should be "Account Login"


    Scenario: Validation message is displayed while login when email is blank and password is also blank
    Given User is on login page
    When User enters valid email ""
    And User enters invalid password ""
    And User is clicks on the login button
    Then Validation message should displayed
    And User should remain on the login and title should be "Account Login"


