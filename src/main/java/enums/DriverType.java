package enums;

import org.openqa.selenium.WebDriver;

public enum DriverType {
    FIREFOX(){

    }, CHROME(){

    }, IE(){

    };

    DriverType() {
    }

    public WebDriver createWebDriver(){

    }
}
