@search
Feature: Search

  @chrome @this
  Scenario Outline: Search for a product
    Given I have a Selenium using "<browser>" search
    When I am at the homepage
    When I search for product "fish" and press ENTER
    Then I have the "fish" in the search results

    Examples: 
      | browser |
      | google  |

  @firefox
  Scenario Outline: Search for a product
    Given I have a Selenium using "<browser>" search
    When I am at the homepage
    When I search for product "fish" and press ENTER
    Then I have the "fish" in the search results

    Examples: 
      | browser |
      | firefox |
