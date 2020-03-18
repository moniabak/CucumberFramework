# Java + Selenium WebDriver + junit + Cucumber Framework
This is framework based od tutorial https://www.toolsqa.com/selenium-cucumber-framework/ but with some changes I have made.
This was created during the time I was learning Java.
There is used Page Object Pattern with Page Factory.
In this framework there is exampled test with page objects, steps, resources, freatures and so on.

## Framework

### Structure
The structure of the Framework is simple. 
```
configs
src/main/java
- cucumber
- dataProvider
- enums
- managers
src/test/java
src/test/resources
target
.gitignore
pom.xml
```

### Configuration
Driver location, home page for tests, location to json with data and so on can be set in the Configuration.properties file.
This configuration is taken to start browser and run tests. 
ConfigProperties enum, ConfigFileReader enum and Config class (with Builder class) are processing this configuration. 
These files are in the `src/main/java/dataProvider` folder.
DriverType enum `src/main/java/enums` delivers driver for browser from Configuration.properties.


### Context
In the framework there are two context classes, *ScenarioContext and TestContext*.

```text
ScenarioContext - sets and gets stored value.
TestContext - allows to get to ScenarioContext and WebDriverManager. It is used, for example, to get driver and use it in PageObjectManager.
WebDriverManager - allows to get driver, create driver for browser and environment.
```

WebDriverManager class is in the `src/main/java/managers`

## Test Part

### Page Object Manager
PageObjectManager is in the `src/test/java/managers` folder.
It contains every Page Object class from pageObjects folder. 
This allows to create only one instance of class. 

### Page Objects
Page Objects are in the `src/test/java/pageObjects` folder. 
In every page class there are locators to elements and methods.

```
BasePage - definitions of selenium operations with logger.
HomePage - inherits from BasePage class and gets configuration.
``` 

### Steps
Steps are in the `src/test/java/steps` folder. Every file has name with sufix Steps like `NameSteps.java`.
These files in the steps file there are exampled files. 
In every step file there is PageObjectManager object to get.  

```
Hooks - class just with @Before and @After.
```
### Features
Test cases, scenarios are in the folder `src/test/resources/features`.
Tests are written in Gherkin.  
There are files with extension `.feature`. 

```gherkin
Feature: ...
    Scenario: ...
        Given ... 
        When  ...
        Then  ...
``` 

### Data resources
Data for tests can be delivered as json file. Json files are in `src/test/resources/testDataResources`.
In the `src/test/resources/testDataTypes` there are declared types for every field in the json file.
To use data there is class JsonDataReader in the `src/test/java/dataProvider` which uses both Customer class from testDataTypes and Customer.json file to get and deliver data to the test.

### Run the test
To run the test there is TestRunner class in the `test/java/runners`.
After test ends there is generated report in the `target/cucumber-report` folder.
Report is generated as *json*, *xml* files and as *html* page.

## Reporting
To report tests results I used plugin pretty. There is configured json, html and xml report.
Reports are generating in `target/cucumber-reports`.
### Logging
To make logs I used logback which is based on slf4j. Configure files are in `src/test/resources/` and `src/main/resources/config/`.
Logs are going to `log` folder.   