# Hybrid_Test_Automation
Test automation framework for UI functional and REST API testing using Java, Selenium, REST-Assured, Cucumber, enhanced with TestNG capabilities.

# Features

•	Adopts Cucumber framework to write and execute feature files in BDD style.<br>
•	Crisp and clear POM with Maven project structure.<br>
•	Supports both UI and API testing using REST-Assured.<br>
•	Cucumber framework further enhanced and leverages TestNG feature capablities makes it more robust and maintanable.<br>
•	Provides Cucumber with parallel test execution support.<br>
•	Leverage TestNG.xml for real time parameterization(ex- specify which browser, environment, version to execute).<br>
•	suite execution along with grouping of tests via TestNG.xml makes it maintanable and easier for execution.<br>
•	Different TestNG annotations and assertions and listeners can now be adopted.<br>
•	Allows @DataProvider, particularly helpful to handle any out of the box scenarios like read/write flat files, xls, csv etc.


# Pre-requisites

•	JDK 1.8<br>
•	Maven 3.6.3<br>
•	Chrome and ChromeDriver-v86 (aleady in lib folder for any other version of chrome corresponding comaptable driver need to be placed under lib folder.<br>
•	IDEA Intellij - IDE

# Run sample scripts

•	Clone this repo<br> 
•	Perform mvn clean and compile project<br>
•	To execute from XML<br>
•<b>functional_testng.xml</b> :executes cucumber feature files under ‘functionalTests” directory<br>
•<b>api_restassured.xml</b>: executes cucumber feature files under “apiServiceTests” directory<br>
•	Alternatively maven surefire-plugin is also cofigured to run tests do mvn clean test command or  perform mvn clean install (intellij IDE)
•	For execution reports under target/cucumber-html-reports.
•	Screenshots placed under project “screenshot” folder.
