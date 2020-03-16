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
        LOGGER.info("Clearing element: " + element + ".");
        element.clear();
        LOGGER.info("Done.");
    }

    public void click(WebElement element) {
        LOGGER.info("Clicking into element: " + element + ".");
        waitForElementPresent(element);
        element.click();
        LOGGER.info("Done.");
    }

    public void sendKeys(WebElement element, String string) {
        LOGGER.info("Send " + string + " into element: " + element + ".");
        waitForElementPresent(element);
        element.sendKeys(string);
        LOGGER.info("Done.");
    }

    public String getText(WebElement element) {
        LOGGER.info("Get text from element " + element);
        String text = null;
        try {
            WebElement elem = wait.until(ExpectedConditions.visibilityOf(element));
            text = elem.getText();
        } catch (NoSuchElementException e) {
            LOGGER.error("Element " + element + " is not visible ");
        }
        LOGGER.info("Done.");
        return text;
    }

    public void selectOptionByText(WebElement element, String string) {
        LOGGER.info("Select " + string + " into element: " + element + ".");
        Select select = new Select(element);
        select.selectByVisibleText(string);
        LOGGER.info("Done.");
    }

    public void check(WebElement element, boolean state) {
        LOGGER.info("Checking if element is selected or not");
        boolean isSelectedTerms = element.isSelected();
        if (state != isSelectedTerms) {
            try {
                waitForElementEnable(element);
                element.click();
            } catch (StaleElementReferenceException e) {
                LOGGER.error("Element didn't check");
            }
        }
        LOGGER.info("Done.");
    }

    public void waitForElementPresent(WebElement element) {
        LOGGER.info("Checking presence of element: " + element + ".");
        wait.until(ExpectedConditions.visibilityOf(element));
        LOGGER.info("Done.");
    }

    public void waitForElementEnable(WebElement element) {
        LOGGER.info("Checking presence of element: " + element + ".");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.info("Done.");
    }
}