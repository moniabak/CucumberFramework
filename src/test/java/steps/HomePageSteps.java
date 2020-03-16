package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.HomePage;

import java.io.IOException;

public class HomePageSteps {
    HomePage home;
    PageObjectManager pageObjectManager;

    public HomePageSteps(PageObjectManager pageObjectManager) throws IOException {
        this.pageObjectManager = pageObjectManager;
        home = this.pageObjectManager.getHomePage();
    }

    @Given("^user is on Home Page$")
    public void userIsOnHomePage() throws IOException {
        home.navigateToHomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchFor(String product) throws IOException {
        home.performSearch(product);
    }
}
