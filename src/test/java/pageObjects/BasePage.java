package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    public static final int TIME_OUT = 10;
    public WebDriver driver;
    public WebDriverWait wait;
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIME_OUT), this);
        wait = new WebDriverWait(driver, TIME_OUT);
    }


    public void clear(WebElement element) {
        LOGGER.debug("Clearing element: {}.", element);
        element.clear();
    }

    public void click(WebElement element) {
        LOGGER.debug("Clicking into element: {}.", element);
        waitForElementPresent(element);
        element.click();
    }

    public void sendKeys(WebElement element, String string) {
        LOGGER.debug("Send {} into element: {}.", string, element);
        element.sendKeys(string);
    }

    public String getText(WebElement element) {
        LOGGER.debug("Get text from element {}.", element);
        String text = null;
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOf(element));
            text = elem.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Element {} is not visible ", element);
        }
        return text;
    }

    public void selectOptionByText(WebElement element, String string) {
        LOGGER.debug("Select {} into element: {}.", string, element);
        Select select = new Select(element);
        select.selectByVisibleText(string);
    }

    public void check(WebElement element, boolean state) {
        LOGGER.debug("Checking if element is selected or not");
        boolean isSelectedTerms = element.isSelected();
        if (state != isSelectedTerms) {
            try {
                waitForElementEnable(element);
                element.click();
            } catch (StaleElementReferenceException e) {
                LOGGER.error("Element didn't check");
            }
        }
    }

    public void waitForElementPresent(WebElement element) {
        LOGGER.debug("Checking presence of element: {}.", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementEnable(WebElement element) {
        LOGGER.debug("Checking presence of element: {}.", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}