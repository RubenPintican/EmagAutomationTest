package pages.emag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>>extends LoadableComponent<T>  {

    WebDriver driver;

    @FindBy(how = How.ID, using = "searchboxTrigger")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;
    @FindBy(how = How.ID, using = "my_account")
    private WebElement myAccountButton;

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
    public EmagSingInPage goToSingIn()
    {
        myAccountButton.click();
        return new EmagSingInPage(driver).get();
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
        return new EmagSearchPage(driver);
    }

}
