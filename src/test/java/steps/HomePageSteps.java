package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.HomePage;

import java.io.IOException;

public class HomePageSteps {
    HomePage home;
    PageObjectManager pageObjectManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageSteps.class);

    public HomePageSteps(PageObjectManager pageObjectManager) throws IOException {
        this.pageObjectManager = pageObjectManager;
        home = this.pageObjectManager.getHomePage();
    }

    @Given("^user is on Home Page$")
    public void userIsOnHomePage() {
        LOGGER.info("Navigate to home page.");
        home.navigateToHomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchFor(String product) {
        home.performSearch(product);
    }
}
