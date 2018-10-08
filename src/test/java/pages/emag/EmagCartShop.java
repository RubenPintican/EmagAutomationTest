package pages.emag;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagCartShop extends BasePage<EmagCartShop> {


    @FindBy(how = How.XPATH, using = "//div[@class='order-summary-text']")
    private WebElement orderSummary;

    public EmagCartShop(WebDriver driver) {

            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);

    }

    /**
     * Command summary validation
     *
     * @return
     */
    public EmagCartShop validateOrderSummary() {
        Assert.assertTrue(driver.getPageSource().contains("Sumar comanda"));
        return this;

    }

    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {

    }
}
