package pages.cel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelSingInPage extends BasePage<CelSingInPage> {


    public CelSingInPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email_address")
    private WebElement emailTextField;
    @FindBy(how = How.NAME, using = "passwordx")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-special']")
    private WebElement logInButton;


    public CelSingInPage fillEmailField(String emailAccount) {
        helper.fillWebElement(emailTextField,driver);
        emailTextField.sendKeys(emailAccount);
        return this;
    }

    public CelSingInPage fillPasswordField(String passwordAccount) {
        helper.fillWebElement(passwordField, driver);
        passwordField.sendKeys(passwordAccount);
        return this;
    }

    public CelHomePage singInButton() {
        logInButton.click();
        return new CelHomePage(driver).get();
    }


    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("CEL.ro"));
    }
}
