Feature: Welcome Page

  @WelcomePage
  Scenario: As a user I should see the welcome page on opening the app and fill the necessary details
    Given user is on welcome page
    And user enters the id in the box
    Then user clicks the "submit" button
    And user selects "prod" environment
    And user enables the "leprechaun" toggle
    And user checks the Custom broker config is false
    Then user clicks the "setup" button
    And user clicks the "ok" button
    Then user clicks the "SST" button
    And user clicks the "searchBar" button
    And user enters "idea" search term in search bar
    Then user selects the "IDEA" text from suggestions
    And user clicks the "quantity" button
    When user enters 2 quantity
    And user clicks the "add" button
    When user clicks the "placeOrder" button
    Then user should see the webview bottomsheet
    When user clicks the more button on webview
    And user clicks the motilal oswal broker
    And user switches chrome webview context
    When user enters leprechaunId in chromw webview
    And user clicks the "login" button
    And user clicks the "review" button
    And user clicks the "placeOrders" button
    And user clicks the "confirmOrder" button
    Then user should see the transaction success popup




