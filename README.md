# LambdaTest-Selenium-Certification

This repository contains a sample Selenium Java test automation project using the TestNG framework, designed to run tests on the LambdaTest platform.

## Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- LambdaTest account (username and access key)

## Getting Started

Clone this repository to your local machine:

```bash
git clone https://github.com/your-username/LambdaTest-Selenium-Certification.git

Navigate to the project directory:
cd selenium-java-lambdatest
Update the src/test/resources/config.properties file with your LambdaTest credentials:
properties

lambdatest.username=your-username
lambdatest.accessKey=your-access-key
Create test classes under the src/test/java directory using the TestNG framework.

Run tests using Maven:

mvn test
Project Structure : src/test/java: Contains your TestNG test classes.
src/test/resources: Contains configuration files and test data.
pom.xml: Maven configuration file.

LambdaTest Integration
This project is set up to run tests on the LambdaTest platform. Make sure you've provided your LambdaTest credentials in the config.properties file.

Customization
Feel free to customize and expand the project according to your needs. You can add more test cases, implement page object pattern, integrate with other tools, etc.

Reporting
TestNG generates test reports by default. You can find them in the target/surefire-reports directory.
