package help;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

    WebDriver driver;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on random WebElement
     *
     * @param element
     */

    public void clickWebElement(WebElement element) {
        waitExplicit(element, driver);
        element.click();
    }

    /**
     * Fill WebElement with a value
     *
     * @param element
     * @param
     */

    public void fillWebElement(WebElement element, WebDriver driver) {
        waitExplicit(element, driver);
        element.clear();
        element.sendKeys();
    }

    /**
     * Hover a WebElement
     */

    public void hoverWebElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /**
     * Wait Explicit
     *
     * @param element
     * @param driver
     */

    public void waitExplicit(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitExplicitElementDisappear(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOf(element));
    }

    public void fillField(WebElement password) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + password + "';", password);

    }

    public void clickRandomWebElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Validate page title
     *
     * @param expected
     * @param driver
     */

    public void validatePage(String expected, WebDriver driver) {
        {
            String actual = driver.getTitle();
        }
    }

    /**
     * Select WebElement by text
     *
     * @param element
     * @param text
     */

    public void selectByText(WebElement element, String text) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);

    }

    /**
     * Select WebElement by value
     *
     * @param element
     * @param value
     */

    public void selectByValue(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    /**
     * Select WebElement by text
     *
     * @param element
     * @param option
     */

    public void selectValueDropDownByText(WebElement element, String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);

    }

    /**
     * Scroll Page Down
     *
     * @param driver
     */

    public void scrollDownMore(WebDriver driver) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}



