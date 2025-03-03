Feature: User can Login

  @wip
  Scenario Outline: Verify that user can not Login with <browser>
    Given user open the "<browser>" browser
    When user goes to Book Store Page Without Login
    And user clicks to loginSubmodule Button
    And  user enters invalid username
    And  user enters invalid password
    And user click login Button
    Then user should not land on Dashboard
    Examples:
      | browser |
      | Chrome  |
      | Firefox |
      | Safari  |
      | Edge    |