package steps;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.TestLogHelper;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    /**
     * We have not started our driver in the @Before method, because we have been doing the same in the TestContext class constructor.
     * Because our PageObjectModel needs the driver at the early stage.
     * Rest of the project does not have nay change. So in case you need the code for the whole project,
     * please visit previous chapters of Selenium Cucumber Framework Series.
     */
    @Before
    public void BeforeSteps() {
        /*What all you can perform here
         Starting a webdriver
         Setting up DB connections
         Setting up test data
         Setting up browser cookies
         Navigating to certain page
         or anything before the test*/
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }
}
