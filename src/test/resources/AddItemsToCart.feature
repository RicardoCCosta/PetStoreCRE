@cart
Feature: Add to cart

  @chrome
  Scenario Outline: Add one item to cart
    Given I have a Selenium using "<browser>" add
    Given I am at the Categoty page for "<animal>"
    When I press on the first product
    When I press Add To Cart
    Then I should be on the shopping cart page
    Then There should be one item in the cart

    Examples: 
      | browser | animal |
      | chrome  | FISH  |
      | chrome  | DOGS   |

  @firefox
  Scenario Outline: Add one item to cart 
    Given I have a Selenium using "<browser>" add
    Given I am at the Categoty page for "<animal>"
    When I press on the first product
    When I press Add To Cart
    Then I should be on the shopping cart page
    Then There should be one item in the cart

    Examples: 
      | browser | animal   |
      | firefox | REPTILES |
      | firefox | BIRDS |
