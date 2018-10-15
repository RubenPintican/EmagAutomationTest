package pages.cel;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelHomePage extends BasePage<CelHomePage> {

    public HelperMethods helper = new HelperMethods(driver);

    @FindBy(how = How.XPATH, using = "//div[@class='welcomeMsg']")
    private WebElement welcomeMessage;

    public CelHomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public CelHomePage welcomeMessage() {
//        Assert.assertTrue("Button is not present", helper.hoverWebElement(welcomeMessage, driver));
//        return this;
//    }


    public BasePage verifyPageTitle() {
        Assert.assertTrue(driver.getTitle().contains("CEL.ro - CEL mai ieftin, CEL mai rapid."));
        return this;
    }

    protected void load() {
        driver.get("http://www.cel.ro/");
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("CEL.ro - CEL mai ieftin, CEL mai rapid."));
    }
}
