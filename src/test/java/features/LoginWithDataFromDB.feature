@Dbfeature @Regression
Feature: Techfios billing login page functionality validation with data from DB

@DbScenario1 @Smoke
Scenario: User should be able to login with valid credential
  Given User is on the techfios login page
   When User enters "username" from mysql database
   When User enters "password" from mysql database
   When User clicks on signin button
   Then User should land on dashboard page