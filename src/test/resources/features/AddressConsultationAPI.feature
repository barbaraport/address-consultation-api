Feature: Send a zip code to get the address from it

  Scenario: valid, without mask and existent zip code from south east
    When the zip code "12280112" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "7.85"

  Scenario: valid, with mask and existent zip code from south east
    When the zip code "12280-112" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "7.85"

  Scenario: valid, without mask and existent zip code from south
    When the zip code "88806000" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "17.30"

  Scenario: valid, with mask and existent zip code from mid west
    When the zip code "78050-542" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "12.50"

  Scenario: valid, with mask and existent zip code from mid west
    When the zip code "78050-542" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "12.50"

  Scenario: valid, without mask and existent zip code from north east
    When the zip code "62598000" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "15.98"

  Scenario: valid, with mask and existent zip code from north
    When the zip code "69010-070" is sent
    Then no errors are thrown
    And the address should be returned
    And the fare should be "20.83"

  Scenario: invalid zip code (missing one character)
    When the zip code "12280-11" is sent
    Then an error is thrown
    And the message is "The zip code 12280-11 can not be invalid."

  Scenario: invalid zip code (wrong mask)
    When the zip code "122801-12" is sent
    Then an error is thrown
    And the message is "The zip code 122801-12 can not be invalid."

  Scenario: invalid zip code (alphanumeric)
    When the zip code "1228A123" is sent
    Then an error is thrown
    And the message is "The zip code 1228A123 can not be invalid."

  Scenario: valid, with mask, but nonexistent zip code
    When the zip code "12345-678" is sent
    Then an error is thrown
    And the message is "The zip code 12345-678 does not exist"

  Scenario: valid, without mask, but nonexistent zip code
    When the zip code "88888888" is sent
    Then an error is thrown
    And the message is "The zip code 88888888 does not exist"