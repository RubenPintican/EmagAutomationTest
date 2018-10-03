package help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperMethodes {

    WebDriver driver;

    //Constructor

    public HelperMethodes(WebDriver driver)

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

    public void validatePage(String expected, WebDriver driver)

    {
        {
            String actual=driver.getTitle();
        }

    }
}
