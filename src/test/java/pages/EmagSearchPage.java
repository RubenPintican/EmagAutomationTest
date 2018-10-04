package pages;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagSearchPage extends BasePage {
    WebDriver driver;

    public HelperMethods callmethod = new HelperMethods(driver);

    @FindBy(how = How.XPATH, using = "//a[@title='Telefon mobil Samsung Galaxy S9, Dual SIM, 64GB, 4G, Blue']")
    private WebElement phoneButton;
    @FindBy(how = How.XPATH, using = ".//*[@class='title-phrasing title-phrasing-xl']")
    private WebElement searchResult;

    public EmagSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmagSearchPage verifySearchPageTitle() {
        Assert.assertEquals("Cauti Samsung Galaxy S9 ? Descopera Oferta - eMAG.ro", driver.getTitle());
        return this;
    }

    public EmagSearchPage validateResults(String productName) {
        Assert.assertTrue(searchResult.getText().contains("Samsung Galaxy S9"));
        return this;
    }

    public EmagProductPage clickOnSelectedPhone() {
        callmethod.scrollDownMore(driver);
        phoneButton.click();
        return new EmagProductPage(driver);

    }


}
