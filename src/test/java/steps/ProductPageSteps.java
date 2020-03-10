package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import enums.Context;
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
        String productName = productListingPage.getProductName(0);
        testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
        productListingPage.selectProduct(0);
        productListingPage.selectColor("White");
        productListingPage.selectSize("Medium");
        productListingPage.clickOnAddToCart();
    }
}
