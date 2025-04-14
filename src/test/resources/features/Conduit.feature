Feature: Conduit Web Page

    Given User is on login page
    When User enters "TestUser@gmail.com" and "Test@123"
    Then User should be on Home Page

  Scenario: Add New Article
    Given User should be on Home Page
    When User add new article
    Then Article must be added

  Scenario: Edit Article
    Given User should be on Article Page
    When User edit the article
    Then Article must be edited

    Given User should be on Article Page
    When User delete the article
    Then Article must be deleted
