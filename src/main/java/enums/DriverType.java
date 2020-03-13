package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum DriverType {
    FIREFOX(){
        @Override
        public WebDriver createWebDriver() {
            return new FirefoxDriver();
        }
    }, CHROME(){
        @Override
        public WebDriver createWebDriver() {
            return new ChromeDriver();
        }
    }, IE(){
        @Override
        public WebDriver createWebDriver() {
            return new InternetExplorerDriver();
        }
    };

    public abstract WebDriver createWebDriver();
}
