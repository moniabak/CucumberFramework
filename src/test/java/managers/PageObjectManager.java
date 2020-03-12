package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.io.IOException;

public class PageObjectManager {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
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
