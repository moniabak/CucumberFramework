package pageObjects;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String search) throws IOException {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateToHomePage() throws IOException {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
