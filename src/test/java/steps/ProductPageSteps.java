package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext testContext) {
        this.testContext = testContext;
        productListingPage = this.testContext.getPageObjectManager().getProductListingPage();
    }


    @And("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() {
        productListingPage.selectProduct(0);
        productListingPage.selectColor("White");
        productListingPage.selectSize("Medium");
        productListingPage.clickOnAddToCart();
    }
}
