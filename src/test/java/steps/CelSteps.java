package steps;

import help.TestData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.cel.CelHomePage;
import pages.cel.CelSingInPage;

import java.io.IOException;

public class CelSteps extends Steps {
    TestData testData;
    WebDriver driver;

    String email;
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
        email = testData.properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";
        firstName =testData.properties.getProperty("first.name");
        lastName = testData.properties.getProperty("last.name");
        suburb = testData.properties.getProperty("suburb");
        gender = testData.properties.getProperty("gender");
        telephone = testData.properties.getProperty("telephone");
        city = testData.properties.getProperty("city");
        streetAddress =testData.properties.getProperty("street.address");




    }

    @Given("I go to Cel home page")
    @When("I go to Cel home page")
    public void goToCelHomePage(){
        CelHomePage homePage = new CelHomePage(driver).get();
        homePage.verifyPageTitle();
    }

    @When ("I SingUp on Cel")
    public void singUpPage()
    {
        CelHomePage homePage =new CelHomePage(driver).get();
        homePage.verifyPageTitle()
                .singUpCellAccount()
                .fillFirstNameField()
                .fillLastNameField()
                .fillEmailAddressField()
                .clickGenderBox(gender)
                .fillTelephoneField()
                .fillStreetAddressField()
                .clickSuburb(suburb)
                .clickCity(city)
                .createAccountButton()
                .validationMessage()
                .clickOnContinueButton();
    }

    @When("I SingIn on Cel")
    public void singInPage()
    {
    CelHomePage homePage = new CelHomePage(driver).get();
    homePage.verifyPageTitle()
            .singInCellAccount()
            .fillEmailField()
            .fillPasswordField()
            .singInButton()
            .welcomeMessage();

    }
}
