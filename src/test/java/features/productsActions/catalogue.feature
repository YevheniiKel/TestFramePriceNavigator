Feature: Catalogue page sorting and filters

  Background:
    Given User opens main page
    When User opens subcategory "смартфоны"
    Then Catalogue page is displayed

  Scenario Outline: User can filter products by price in range from low to high
    When User applies filter by price in range from <low> to <high>
    Then Products with a price in range from <low> to <high> are shown
    Examples:
      | low   | high   |
      | 15    | 25     |
      | 30000 | 100000 |

  Scenario Outline: User can filter products to get products with price more than some value
    When User applies filter by price more than <low>
    Then Products with a price more than <low> are shown
    Examples:
      | low   |
      | 10000 |
      | 1000  |

  Scenario Outline: User can filter products to get products with price less than some value
    When User applies filter by price less than <high>
    Then Products with a price less than <high> are shown
    Examples:
      | high  |
      | 25    |
      | 25000 |

  Scenario Outline: User can filter products to get products with price more than some value
    When User applies filter by price less than <high>
    Then Products with a price less than <high> are shown
    Examples:
      | high  |
      | 25    |
      | 25000 |

  Scenario Outline: User can filter products by manufacture
    When User applies filter by manufacture: <manufacture>
    Then Products created by <manufacture> are shown
    Examples:
      | manufacture |
      | "Apple"     |
      | "Sony"      |

  Scenario Outline: User can filter products by year
    When User applies filer by year <year>
    Then Products from <year> are shown
    Examples:
      | year   |
      | "2021" |
      | "2018" |

