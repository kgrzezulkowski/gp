Feature: Betting actions

  Scenario: Happy path desktop version
    Given The user is on betting page
    When Click on home button for "BFC Dynamo"
    Then BetSlipBox for "BFC Dynamo" should be displayed
    When Set "0.5" as bet input
      And Click Place Bet button
    Then Stacked price is "  0.50"
      And Odds are "14/1"

  Scenario: Happy path mobile version
    Given The mobile user is on betting page
    When Click on home button for "BFC Dynamo"
      And Click on MobileBetSlipIcon
      And Set "0.5" as bet input
      And Click Place Bet button
    Then Stacked price is "  0.50"
      And Odds are "14/1"