package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.FileReaderManager;
import managers.PageObjectManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
//    TestContext testContext;
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;

    public CheckoutPageSteps(PageObjectManager pageObjectManager) {
        this.pageObjectManager = pageObjectManager;
        checkoutPage = this.pageObjectManager.getCheckoutPage();
    }

    //    public CheckoutPageSteps(TestContext testContext) {
//        this.testContext = testContext;
//        checkoutPage = this.testContext.getPageObjectManager().getCheckoutPage();
//    }

    @And("^enter \"([^\"]*)\" personal details on checkout page$")
    public void enterCustomerNamePersonalDetailsOnCheckoutPage(String customerName) throws Throwable {
        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.fillPersonalDetails(customer);
    }

    @And("^select payment method as \"([^\"]*)\" payment$")
    public void selectPaymentMethodAsPayment(String arg0) {
        checkoutPage.selectPaymentMethod("CheckPayment");
    }

    @And("^select same delivery address$")
    public void selectSameDeliveryAddress() throws InterruptedException {
        checkoutPage.checkShipToDifferentAddress(false);
    }

    @And("^place the order$")
    public void placeTheOrder() {
        checkoutPage.checkTermAndCondition(true);
        checkoutPage.clickOnPlaceOrder();
    }
}
