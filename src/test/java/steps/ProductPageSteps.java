package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import enums.Context;
import managers.PageObjectManager;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;
    PageObjectManager pageObjectManager;

    public ProductPageSteps(PageObjectManager pageObjectManager, TestContext testContext) {
        this.pageObjectManager = pageObjectManager;
        productListingPage = this.pageObjectManager.getProductListingPage();
        this.testContext = testContext;
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
