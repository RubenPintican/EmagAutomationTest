package pages.emag;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagLogInPage extends BasePage<EmagLogInPage> {

    public HelperMethods helper = new HelperMethods(driver);


    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextField;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement continueButton;


    public EmagLogInPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmagLogInPage fillEmailField(String email) {
        emailTextField.sendKeys(email);
        return this;
    }

    public EmagLogInPage clickOnContinueButton() {
        helper.waitExplicit(continueButton, driver);
        continueButton.click();
        return this;
    }

    public EmagLogInPage fillPasswordField(String password) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + password + "';", passwordField);
        return this;
    }


    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("eMAG.ro"));
    }
}
