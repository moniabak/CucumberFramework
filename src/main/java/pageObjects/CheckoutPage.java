package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Customer;

import java.util.List;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "billing_first_name")
    private WebElement txtbxFirstName;

    @FindBy(how = How.ID, using = "billing_last_name")
    private WebElement txtbxLastName;

    @FindBy(how = How.ID, using = "billing_email")
    private WebElement txtbxBillingEmail;

    @FindBy(how = How.ID, using = "billing_phone")
    private WebElement txtbxBillingPhone;

    @FindBy(how = How.CSS, using = "#billing_country_field .select2-arrow")
    private WebElement dropCountryArrow;

    @FindBy(how = How.CSS, using = "#billing_state_field .select2-arrow")
    private WebElement dropCountyArrow;

    @FindBy(how = How.CSS, using = "#select2-drop ul li")
    private List<WebElement> countryList;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement txtbxBillingCity;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement txtbxBillingAddress1;

    @FindBy(how = How.ID, using = "billing_postcode")
    private WebElement txtbxBillingPostCode;

    @FindBy(how = How.ID, using = "ship-to-different-address-checkbox")
    private WebElement chbxShipToDifferentAddress;

    @FindBy(how = How.CSS, using = "ul.wc_payment_methods li")
    private List<WebElement> paymentMethodList;

    @FindBy(how = How.ID, using = "terms.input-checkbox")
    private WebElement chbxAcceptTermAndCondition;

    @FindBy(how = How.ID, using = "place_order")
    private WebElement btnPlaceOrder;


    public void enterName(String name) {
        txtbxFirstName.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        txtbxLastName.sendKeys(lastName);
    }

    public void enterBillingEmail(String billingEmail) {
        txtbxBillingEmail.sendKeys(billingEmail);
    }

    public void enterBillingPhone(String billingPhone) {
        txtbxBillingPhone.sendKeys(billingPhone);
    }

    public void enterBillingCity(String billingCity) {
        txtbxBillingCity.sendKeys(billingCity);
    }

    public void enterBillingAddress1(String billingAddress1) {
        txtbxBillingAddress1.sendKeys(billingAddress1);
    }

    public void enterPostCode(String billingPostCode) {
        txtbxBillingPostCode.sendKeys(billingPostCode);
    }

    public void checkShipToDifferentAddress(boolean value) {
        if (!value) chbxShipToDifferentAddress.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public void selectCountry(String countryName) {
        dropCountryArrow.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        for (WebElement country : countryList) {
            if (country.getText().equals(countryName)) {
                country.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                break;
            }
        }
    }

    public void selectCounty(String countyName) {
        dropCountyArrow.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        for (WebElement county : countryList) {
            if (county.getText().equals(countyName)) {
                county.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                break;
            }
        }
    }

    public void selectPaymentMethod(String paymentMethod) {
        if ((paymentMethod.equals("CheckPayment"))) {
            paymentMethodList.get(0).click();
        } else if ((!paymentMethod.equals("Cash"))) {
            paymentMethodList.get(1).click();
        } else {
            new Exception("Payment Method not recognised : " + paymentMethod);
        }
        try {
            Thread.sleep(3000);
        } catch (
                InterruptedException ex) {
        }
    }

    public void checkTermAndCondition(boolean value) {
        if (value) chbxAcceptTermAndCondition.click();
    }

    public void clickOnPlaceOrder() {
        btnPlaceOrder.submit();
    }

//    public void fillPersonalDetails() {
//        enterName("Aotomation");
//        enterLastName("Test");
//        enterBillingPhone("00000000");
//        enterBillingEmail("Automation@gmail.com");
//        selectCountry("India");
//        enterBillingCity("Delhi");
//        enterBillingAddress1("Shalimar Bagh");
//        enterPostCode("110088");
//        selectCounty("Delhi");
//    }

    public void fillPersonalDetails(Customer customer) {
        enterName(customer.firstName);
        enterLastName(customer.lastName);
        enterBillingPhone(customer.phoneNumber.mob);
        enterBillingEmail(customer.emailAddress);
        enterBillingCity(customer.address.city);
        enterBillingAddress1(customer.address.streetAddress);
        enterPostCode(customer.address.postCode);
        selectCountry(customer.address.country);
        selectCounty(customer.address.county);
    }
}
