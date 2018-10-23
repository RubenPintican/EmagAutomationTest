package pages.cel;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CelSingUpPage extends BasePage<CelSingUpPage> {

    public HelperMethods helper = new HelperMethods(driver);

    @FindBy(how = How.ID, using = "firstname")
    private WebElement firstNameField;
    @FindBy(how = How.ID, using = "lastname")
    private WebElement lastNameField;
    @FindBy(how = How.XPATH, using = ".//div/*[@id='email_address']")
    private WebElement emailAddressField;
    @FindBy(how = How.ID, using = "customers_gender")
    private WebElement genderBox;
    @FindBy(how = How.ID, using = "telephone")
    private WebElement telephoneField;
    @FindBy(how = How.ID, using = "street_address")
    private WebElement streetAddressField;
    @FindBy(how = How.ID, using = "entry_suburb")
    private WebElement suburbField;
    @FindBy(how = How.ID, using = "city")
    private WebElement cityField;
    @FindBy(how = How.XPATH, using = ".//*[@id='cont_nou']/tbody/tr[3]/td/button")
    private WebElement createAccountButton;
    @FindBy(how = How.XPATH, using = "//h2[@class='articleTitle']")
    private WebElement messageValidation;
    @FindBy(how = How.XPATH, using = ".//*[@id='bodycode']/div[3]/a")
    private WebElement continueButton;


    public CelSingUpPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CelSingUpPage fillFirstNameField(String firstName) {
        helper.fillWebElement(firstNameField, driver);
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CelSingUpPage fillLastNameField(String lastName) {
        helper.fillWebElement(lastNameField, driver);
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CelSingUpPage fillEmailAddressField(String email) {
        helper.fillWebElement(emailAddressField, driver);
        emailAddressField.sendKeys(email);
        return this;
    }

    public CelSingUpPage clickGenderBox(String gender) {
        helper.selectByText(genderBox, gender);
        helper.clickWebElement(genderBox);
        genderBox.click();
        return this;
    }


    public CelSingUpPage fillTelephoneField(String telephone) {
        helper.fillWebElement(telephoneField, driver);
        telephoneField.sendKeys(telephone);
        return this;
    }

    public CelSingUpPage fillStreetAddressField(String streetAddress) {
        helper.fillWebElement(streetAddressField, driver);
        streetAddressField.sendKeys(streetAddress);
        return this;
    }

    public CelSingUpPage clickSuburb(String suburb) {
        helper.selectByText(suburbField, suburb);
        helper.clickWebElement(suburbField);
        suburbField.click();
        return this;
    }

    public CelSingUpPage clickCity(String city) {
        helper.selectByText(cityField, city);
        helper.clickWebElement(cityField);
        cityField.click();
        return this;
    }

    public CelSingUpPage createAccountButton() {
        createAccountButton.click();
        return this;
    }

    public CelSingUpPage validationMessage() {
        Assert.assertTrue(messageValidation.getText().contains("Contul tau a fost creat"));
        return this;
    }

    public CelHomePage clickOnContinueButton() {
        continueButton.click();
        return new CelHomePage(driver).get();
    }

    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().contains("Login"));
    }
}
