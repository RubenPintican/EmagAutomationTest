package pages.emag;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.cel.CelHomePage;

public abstract class BasePage<T extends LoadableComponent<T>>extends LoadableComponent<T>  {

    WebDriver driver;
    public HelperMethods helper = new HelperMethods(driver);

    @FindBy(how = How.ID, using = "searchboxTrigger")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;
    @FindBy(how = How.ID, using = "my_account")
    private WebElement myAccountButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ph-dropdown-inner']/p/strong")
    private WebElement myAccountName;
    @FindBy (how = How.XPATH, using = "//a[@class='js-logout-link']")
    private WebElement logOutButton;

    public BasePage(WebDriver driver) {
        {
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }
    }

    public EmagSingUpPage goToSingUp()
    {
        myAccountButton.click();
        return new EmagSingUpPage(driver).get();
    }
    public EmagLogInPage goToLogIn()
    {
        myAccountButton.click();
        return new EmagLogInPage(driver).get();
    }

    public EmagAccountPage goToAccountPage ()
    {
        myAccountButton.click();
        return new EmagAccountPage(driver).get();
    }

    /**
     * Fill search field
     *
     * @param name
     * @return
     */
    public BasePage fillSearchField(String name) {
        searchField.sendKeys(name);
        return this;
    }

    /**
     * Click search button
     *
     * @return
     */
    public EmagSearchPage clickOnSearchButton() {
        searchButton.click();
        return new EmagSearchPage(driver).get();
    }

    public boolean checkIfLogedIn()
    {
        helper.hoverWebElement(myAccountButton,driver);
        return helper.isElementPresent(logOutButton);
    }

    public BasePage<T> welcomeMessage()
    {
        helper.hoverWebElement(myAccountButton, driver);
        Assert.assertTrue("Element is not present",helper.isElementPresent(myAccountName));
        return this;
    }
}
