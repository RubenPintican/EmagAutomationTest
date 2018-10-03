package pages;

import help.HelperMethodes;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagCartShop {

    WebDriver driver;
    public HelperMethodes functions = new HelperMethodes(driver);

    @FindBy (how = How.XPATH, using = "//div[@class='order-summary-text']")
    private WebElement orderSummary;

    public EmagCartShop(WebDriver driver)
    {
        {
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
    }

    public EmagCartShop validateOrderSummary ()
    {
        Assert.assertTrue(driver.getPageSource().contains("Sumar comanda"));
        return this;

    }
}
