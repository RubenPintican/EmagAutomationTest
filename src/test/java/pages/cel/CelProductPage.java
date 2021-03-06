package pages.cel;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelProductPage extends BasePage<CelProductPage> {

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
    @FindBy(how = How.CLASS_NAME, using = "info_stoc in_stoc_furnizor")
    private WebElement limitedStockLabel;
    @FindBy(how = How.ID, using = "email_news")
    private WebElement emailFieldNewsletter;
    @FindBy(how = How.XPATH, using = "//button[@class='send']")
    private WebElement subscribeNewsletterButton;
    @FindBy(how = How.XPATH, using = "//h2[@class='productName']")
    private WebElement productName;

    public CelProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CelProductPage validateDiscountProduct(String expectedOldPrice, String expectedNewPrice, String expectedDiscount) {
        String actualOldPrice = fullPrice.getText();
        String actualNewPrice = salesPrice.getText();
        String actualDiscount = discount.getText();
        Assert.assertEquals("Old price is not correct", expectedOldPrice, StringUtils.substringBetween(actualOldPrice, "pret vechi ".toUpperCase(), " lei".toUpperCase()));
        Assert.assertEquals("New price is not correct", expectedNewPrice, actualNewPrice);
        Assert.assertTrue("Discount is not correct", actualDiscount.contains(expectedDiscount));
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
            helper.waitExplicitElementDisappear(emailFieldNewsletter, driver);
        }

        return this;

    }


    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The product page is not loaded", helper.isElementPresent(productName));
    }
}
