Feature: Arithmetic operations

  Scenario Outline: user wants to add two numbers
    When user gives two numbers <x> and <y>
    Then user expects <result> in response

    Examples:
      |x|y|result |
      |2|3|5      |
      |5|3|8      |
      |8|5|13     |



  @Regression
  Scenario: user wants to substract two numbers
    When user gives GET /calc/sub two numbers 5 and 3
    Then user expects result as 2 in response





