package pages;

import help.HelperMethodes;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagPhonePage {
    WebDriver driver;

    public HelperMethodes functions = new HelperMethodes(driver);

    @FindBy (how= How.XPATH, using = "//i[@class='em em-cart_fill gtm_680klw']")
    private WebElement addCartButton;
    @FindBy (how = How.XPATH, using = "//h4[@class='mrg-sep-none']")
    private WebElement validateProductInCart;
    @FindBy (how = How.XPATH, using = "//a[@class='btn btn-primary btn-sm btn-block']")
    private WebElement clickOnDetailsCartButton;


    public EmagPhonePage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public EmagPhonePage addPhoneToCart ()
    {
        addCartButton.click();
        return this;
    }

    public EmagPhonePage validateProductInCart()
    {
        Assert.assertTrue(driver.getPageSource().contains("Produsul a fost adaugat in cos"));
        return this;
    }

    public EmagCartShop clickOnDetailsButton()
    {
        clickOnDetailsCartButton.click();
        return new EmagCartShop(driver);
    }



}
