package steps;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

import java.io.IOException;

public class HomePageSteps {
    HomePage home;
    TestContext testContext;

    public HomePageSteps(TestContext testContext) throws IOException {
        this.testContext = testContext;
        home = this.testContext.getPageObjectManager().getHomePage();
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
