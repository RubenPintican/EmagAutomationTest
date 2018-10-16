package steps;


import help.TestData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.emag.EmagHomePage;
import pages.emag.EmagProductPage;

import java.io.IOException;


public class EmagSteps extends Steps {
    TestData testData;
    WebDriver driver;

    /**
     * Variabile declarate global
     */
    String email;
    String name;
    String password;
    String confirmPassword;

    String myEmailAccount;
    String myPasswordAccount;
    String nickName;
    String mobilePhone;


    @Given("I load test data")
    public void loadTestData() throws IOException {
        testData = new TestData();
        email = testData.properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";
        name = testData.properties.getProperty("name");
        password = testData.properties.getProperty("password");
        confirmPassword = testData.properties.getProperty("confirm.password");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        myEmailAccount = testData.properties.getProperty("emag.email.account");
        myPasswordAccount = testData.properties.getProperty("emag.password.account");
        nickName = testData.properties.getProperty("emag.nick.name");
        mobilePhone = testData.properties.getProperty("emag.mobile.phone");


    }


    @Given("I go to eMag home page")
    @When("I go to eMag home page")
    public void goToEmagHomePage() {
        EmagHomePage homePage = new EmagHomePage(driver).get();
        homePage.verifyPageTitle();
    }

    @When("I SingUp on eMag")
    public void singUpPage() {
        EmagHomePage homePage = new EmagHomePage(driver).get();
        homePage.verifyPageTitle()
                .goToSingUp()
                .fillEmailField(email)
                .clickOnContinueButton()
                .fillSingUpPage(name, password, confirmPassword)
                .clickOnAgreeTerms()
                .clickOnConfirmAgeButton()
                .clickonContinueButton();
    }

    @When("I SingIn on eMag")
    public void singInPage() {
        EmagHomePage homePage = new EmagHomePage(driver).get();
        homePage.verifyPageTitle()
                .goToSingIn()
                .fillEmailField(myEmailAccount)
                .clickOnContinueButton()
                .fillPasswordField(myPasswordAccount)
                .clickOnContinueButton()
                .goToAccountPage()
                .clickGenderButton()
                .fillAccountDataPage(nickName, mobilePhone)
                .clickDayButton()
                .clickMonthButton()
                .clickYearButton()
                .clickEducationButton();
    }


    @When("I search for $product on eMag")
    public void searchForProduct(String product) {
        EmagHomePage homePage = new EmagHomePage(driver).get();
        homePage.verifyPageTitle()
                .fillSearchField(product)
                .clickOnSearchButton()
                .verifySearchPageTitle(product)
                .validateResults(product)
                .clickOnFirstItems(product);
    }

    @Then("I verify if the oldprice:$oldprice newprice:$newprice discount:$discount for product is correct")
    public void verifyDiscountForProduct(String oldprice, String newprice, String discount) {
        EmagProductPage productPage = new EmagProductPage(driver).get();
        productPage.validateCodProduct()
                .verifyThatTheProductIsInStock()
                .validateDiscountProduct(oldprice, newprice, discount)
                .addPhoneToCart()
                .clickOnDetailsButton()
                .validateOrderSummary()
                .verifyProductInCart();

    }

}
