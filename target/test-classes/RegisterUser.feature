@register
Feature: Register a new user in the website

  @chrome
  Scenario Outline: Register a new user with valid data
    Given I have a Selenium using "<browser>" register
    When I enter the register page
    When I input valid register data
    And I click on save account info
    Then I get redirected to homepage register

    Examples: 
      | browser |
      | chrome  |

  @firefox
  Scenario Outline: Register a new user with valid data
    Given I have a Selenium using "<browser>" register
    When I enter the register page
    When I input valid register data
    And I click on save account info
    Then I get redirected to homepage register

    Examples: 
      | browser |
      | firefox |
