#Background: We can use cucumber to API level testing, that means test using real data responses without the need of a browser

Feature:
  As a user
  I want to be able to logout on WebApp


  Scenario: Logout from WebApp
    Given a user already logged
    When user hits logout endpoint
    Then a public user should be returned to allow public navigation