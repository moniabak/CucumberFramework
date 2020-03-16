package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Customer;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
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

    @FindBy(how = How.ID, using = "billing_country")
    private WebElement dropCountryArrow;

    @FindBy(how = How.ID, using = "billing_state")
    private WebElement dropCounty;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement txtbxBillingCity;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement txtbxBillingAddress1;

    @FindBy(how = How.ID, using = "billing_postcode")
    private WebElement txtbxBillingPostCode;

    @FindBy(how = How.ID, using = "terms")
    private WebElement chbxAcceptTermAndCondition;

    @FindBy(how = How.ID, using = "place_order")
    private WebElement btnPlaceOrder;


    public void enterName(String name) {
        sendKeys(txtbxFirstName, name);
    }

    public void enterLastName(String lastName) {
        sendKeys(txtbxLastName, lastName);
    }

    public void enterBillingEmail(String billingEmail) {
        sendKeys(txtbxBillingEmail, billingEmail);
    }

    public void enterBillingPhone(String billingPhone) {
        sendKeys(txtbxBillingPhone, billingPhone);
    }

    public void enterBillingCity(String billingCity) {
        sendKeys(txtbxBillingCity, billingCity);
    }

    public void enterBillingAddress1(String billingAddress1) {
        sendKeys(txtbxBillingAddress1, billingAddress1);
    }

    public void enterPostCode(String billingPostCode) {
        sendKeys(txtbxBillingPostCode, billingPostCode);
    }

    public void selectCountry(String countryName) {
        selectOptionByText(dropCountryArrow, countryName);
    }

    public void selectCounty(String countyName) {
        selectOptionByText(dropCounty, countyName);
    }

    public void checkTermAndCondition(boolean value) {
        check(chbxAcceptTermAndCondition, value);
    }

    public void clickOnPlaceOrder() {
        btnPlaceOrder.submit();
    }

    public void fillPersonalDetails(Customer customer) {
        enterName(customer.firstName);
        enterLastName(customer.lastName);
        selectCountry(customer.address.country);
        enterBillingPhone(customer.phoneNumber.mob);
        enterBillingEmail(customer.emailAddress);
        selectCounty(customer.address.county);
        enterBillingCity(customer.address.city);
        enterBillingAddress1(customer.address.streetAddress);
        enterPostCode(customer.address.postCode);
    }
}
