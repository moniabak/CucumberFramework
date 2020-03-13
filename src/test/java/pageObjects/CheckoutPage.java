package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(how = How.ID, using = "billing_country")
    private WebElement dropCountryArrow;

    @FindBy(how = How.CSS, using = "#select2-drop ul li")
    private List<WebElement> countryList;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement txtbxBillingCity;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement txtbxBillingAddress1;

    @FindBy(how = How.ID, using = "billing_postcode")
    private WebElement txtbxBillingPostCode;

    @FindBy(how = How.CSS, using = "#terms")
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

    public void selectCountry(String countryName) {
        Select drpCountry = new Select(dropCountryArrow);
        drpCountry.selectByVisibleText(countryName);
    }

    public void checkTermAndCondition(boolean value) {
        boolean isSelectedTerms = chbxAcceptTermAndCondition.isSelected();
        if (value == isSelectedTerms) {
        } else {
            chbxAcceptTermAndCondition.click();
        }
    }

    public void clickOnPlaceOrder() {
        btnPlaceOrder.submit();
    }

    public void fillPersonalDetails(Customer customer) {
        enterName(customer.firstName);
        enterLastName(customer.lastName);
        enterBillingPhone(customer.phoneNumber.mob);
        enterBillingEmail(customer.emailAddress);
        enterBillingCity(customer.address.city);
        enterBillingAddress1(customer.address.streetAddress);
        enterPostCode(customer.address.postCode);
        selectCountry(customer.address.country);
    }
}
