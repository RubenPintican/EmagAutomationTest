package pages.cel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelHomePage extends BasePage<CelHomePage> {

    @FindBy(how = How.XPATH, using = ".//*[@id='logo_head']/img")
    private WebElement logoButton;

    public CelHomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public BasePage verifyPageTitle() {
        Assert.assertTrue(driver.getTitle().contains("CEL.ro - CEL mai ieftin, CEL mai rapid."));
        return this;
    }

    protected void load() {
        driver.get("http://www.cel.ro/");
    }

    protected void isLoaded() throws Error {

        Assert.assertTrue("Button not present", helper.isElementPresent(logoButton));
    }
}
