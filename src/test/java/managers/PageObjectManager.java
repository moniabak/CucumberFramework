package managers;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.io.IOException;

public class PageObjectManager {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private HomePage homePage;
    private BasePage basePage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(TestContext testContext) throws IOException {
        this.driver = testContext.getWebDriverManager().getDriver();
    }

    public BasePage getBasePage() {
        return (basePage == null) ? basePage = new BasePage(driver) : basePage;
    }

    public HomePage getHomePage() throws IOException {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductListingPage getProductListingPage() {
        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }

    public ConfirmationPage getConfirmationPage() {
        return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;
    }
}
