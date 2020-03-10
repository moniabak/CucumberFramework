package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.CartPage;

import java.sql.Time;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;


    public CartPageSteps(TestContext testContext) {
        this.testContext = testContext;
        cartPage = this.testContext.getPageObjectManager().getCartPage();
    }

    @And("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() {
        cartPage.clickOnCart();
        cartPage.clickOnCountinueToCheckout();
    }
}
