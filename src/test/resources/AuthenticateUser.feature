@authenticate
Feature: Login into the website

	@chrome
  Scenario Outline: Login user with valid data
    Given I have a Selenium using "<browser>" authenticate
    When I enter the login page
    When I input valid login data
   	And I click on login
    Then I get redirected to homepage authenticate

      Examples: 
       | browser |
       | chrome  |
       
  @firefox
  Scenario Outline: Login user with valid data
    Given I have a Selenium using "<browser>" authenticate
    When I enter the login page 
    When I input valid login data
   	And I click on login
    Then I get redirected to homepage authenticate

      Examples: 
       | browser |
       | firefox |
       