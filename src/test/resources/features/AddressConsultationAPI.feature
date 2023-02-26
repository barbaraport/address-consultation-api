Feature: Send a zip code to get the address from it

  Scenario: valid, without mask and existent zip code
    When the zip code "12280112" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "7.85"

  Scenario: valid, with mask and existent zip code
    When the zip code "12280-112" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "7.85"

  Scenario: invalid zip code
    When the zip code "1228A123" is sent
    Then an error is thrown
    And the message is "The zip code 1228A123 can not be invalid."

  Scenario: valid, with mask, but nonexistent zip code
    When the zip code "12345-678" is sent
    Then an error is thrown
    And the message is "The zip code 12345-678 does not exist"