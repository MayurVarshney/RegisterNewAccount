
@tag
Feature: Registration with new account to elearning application
  
Background: 

Given User opens URL in a browser to open Application 


  Scenario: Signup with new Email id 
    Given User clicks on SignUp Link
    Then User validates that Registration page should be opened
    Given User enters first Name as "Mayur"
    And User enters last Name as "Varshney"
    And User enters unique EmailId
    And User enters unique Username
    And User enters valid password and confirm Password
    And User enters Phone number as "9876543210"
    And User enter code
    And User clicks on Register button
    Then verify Registration should be completed Successfully
    When User Clicks on top right corner to open drop-down
    Then User Validates the email which is entered
    When User click on Inbox
    And user click on Compose Message Button
    And user enters email of recipient
    And user enters subject as "Hi For Testing"
    And User enters message body
    And user clicks on Send message button
    Then user verify the email acknowlegement 