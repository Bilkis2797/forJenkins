Feature: Techfios billing login page functionality validation

Scenario: User should be able to login with valid credential
   Given User is on the techfios login page
   When User enters username as "demo@techfios.com"
   When User enters password as "abc123"
   When User clicks on signin button
   Then User should land on dashboard page
