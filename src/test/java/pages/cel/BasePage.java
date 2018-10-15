package pages.cel;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    WebDriver driver;
    public HelperMethods helper = new HelperMethods(driver);

    @FindBy (how = How.XPATH, using = "//i[@class='icon-supervisor_account']")
    private WebElement myAccount;
    @FindBy(how = How.ID, using = "keyword")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = ".//*[@id='quick_find']/button")
    private WebElement searchButton;
    @FindBy (how = How.XPATH, using = ".//*[@id='login_header']/div//a[1]")
    private WebElement logInOptionButton;
    @FindBy (how = How.XPATH, using = ".//*[@id='login_header']/div//a[2]")
    private WebElement singUpOptionButton;
    @FindBy (how = How.XPATH, using = "//div[@class='welcomeMsg']")
    private WebElement welcomeMessage;



    public BasePage(WebDriver driver) {


        {

            this.driver = driver;
            PageFactory.initElements(driver, this);

        }
    }

    public CelSingInPage singInCellAccount()
    {
        helper.hoverWebElement(myAccount,driver);
        logInOptionButton.click();
        return new CelSingInPage(driver);
    }

    public CelSingUpPage singUpCellAccount()
    {
        helper.hoverWebElement(myAccount,driver);
        singUpOptionButton.click();
        return new CelSingUpPage(driver);
    }

    public CelHomePage welcomeMessage()
    {
        helper.hoverWebElement(welcomeMessage,driver);
        Assert.assertTrue(welcomeMessage.getText().contains("Pintican Ruben"));
        return new CelHomePage(driver);
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
    public CelSearchPage clickOnSearchButton() {
        searchButton.click();
        return new CelSearchPage(driver).get();
    }
}
