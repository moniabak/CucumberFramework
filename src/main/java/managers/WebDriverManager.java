package managers;

import dataProvider.Config;
import dataProvider.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private final Config config;
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    public WebDriverManager() {
        config = ConfigFileReader.INST.getConfig();
        driverType = config.getBrowser();
        environmentType = config.getEnv();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yest implemented");
    }

    private WebDriver createLocalDriver() {
        if (driverType == DriverType.CHROME) {
            System.setProperty(CHROME_DRIVER_PROPERTY, config.getDriverPath());
        }
        driver = driverType.createWebDriver();
        if (config.isWindowsMaximize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
