package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagProductPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//i[@class='em em-cart_fill gtm_680klw']")
    private WebElement addCartButton;
    @FindBy(how = How.XPATH, using = "//h4[@class='mrg-sep-none']")
    private WebElement validateProductInCart;
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-sm btn-block']")
    private WebElement clickOnDetailsCartButton;
    @FindBy(how = How.XPATH, using = "//span[@class='product-code-display pull-left']")
    private WebElement validateProductPage;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-old-price']/s")
    private WebElement fullPrice;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-new-price']")
    private WebElement salesPrice;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-this-deal']")
    private WebElement discount;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='label label-in_stock']")
    private WebElement inStock;


    public EmagProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Validate that it`s on the product page
     *
     * @return
     */
    public EmagProductPage validatePageProduct() {
        Assert.assertTrue(driver.getPageSource().contains("Cod produs"));
        return this;
    }

    /**
     * Validates the product discount
     *
     * @param expectedOldPrice
     * @param expectedNewPrice
     * @param expectedDiscount
     */
    public EmagProductPage validateDiscountProduct(String expectedOldPrice, String expectedNewPrice, String expectedDiscount) {
        String actualOldPrice = fullPrice.getText();
        String actualNewPrice = salesPrice.getText();
        String actualDiscount = discount.getText();
        Assert.assertEquals("Old price incorrectly displayed", expectedOldPrice, actualOldPrice);
        Assert.assertEquals(expectedNewPrice, actualNewPrice);
        Assert.assertEquals(expectedDiscount, actualDiscount);
        return this;
    }

    /**
     * Verify if the element is present
     *
     * @return
     */
    public EmagProductPage verifyThatTheProductIsInStock() {
        Assert.assertTrue("The page should contains inStock element", inStock.isDisplayed());
        return this;
    }

    /**
     * Click the add button
     *
     * @return
     */
    public EmagProductPage addPhoneToCart() {
        helper.waitExplicit(addCartButton, driver);
        addCartButton.click();
        return this;
    }

    /**
     * Validate that the product is in cart
     *
     * @return
     */
    public EmagProductPage validateProductInCart() {
        Assert.assertTrue(driver.getPageSource().contains("Produsul a fost adaugat in cos"));
        return this;
    }

    /**
     * Click details button
     *
     * @return
     */
    public EmagCartShop clickOnDetailsButton() {
        clickOnDetailsCartButton.click();
        return new EmagCartShop(driver);
    }


}
