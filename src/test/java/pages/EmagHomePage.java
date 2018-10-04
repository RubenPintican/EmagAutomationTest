package pages;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage extends BasePage {

    WebDriver driver;

    public HelperMethods callmethod = new HelperMethods(driver);

    //constructor

    public EmagHomePage(WebDriver driver) {
        super(driver);
        {
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }
    }

    //Methods

    public BasePage verifyPageTitle() {
        Assert.assertTrue(driver.getTitle().contains("eMAG.ro - Găsești mai mult decât crezi"));
        return this;
    }
}
