package steps;

import help.ShareData;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.emag.EmagHomePage;
import pages.emag.EmagProductPage;

public class EmagProductStep extends BaseSteps {
    public EmagProductStep(ShareData share) {
        super(share);
    }

    @When("I LogIn on eMag and I complete my account details")
    public void singInPage() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();
        homePage.goToSingIn()
                .fillEmailField(share.myEmagEmailAccount)
                .clickOnContinueButton()
                .fillPasswordField(share.myEmagPasswordAccount)
                .clickOnContinueButton()
                .goToAccountPage()
                .clickGenderButton()
                .fillAccountDataPage(share.nickName, share.mobilePhone)
                .clickDayButton()
                .clickMonthButton()
                .clickYearButton()
                .clickEducationButton();
    }

    @When("I search for $product on eMag")
    public void searchForProduct(String product) {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();
        homePage.fillSearchField(product)
                .clickOnSearchButton()
                .verifySearchPageTitle()
                .validateResults()
                .clickOnFirstItems(product);
    }

    @Then("I verify if the oldprice:$oldprice newprice:$newprice discount:$discount for product is correct")
    public void verifyDiscountForProduct(String oldprice, String newprice, String discount) {
        EmagProductPage productPage = new EmagProductPage(share.driver).get();
        productPage.validateCodProduct()
                .verifyThatTheProductIsInStock()
                .validateDiscountProduct(oldprice, newprice, discount)
                .addProductToCart()
                .validateProductInCart()
                .clickOnDetailsButton()
                .verifyProductInCart();

    }
}
