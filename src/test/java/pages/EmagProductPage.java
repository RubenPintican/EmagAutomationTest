package pages;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagProductPage extends BasePage {
    WebDriver driver;

    public HelperMethods callmethod = new HelperMethods(driver);

    @FindBy(how = How.XPATH, using = "//i[@class='em em-cart_fill gtm_680klw']")
    private WebElement addCartButton;
    @FindBy(how = How.XPATH, using = "//h4[@class='mrg-sep-none']")
    private WebElement validateProductInCart;
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-sm btn-block']")
    private WebElement clickOnDetailsCartButton;
    @FindBy(how = How.XPATH, using = "//span[@class='product-code-display pull-left']")
    private WebElement validateProductPage;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-old-price']/s")
    private WebElement pretintreg;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-new-price']")
    private WebElement pretredus;
    @FindBy(how = How.XPATH, using = "//form[@class='main-product-form']//*[@class='product-this-deal']")
    private WebElement discount;


    public EmagProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmagProductPage validatePageProduct() {
        Assert.assertTrue(driver.getPageSource().contains("Cod produs"));
        return this;
    }

    public EmagProductPage validateDiscountProduct() {
        String oldPrice = pretintreg.getText();
        String newPrice = pretredus.getText();
        String discountPrice = discount.getText();
        Assert.assertEquals("3.89999 Lei", oldPrice);
        Assert.assertEquals("2.99999 Lei", newPrice);
        Assert.assertEquals("(- 23% )", discountPrice);
        return this;
    }


    public EmagProductPage addPhoneToCart() {
        callmethod.waitExplicit(addCartButton, driver);
        addCartButton.click();
        return this;
    }

    public EmagProductPage validateProductInCart() {
        Assert.assertTrue(driver.getPageSource().contains("Produsul a fost adaugat in cos"));
        return this;
    }

    public EmagCartShop clickOnDetailsButton() {
        clickOnDetailsCartButton.click();
        return new EmagCartShop(driver);
    }


}
