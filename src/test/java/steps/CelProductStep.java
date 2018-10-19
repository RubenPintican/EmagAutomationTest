package steps;

import help.ShareData;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.cel.CelHomePage;
import pages.cel.CelProductPage;

public class CelProductStep extends BaseSteps {
    public CelProductStep(ShareData share) {
        super(share);
    }



    @When("I search for $product on Cel")
    public void searchProductOnCel(String product) {
        CelHomePage homePage = new CelHomePage(share.driver);
        homePage.fillSearchField(product)
                .clickOnSearchButton()
                .validateResults(product)
                .clickOnFirstItems(product);
    }

    @Then("I verify if the old price:$oldPrice new price:$newPrice discount:$discount for product is correct")
    public void verifyDiscountForProduct(String oldPrice, String newPrice, String discount) {
        CelProductPage productPage = new CelProductPage(share.driver);
        productPage.verifyThatPopUpIsPresent(share.randomEmail)
                .verifyThatTheProductIsInStock()
                .validateDiscountProduct(oldPrice, newPrice, discount);
    }
}
