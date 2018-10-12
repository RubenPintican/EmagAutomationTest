package pages.emag;

import help.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagSingUpPage extends BasePage<EmagSingUpPage>{

    public HelperMethods helper  = new HelperMethods(driver);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextField;
    @FindBy (how = How.XPATH, using = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement continueButton;
    @FindBy (how =How.ID, using = "r_name")
    private WebElement nameField;
    @FindBy (how=How.ID, using = "r_password")
    private WebElement passwordField;
    @FindBy (how=How.ID, using = "r_password_confirmation")
    private WebElement confirmPasswordField;
    @FindBy (how=How.ID,using = "agree_terms")
    private WebElement agreeTermsButton;
    @FindBy (how=How.ID,using = "subsribe_newlsetter")
    private WebElement confirmAgeButton;
    @FindBy (how=How.XPATH,using = "//*[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement continueButton2;


    public EmagSingUpPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmagSingUpPage fillEmailField(String email)
    {
        emailTextField.sendKeys(email);
        return this;
    }

    public EmagSingUpPage clickOnContinueButton()
    {
        helper.clickWebElement(continueButton);
        return this;
    }

    public EmagSingUpPage fillSingUpPage (String name, String password, String confirmationPassword) {
        helper.waitExplicit(nameField,driver);
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmationPassword);
        return this;
    }

    public EmagSingUpPage clickOnAgreeTerms()
    {
        agreeTermsButton.click();
        return this;
    }

    public EmagSingUpPage clickOnConfirmAgeButton()
    {
        confirmPasswordField.click();
        return this;
    }

    public EmagSearchPage clickonContinueButton()
    {
        continueButton2.click();
        return new EmagSearchPage(driver).get();
    }


        protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {

    }
}
