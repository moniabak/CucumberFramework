package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.CartPage;

public class CartPageSteps {
    CartPage cartPage;
    PageObjectManager pageObjectManager;

    public CartPageSteps(PageObjectManager pageObjectManager) {
        this.pageObjectManager = pageObjectManager;
        cartPage = this.pageObjectManager.getCartPage();
    }

    @And("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() {
        cartPage.clickOnCart();
        cartPage.clickOnCountinueToCheckout();
    }
}
