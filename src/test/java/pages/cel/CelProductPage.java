package pages.cel;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelProductPage extends BasePage<CelProductPage> {

    public HelperMethods helper = new HelperMethods(driver);


    @FindBy(how = How.XPATH, using = "//h2[@class='productName']")
    private WebElement validateProductPage;
    @FindBy(how = How.XPATH, using = "//div[@class='c_online']")
    private WebElement fullPrice;
    @FindBy(how = How.XPATH, using = "//span[@class='productPrice']")
    private WebElement salesPrice;
    @FindBy(how = How.XPATH, using = "//div[@class='stamp stampDiscount']")
    private WebElement discount;
    @FindBy(how = How.ID, using = "info_stoc")
    private WebElement inStock;
    @FindBy(how = How.ID, using = "info_stoc")
    private WebElement limitedStockLabel;
    @FindBy(how = How.ID, using = "email_news")
    private WebElement emailFieldNewsletter;
    @FindBy(how = How.XPATH, using = "//button[@class='send']")
    private WebElement subscribeNewsletterButton;

    public CelProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CelProductPage validateDiscountProduct(String expectedOldPrice, String expectedNewPrice, String expectedDiscount) {
        String actualOldPrice = fullPrice.getText();
        String actualNewPrice = salesPrice.getText();
        String actualDiscount = discount.getText();
        Assert.assertEquals("Old price incorrectly displayed", expectedOldPrice, actualOldPrice);
        Assert.assertEquals(expectedNewPrice, actualNewPrice);
        Assert.assertEquals(expectedDiscount, actualDiscount);
        return this;
    }

    public CelProductPage verifyThatTheProductIsInStock() {
        Assert.assertTrue("Product not in stock", helper.isElementPresent(limitedStockLabel) || helper.isElementPresent(inStock));
        return this;
    }

    public CelProductPage verifyThatPopUpIsPresent(String email) {

        if (helper.isElementPresent(emailFieldNewsletter)) {
            emailFieldNewsletter.sendKeys(email);
            subscribeNewsletterButton.click();
        }

        return this;

    }


    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("Telefon Mobil Apple iPhone X 256GB Space Gray "));
    }
}
