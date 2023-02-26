Feature: Send a zip code to get the address from it

  Scenario: valid and existent zip code
    When the zip code "12280112" is sent
    Then no errors are thrown
    And the address should be returned