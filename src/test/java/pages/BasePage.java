package pages;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    public HelperMethods callmethod = new HelperMethods(driver);

    @FindBy(how = How.ID, using = "searchboxTrigger")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;

    public BasePage(WebDriver driver)
    {
        {
            this.driver = driver;
            //This initElements constructor will create all WebElements
            PageFactory.initElements(driver, this);

        }
    }

    //Methods

//    public BasePage verifyPageTitle()
//
//    {
//        Assert.assertTrue(driver.getTitle().contains("eMAG.ro - Găsești mai mult decât crezi"));
//        return this;
//    }


    //Fill search Field
    public BasePage fillSearchField(String name)
    {
        searchField.sendKeys(name);
        return this;
    }

    //Click on search button
    public EmagSearchPage clickOnSearchButton()
    {
        searchButton.click();
        return new EmagSearchPage(driver);
    }



}
