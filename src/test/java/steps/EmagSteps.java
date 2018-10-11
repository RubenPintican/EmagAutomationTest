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

    //variabile declarate global
    String email;
    String name;
    String password;
    String confirmPassword;


    @Given("I load test data")
    public void loadTestData () throws IOException {
        testData = new TestData();
        email = testData.properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";
        name = testData.properties.getProperty("name");
        password = testData.properties.getProperty("password");
        confirmPassword = testData.properties.getProperty("confirm.password");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }


   @Given("I go to eMag home page")
   @When("I go to eMag home page")
   public void goToEmagHomePage(){
       EmagHomePage homePage = new EmagHomePage(driver).get();
       homePage.verifyPageTitle();
   }

   @When ("I SingUp on eMag")
    public void singUpPage ()
   {
       EmagHomePage homePage = new EmagHomePage(driver).get();
       homePage.verifyPageTitle()
               .goToSingUp()
               .fillEmailField(email)
               .clickOnContinueButton()
               .fillSingUpPage(name, password,confirmPassword)
               .clickOnAgreeTerms()
               .clickOnConfirmAgeButton()
               .clickonContinueButton();


   }
   @When("I search for $product on eMag")
    public void searchForProduct(String product)
   {
       EmagHomePage homePage = new EmagHomePage(driver).get();
       homePage.verifyPageTitle()
               .fillSearchField(product)
               .clickOnSearchButton()
               .verifySearchPageTitle(product)
               .validateResults(product)
               .clickOnFirstItems(product);
   }
   @Then("I verify if the oldprice:$oldprice newprice:$newprice discount:$discount for product is correct")
    public void  verifyDiscountForProduct(String oldprice, String newprice, String discount)
   {
       EmagProductPage productPage = new EmagProductPage(driver).get();
       productPage.validateCodProduct()
               .verifyThatTheProductIsInStock()
               .validateDiscountProduct(oldprice, newprice, discount);

   }

}
