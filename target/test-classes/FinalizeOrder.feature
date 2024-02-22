@finalize
Feature: Finalize a Order

  @chrome
  Scenario Outline: Finalize a Order with an Item in the Cart
    Given I have a Selenium using "<browser>" finalize
    Given I have added a Product in the Cart
    Given I am at the Shopping Cart Page
    When I click Proceed to Checkout
    Then I should be on the Login Page

    Examples: 
      | browser |
      | chrome  |

  @firefox
  Scenario Outline: Finalize a Order with an Item in the Cart
    Given I have a Selenium using "<browser>" finalize
    Given I have added a Product in the Cart
    Given I am at the Shopping Cart Page
    When I click Proceed to Checkout
    Then I should be on the Login Page

    Examples: 
      | browser |
      | firefox |
