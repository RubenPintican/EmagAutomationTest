package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class EmagSearchPage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//*[@class='title-phrasing title-phrasing-xl']")
    private WebElement searchResult;


    public EmagSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify that the title is correct
     *
     * @param productName
     * @return
     */
    public EmagSearchPage verifySearchPageTitle(String productName) {
        Assert.assertEquals("Cauti " + productName + " ? Descopera Oferta - eMAG.ro", driver.getTitle());
        return this;
    }

    /**
     * Validate if the product is displayed
     *
     * @param productName
     * @return
     */
    public EmagSearchPage validateResults(String productName) {
        Assert.assertTrue(searchResult.getText().contains(productName));
        return this;
    }

    /**
     * Click on the selected product
     *
     * @return
     */
    public EmagProductPage clickOnFirstCorrectProduct(String productName) {
        List<WebElement> productList= driver.findElements(By.xpath(".//*[@id='card_grid']//div/h2/a"));
        for (int i = 0; i < productList.size(); i++) {
            String product = productList.get(i).getText();
            System.out.println(product);
            if (productList.get(i).getText().contains(productName)) {
                productList.get(i).click();
                return new EmagProductPage(driver);
            }
        }
        return null;

    }

}


