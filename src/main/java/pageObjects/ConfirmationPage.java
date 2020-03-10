package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = ".order_item"))
    private List<WebElement> prodList;

    public List<String> getProductNames(){
        List<String>productNames = new ArrayList<>();
        for(WebElement element : prodList) {
            productNames.add(element.findElement(By.cssSelector(".product-name")).getText());
        }
        return productNames;
    }

}
