#Background: We can use cucumber to API level testing, that means test using real data responses without the need of a browser

Feature:
  As a user
  I want to be able to log in on WebApp
  So that i can browse on app


  Scenario: Log in on WebApp without user and password
    Given a user with no username and password
    When user hits login endpoint with null user and null password
    Then a public user should be returned to allow public navigation