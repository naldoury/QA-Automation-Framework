
  Feature: Login feature

    Scenario: Login Success
      Given I Open Login Page
      When I enter email "demo@class.com"
      And I enter password "te$t$tudent"
      And I submit
      Then I am logged in