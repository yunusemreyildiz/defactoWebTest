Feature: Basket Test

  Scenario: Add an item to your basket, go to basket and delete your item

    Given Navigate to website
    When Check home page is loaded
    And Get cursor to the Kadın category
    And Click Ceket option from hamburger menu
    When From left side on the page, choose Beden option as S on checkbox
    And S option items come, choose a random one and click
    And Item's details come, choose a random size
    And Click to Sepete Ekle button for add to basket
    And From right top corner, click on the Sepetim icon
    And In the Sepet Özet section, click on the Sepete Git button
    When Sepetim screen loaded
    And Delete the item with Sil button
    Then Check if the item has been deleted
