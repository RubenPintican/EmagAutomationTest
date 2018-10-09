package pages.cel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CelHomePage extends BasePage<CelHomePage> {

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
        Assert.assertTrue(driver.getTitle().contains("CEL.ro - CEL mai ieftin, CEL mai rapid."));
    }
}
