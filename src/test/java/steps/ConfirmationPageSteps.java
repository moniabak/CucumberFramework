package steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import managers.PageObjectManager;
import org.junit.Assert;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
    TestContext testContext;
    ConfirmationPage confirmationPage;
    PageObjectManager pageObjectManager;

    public ConfirmationPageSteps(PageObjectManager pageObjectManager, TestContext testContext) {
        this.pageObjectManager = pageObjectManager;
        confirmationPage = this.pageObjectManager.getConfirmationPage();
        this.testContext = testContext;
    }

    @Then("^verify the order details$")
    public void verifyTheOrderDetails() {
        String productName = (String) testContext.getScenarioContext().getContext(Context.PRODUCT_NAME);
        Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.toUpperCase().contains(productName)).findFirst().isPresent());
    }
}
