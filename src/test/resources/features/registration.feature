Feature:  Registration Feature
  Scenario: user wants to register
    When user enter below details
    | test1 | test1@mail.com | 9134 |
    | test2 | test2@mail.com | 9135 |
    Then user successfully registered

  Scenario: user wants to register with other data
    When user enter below  details in map
      | name    | email           | contact |
      | vishal  | vishal@mail.com | 9134    |
      | test    | test@mail.com   | 9135    |
    Then user successfully registered
