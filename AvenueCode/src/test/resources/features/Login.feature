Feature: Login to the app



  @signIn @regression @all
  Scenario: Login with valid credentials
    Given user is on login page
    And user clicks on  sign in button
    When user enters username  and password as from properties file
    Then the user should be redirected to the Home Page

