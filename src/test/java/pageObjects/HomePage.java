package pageObjects;

import dataProvider.Config;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HomePage {
    WebDriver driver;
    Config config;

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        config = ConfigFileReader.INST.getConfig();
    }

    public void performSearch(String search) {
        LOGGER.debug("Searching {}",search);
        driver.navigate().to(config.getUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateToHomePage() {
        LOGGER.debug("Go to the {}.", config.getUrl());
        driver.get(config.getUrl());
    }
}
