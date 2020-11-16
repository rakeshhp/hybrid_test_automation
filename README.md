# Hybrid_test_automation
Test automation framework for UI functional and REST API testing using Java, Selenium, REST-Assured, Cucumber, enhanced with TestNG capabilities.

# Features

•	Adopts Cucumber framework to write and execute feature files in BDD style.<br>
•	Crisp and clear POM with Maven project structure.<br>
•	Supports both UI functional and API testing using Cucumber/TestNG and REST-Assured.<br>
•	Cucumber framework further enhanced and leverages TestNG feature capablities makes it more robust and maintainable.<br>
•	Provides Cucumber with parallel test execution support.<br>
•	Leverage TestNG.xml for real time parameterization(ex- specify which browser, environment, version to execute).<br>
•	suite execution along with grouping of tests via TestNG.xml makes it maintainable and easier for execution.<br>
•	Different TestNG annotations and assertions and listeners can now be adopted.<br>
•	Allows @DataProvider, particularly helpful to handle any out of the box scenarios like read/write flat files, xls, csv etc.


# Pre-requisites

•	JDK 1.8<br>
•	Apache Maven 3.6.3<br>
•	Chrome and ChromeDriver-v86 (aleady in lib folder for any other version of chrome corresponding compatable driver need to be replaced under lib folder.<br>
•	IDEA Intellij - IDE

# Run sample scripts

•	Clone this repo, open git bash and give command: git clone -b main https://github.com/rakeshhp/hybrid_test_automation.git <br> <br>
<b>To execute tests from Command Prompt-</b> <br>
 • Simply get into project folder(hybrid_test_automation) and give command: mvn clean test<br>
<b>To execute tests from IDE-</b><br>
 • perform maven clean and compile project<br>
 •	To execute from XML, Run below xml files directly<br>
 • <b>functional_testng.xml</b> :executes cucumber functional feature files under ‘functionalTests” directory<br>
 • <b>api_restassured.xml</b>: executes cucumber API feature files under “apiServiceTests” directory<br>
 • Alternatively maven surefire-plugin is also configured to run tests perform maven clean install (intellij IDE maven lifecycle)<br>

# Report 

•	For execution reports under target/cucumber-html-reports.<br>
•	Screenshots placed under project “screenshot” folder.<br>

<image height="400" src="https://github.com/rakeshhp/hybrid_test_automation/blob/main/screenshots/cucmber_report_functional.PNG" />
<br>

# TroubleShooting
• Make sure above mentioned pre-requisties are correctly installed and path configured.<br>
• Avoid downloading the project from git instead clone it to local from repo.<br>
