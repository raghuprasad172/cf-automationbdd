Feature: Sourcing Agent Feature
  This feature is going to onboard the leads

  Background:
    Given : agent has already logged into application
      | username | password |
      | raghu.r.ty@cars24.com |Admin@6ty |

  Scenario: validate home page title
    Given agent is on login page
    When agent gets the title of home page
    Then page title should be "saarathi"`

  Scenario: validate agent is able to create lead with Used Cars as Product Type and D2C channel
    Given agent is on Contact Details page
    And agent enters "phoneNumber" in phone number textfield
    When agent selects "productType" as Product type
    And selects "channelType" as channel type
    And agent clicks on Request Consent button
    And agent enters OTP
    And agent clicks on Proceed button
    Then Basic Details should be in TODO
