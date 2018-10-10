package steps;


import help.TestData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.emag.EmagHomePage;
import pages.emag.EmagProductPage;
import pages.emag.EmagSearchPage;

import java.io.IOException;


public class emagSteps extends Steps {
    TestData testData;
    WebDriver driver;




    @Given("I load test data")
    public void loadTestData () throws IOException {
        testData = new TestData();
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }


   @Given("I go to eMag home page")
   @When("I go to eMag home page")
   public void goToEmagHomePage(){
       EmagHomePage homePage = new EmagHomePage(driver).get();
       homePage.verifyPageTitle();
   }

   @When("I search for $product on eMag")
   @Given("I search for $product on eMag")
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
       productPage.validatePageProduct()
               .verifyThatTheProductIsInStock()
               .validateDiscountProduct(oldprice, newprice, discount);

   }

}
