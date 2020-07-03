#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: This featuere will implement search feature in My Store site.
  As a user I want to

  #Scenario: Search for multiple items in search box and verify results
  Scenario Outline: Search for multiple items <searchText> in search box and verify results
    Given MyStore Page is visible
    And "SearchBox" is visible
    When I enter <searchText> in "SearchBox"
    And click on SearchButton
    Then I should see a <searchText> text

    Examples: 
      | searchText |
      | shoe       |
      | shirt      |
