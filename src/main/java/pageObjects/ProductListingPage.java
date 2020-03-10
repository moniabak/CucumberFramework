package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListingPage {
    public ProductListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    private WebElement btnAddToCart;

    @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
    private List<WebElement> prdList;

    @FindBy(how = How.ID, using = "pa_color")
    private WebElement color;

    @FindBy(how = How.ID, using = "pa_size")
    private WebElement size;

    public void clickOnAddToCart() {
        btnAddToCart.click();
    }

    public void selectProduct(int productNumber) {
        prdList.get(productNumber).click();
    }

    public Select selectElement(WebElement element) {
        Select dropColor = new Select(element);
        return dropColor;
    }

    public void selectSize(String size){
        selectElement(this.size).selectByVisibleText(size);
    }

    public void selectColor(String color){
        selectElement(this.color).selectByVisibleText(color);
    }

}
