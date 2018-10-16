package steps;

import help.TestData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.cel.CelHomePage;
import pages.cel.CelProductPage;
import pages.cel.CelSearchPage;

import java.io.IOException;

public class CelSteps extends Steps {
    TestData testData;
    WebDriver driver;

    /**
     * Variabile declarate global
     */
    String randomEmail;
    String myEmailAccount;
    String myPasswordAccount;
    String firstName;
    String lastName;
    String suburb;
    String gender;
    String streetAddress;
    String telephone;
    String city;

    @Given("I load test data")
    public void loadTestData() throws IOException {
        testData = new TestData();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        randomEmail = testData.properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";
        firstName = testData.properties.getProperty("cel.first.name");
        lastName = testData.properties.getProperty("cel.last.name");
        suburb = testData.properties.getProperty("cel.suburb");
        gender = testData.properties.getProperty("cel.gender");
        telephone = testData.properties.getProperty("cel.telephone");
        city = testData.properties.getProperty("cel.city");
        streetAddress = testData.properties.getProperty("cel.street.address");

        myEmailAccount = testData.properties.getProperty("cel.email.account");
        myPasswordAccount = testData.properties.getProperty("cel.password.account");


    }

    @Given("I go to Cel home page")
    @When("I go to Cel home page")
    public void goToCelHomePage() {
        CelHomePage homePage = new CelHomePage(driver).get();
        homePage.verifyPageTitle();
    }

    @When("I SingUp on Cel")
    public void singUpPage() {
        CelHomePage homePage = new CelHomePage(driver).get();
        homePage.verifyPageTitle()
                .singUpCellAccount()
                .fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillEmailAddressField(randomEmail)
                .clickGenderBox(gender)
                .fillTelephoneField(telephone)
                .fillStreetAddressField(streetAddress)
                .clickSuburb(suburb)
                .clickCity(city)
                .createAccountButton()
                .validationMessage()
                .clickOnContinueButton();
    }

    @When("I SingIn on Cel")
    public void singInPage() {
        CelHomePage homePage = new CelHomePage(driver).get();
        homePage.verifyPageTitle()
                .singInCellAccount()
                .fillEmailField(myEmailAccount)
                .fillPasswordField(myPasswordAccount)
                .singInButton()
                .welcomeMessage();

    }

    @When("I search for $product on Cel")
    public  void  searchOnCel (String product)
    {
        CelHomePage homePage = new CelHomePage(driver);
        homePage.verifyPageTitle()
                .fillSearchField(product)
                .clickOnSearchButton()
                .validateResults(product)
                .clickOnFirstItems(product);
    }

    @Then("I verify if the oldprice:$oldprice newprice:$newprice discount:$discount for product is correct")
    public void verifyDiscountForProduct(String oldprice, String newprice, String discount)
    {
        CelProductPage productPage = new CelProductPage(driver);
        productPage.verifyThatPopUpIsPresent(randomEmail)
                .verifyThatTheProductIsInStock()
                .validateDiscountProduct(oldprice, newprice,discount);
    }

}
