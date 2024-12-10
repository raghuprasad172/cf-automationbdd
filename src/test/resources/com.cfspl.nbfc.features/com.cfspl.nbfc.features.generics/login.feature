Feature: Login page feature   This features is going to make Agent login successfully

  Scenario: validate login page title
    Given agent is on login page
    When agent gets the title of login page
    Then page title should be "Saarathi"

  Scenario: validate sign in with Google button is displayed
    Given agent is on login page
    When agent gets sign in with Google button is displayed or not
    Then sign in with Google button should be displayed

  Scenario: validate agent is able to login with valid credentials
    Given agent is on login page
    And agent clicks on sign in with google button
    When agent enters username "validUserName" into username textfield
    And agent enters password "validPassword" into password texfield
    And agent clicks on login button
    Then agent should gets the title of home page
    And the home page title should be "Saarathi"


