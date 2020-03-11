package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    public WebDriverManager() throws IOException {

//        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
//        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() throws IOException {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() throws IOException {
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

    private WebDriver createLocalDriver() throws IOException {
        switch (driverType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
        }
        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
