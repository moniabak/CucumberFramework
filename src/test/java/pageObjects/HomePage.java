package pageObjects;

import dataProvider.Config;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {
    WebDriver driver;
    Config config;

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        config = ConfigFileReader.INST.getConfig();
    }

    public void performSearch(String search) throws IOException {
        driver.navigate().to(config.getUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateToHomePage() throws IOException {
        driver.get(config.getUrl());
    }
}
