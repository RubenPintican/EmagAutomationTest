package tests.emag;

import help.BaseTest;
import org.junit.Test;
import pages.emag.EmagHomePage;

import java.io.IOException;

public class EmagDiscountProductTest extends BaseTest {
    public EmagDiscountProductTest() throws IOException {
    }

    @Test

    public void discountProductTest() {
        EmagHomePage homePage = new EmagHomePage(driver).get();


        homePage.verifyPageTitle()
                .goToSingUp()
                .fillEmailField(email)
                .clickOnContinueButton()
                .fillSingUpPage("Gigi Boss","dinamo21","dinamo21")
                .clickOnAgreeTerms()
                .clickOnConfirmAgeButton()
                .clickOnContinueButton()
                .fillSearchField(productName)
                .clickOnSearchButton()
                .verifySearchPageTitle(productName)
                .validateResults(productName)
                .clickOnFirstCorrectProduct(productName)
                .validateCodProduct()
                .verifyThatTheProductIsInStock()
                .validateDiscountProduct(oldPrice, newPrice, discount);


    }
}
