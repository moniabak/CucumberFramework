Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  @smoke
  Scenario Outline: Customer place an order by purchasing an item from search
    Given user is on Home Page
     When he search for "dress"
      And choose to buy the first item
      And moves to checkout from mini cart
      And enter "<customer>" personal details on checkout page
      And place the order
     Then verify the order details
    Examples:
      | customer |
      | Lakshay  |
      | Virender |