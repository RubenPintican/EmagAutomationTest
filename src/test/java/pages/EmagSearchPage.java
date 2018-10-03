package pages;

import help.HelperMethodes;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagSearchPage {
    WebDriver driver;

    public HelperMethodes functions = new HelperMethodes(driver);

    @FindBy (how= How.XPATH, using = "//a[@title='Telefon mobil Samsung Galaxy S9, Dual SIM, 64GB, 4G, Blue']")
    private WebElement phoneButton;
    @FindBy (how=How.XPATH, using = ".//*[@class='title-phrasing title-phrasing-xl']")
    private WebElement searchResult;

    public EmagSearchPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifySearchPageTitle()
    {
        Assert.assertEquals("Cauti Samsung Galaxy S9 ? Descopera Oferta - eMAG.ro", driver.getTitle());
    }

    public void validateResults ()
    {
        Assert.assertTrue(searchResult.getText().contains("Samsung Galaxy S9"));
    }

    public EmagPhonePage clickOnSelectedPhone ()

    {
        functions.scrollDownMore(driver);
        phoneButton.click();
        return new EmagPhonePage(driver);

    }




}
