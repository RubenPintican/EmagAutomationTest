package pages.cel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CelSearchPage extends BasePage<CelSearchPage> {


    public CelSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h2[@class='nameproducts']")
    private WebElement searchResult;
    @FindAll({@FindBy(how = How.XPATH, using = "//span[@itemprop='name']")})
    private List<WebElement> productList;


    public CelSearchPage validateResults(String productName) {
        Assert.assertTrue(searchResult.getText().toUpperCase().contains(productName.toUpperCase()));
        return this;
    }

    public CelProductPage clickOnFirstItems(String productName) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getText().toUpperCase().contains(productName.toUpperCase())) {
                productList.get(i).click();
                return new CelProductPage(driver).get();
            }
        }
        return null;
    }

    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("ieftine pagina 1"));
    }
}