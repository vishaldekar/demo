Feature: testing allCustomers in graphql
  Scenario: user want to get list of customers
    When  user makes request to allCustomers
    Then  user receives 200 as response code
    Then  user receives list of customers in response
