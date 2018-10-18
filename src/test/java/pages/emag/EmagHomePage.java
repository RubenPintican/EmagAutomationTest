package pages.emag;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage extends BasePage<EmagHomePage> {

    public HelperMethods helper = new HelperMethods(driver);

    @FindBy(how = How.XPATH, using = "//a[@class='back-button']")
    private WebElement backHomePageButton;

    public EmagHomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify that page title is correct
     *
     * @return
     */


    protected void load() {

        driver.get("http://www.emag.ro/");
        if (helper.isElementPresent(backHomePageButton))
            helper.clickWebElement(backHomePageButton);
    }

    protected void isLoaded() throws Error {

        Assert.assertTrue(driver.getTitle().contains("eMAG.ro"));
    }


}
