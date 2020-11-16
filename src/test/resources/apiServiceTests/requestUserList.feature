Feature:example to test rest API's

  Scenario: verify REST service GET method
    Given User executes getUsersList endPoint
    When User submits GET request
    Then Success status code to be 200

