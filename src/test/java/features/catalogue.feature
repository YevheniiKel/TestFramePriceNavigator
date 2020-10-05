Feature: Catalogue page sorting and filters

  Background:
    Given User opens main page
    When User opens subcategory "смартфоны"
    Then Catalogue page is displayed

  Scenario Outline: User can filter products by price in range from low to high
    When User filter products by price in range from <low> to <high>
    Then Only products with a price in range from <low> to <high> are shown
    Examples:
      | low   | high   |
      | 15    | 25     |
      | 1500  | 10000  |
      | 15000 | 25000  |
      | 30000 | 100000 |

  Scenario Outline: User can filter products to get products with price more than some value
    When User using filter to see the products with price more than <low>
    Then Only products with a price more than <low> are shown
    Examples:
      | low   |
      | 10000 |
      | 1000  |
      | 25000 |

  Scenario Outline: User can filter products to get products with price less than some value
    When User using filter to see the products with price less than <high>
    Then Only products with a price less than <high> are shown
    Examples:
      | high  |
      | 25    |
      | 25000 |
      | 6000  |

  Scenario Outline: User can filter products to get products with price more than some value
    When User using filter to see the products with price less than <high>
    Then Only products with a price less than <high> are shown
    Examples:
      | high  |
      | 25    |
      | 25000 |
      | 6000  |

  Scenario Outline: User can filter products by manufacture
    When User using filter to see the products that created by <manufacture>
    Then Products created by <manufacture> are shown
    Examples:
      | manufacture |
      | "Apple"     |
      | "Samsung"   |
      | "Sony"      |

  Scenario Outline: User can filter products by year
    When User using filter to see the products that created in <year>
    Then Products from <year> are shown
    Examples:
      | year   |
      | "2020" |
      | "2019" |
      | "2018" |

