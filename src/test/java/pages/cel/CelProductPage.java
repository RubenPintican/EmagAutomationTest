package pages.cel;

import help.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CelProductPage extends BasePage<CelProductPage> {

    public HelperMethods helper = new HelperMethods(driver);

    public CelProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {

    }
}
