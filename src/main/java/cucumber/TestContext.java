package cucumber;

import managers.WebDriverManager;

/**
 * Be wise to create this class logically. Just think what all information your Steps file are using and put that information in to this class. In our case our steps file is just using the below information:
 * <p>
 * PageObjects : Provided by PageObjectManager
 * WebDriver: Provided by WebDriverManager
 * Properties: Provided by FileReaderManager
 * FileReaderManager is already a Singleton Class and to use it we don’t need to create an instance of it.
 * It creates its instance by itself. So no need to add FileReaderManager to TestContext class, as this class can be referred directly statically
 * like FileReaderManager.getInstance()
 */
public class TestContext {
    private WebDriverManager webDriverManager;
    private ScenarioContext scenarioContext;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        scenarioContext = new ScenarioContext();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
