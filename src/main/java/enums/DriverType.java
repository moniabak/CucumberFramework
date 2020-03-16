package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum DriverType {
    FIREFOX("webdriver.gecko.driver") {
        @Override
        public WebDriver createWebDriver() {
            return new FirefoxDriver();
        }
    }, CHROME("webdriver.chrome.driver") {
        @Override
        public WebDriver createWebDriver() {
            return new ChromeDriver();
        }
    }, IE("webdriver.internetexplorer.driver") {
        @Override
        public WebDriver createWebDriver() {
            return new InternetExplorerDriver();
        }
    };

    private final String driverKey;

    DriverType(String driverKey) {
        this.driverKey = driverKey;
    }

    public abstract WebDriver createWebDriver();

    public String getKeyOfWebDriverForBrowser() {
        return driverKey;
    }
}
