Feature: To verify the functionalities on My Account Page

  Background:
  Given User has already logged in to application
    |email                      |password |
    |mahendi.customer1@grr.la   |India@123|



    Scenario: To validate the title on My account page
      Given User is on my account page
      When User gets the title of the page
      Then Page title should be "My Account"



    Scenario: To count the links in My Account section
      Given User is on my account page
      Then User gets my account section
      |[Edit Account|
      |Password|
      |Address Book|
      |Modify your wish list]|
      And My account section links count should be 4