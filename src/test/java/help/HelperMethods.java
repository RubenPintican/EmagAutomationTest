package help;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        element.click();
    }

    /**
     * Fill WebElement with a value
     *
     * @param element
     * @param value
     */

    public void fillWebElement(WebElement element, String value) {
        element.sendKeys(value);
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
}



