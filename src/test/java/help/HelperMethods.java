package help;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

    WebDriver driver;

    //Constructor

    public HelperMethods(WebDriver driver)

    {
        this.driver=driver;
    }

    //Methods

    //Click on random WebElement

    public void clickWebElement(WebElement element)

    {
        element.click();
    }

    //Fill WebElement with a value

    public void fillWebElement (WebElement element, String value)

    {
        element.sendKeys(value);
    }

    //Wait Explicit

        public void waitExplicit ( WebElement element, WebDriver driver)
        {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
        }

    //Validate page

    public void validatePage(String expected, WebDriver driver)

    {
        {
            String actual=driver.getTitle();
        }
    }

    //Select by Text

    public void selectByText(WebElement element, String text )
    {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);

    }

    //Select by Value

    public void selectByValue (WebElement element, String value)
    {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    //Select by Visible Text

    public void selectValueDropDownByText(WebElement element,String option)
    {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);

    }

    //Scroll Page Down

    public void scrollDownMore(WebDriver driver)
    {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
    }
}


