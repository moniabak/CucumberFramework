package pageObjects;

import gherkin.lexer.Pa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".cart-button")
    private WebElement btnCart;

    @FindBy(how = How.CSS, using = ".checkout-button.button.alt.wc-forward")
    private WebElement btnContinueToCheckout;

    public void clickOnCart() {
        btnCart.click();
    }

    public void clickOnCountinueToCheckout(){
        btnContinueToCheckout.click();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}
    }
}
