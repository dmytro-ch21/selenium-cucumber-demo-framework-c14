Feature: Search Functionality

  @search
  Scenario Outline: User can search for a product
    Given user navigates to bestbuy
    When user enters "<productName>" in search box
    @smartphones
    Examples:
      | productName       |
      | iPhone Pro 15     |
      | Samsung Galaxy 24 |
      | Google Pixel 2024 |
    @laptops
    Examples:
      | productName      |
      | Mac Book Pro M3  |
      | Acer 2024 Laptop |
      | Hp 2024 Laptop   |
