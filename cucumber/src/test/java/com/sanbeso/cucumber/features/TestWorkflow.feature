Feature:
  As a user
  I want to be able to perform searches using google
  So that i can get results about what i was looking for


  Scenario: Perform a search
    Given the user is on Google landing page
    When user types Unosquare as search term into search input box
    And user clicks on search button
    Then user should get results related to search term