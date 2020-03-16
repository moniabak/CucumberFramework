package steps;

import cucumber.api.java.en.And;
import dataProvider.JsonDataReader;
import managers.PageObjectManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;

    public CheckoutPageSteps(PageObjectManager pageObjectManager) {
        this.pageObjectManager = pageObjectManager;
        checkoutPage = this.pageObjectManager.getCheckoutPage();
    }

    @And("^enter \"([^\"]*)\" personal details on checkout page$")
    public void enterCustomerNamePersonalDetailsOnCheckoutPage(String customerName) {
        Customer customer = new JsonDataReader().getCustomerByName(customerName);
        checkoutPage.fillPersonalDetails(customer);
    }

    @And("^place the order$")
    public void placeTheOrder() throws InterruptedException {
        checkoutPage.checkTermAndCondition(true);
        checkoutPage.clickOnPlaceOrder();
    }
}
