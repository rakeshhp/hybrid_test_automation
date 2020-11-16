Feature: User is able to launch web and perform search on google engine.

 Scenario: perform a keyword search on Google
 Given User is on Google search engine page
 When User enters search text as "Cucumber"
 And press the key enter to search
 Then google result page title should be "Cucumber - Google Search"



