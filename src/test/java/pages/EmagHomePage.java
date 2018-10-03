package pages;

import help.HelperMethodes;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage {

    WebDriver driver;

    public HelperMethodes functions = new HelperMethodes(driver);

    @FindBy(how = How.ID, using = "searchboxTrigger")
    private WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;

    //constructor

    public EmagHomePage(WebDriver driver) {
        {
            this.driver = driver;
            //This initElements method will create all WebElements
            PageFactory.initElements(driver, this);

        }
    }

    //methods

    public void verifyPageTitle()
    {
        Assert.assertTrue(driver.getTitle().contains("eMAG.ro - Găsești mai mult decât crezi"));
    }

    //Fill search box
    public EmagHomePage fillSearchButton(String name)
    {
        searchBox.sendKeys(name);
        return this;
    }

    //Click on search button
    public EmagSearchPage clickOnSearchButton()
    {
        searchButton.click();
        return new EmagSearchPage(driver);
    }

}