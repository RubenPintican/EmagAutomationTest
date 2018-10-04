package tests;

import help.BaseTest;
import pages.EmagHomePage;
import org.junit.Test;


public class EmagProductSearchTest extends BaseTest {

    @Test

    public void productSearchTest() {
        EmagHomePage homePage = new EmagHomePage(driver);
        homePage.verifyPageTitle()
                .fillSearchField("Samsung Galaxy S9")
                .clickOnSearchButton()
                .verifySearchPageTitle()
                .validateResults("Samsung Galaxy S9")
                .clickOnSelectedPhone()
                .validatePageProduct()
                .addPhoneToCart()
                .validateProductInCart()
                .clickOnDetailsButton()
                .validateOrderSummary();

    }
}
