package tests;

import help.BaseTest;
import org.junit.Test;
import pages.EmagHomePage;

public class EmagDiscountProductTest extends BaseTest {
    @Test

    public void discountProductTest() {
        EmagHomePage homePage = new EmagHomePage(driver);
        homePage.verifyPageTitle()
                .fillSearchField("Samsung Galaxy S9")
                .clickOnSearchButton()
                .verifySearchPageTitle()
                .validateResults("Samsung Galaxy S9")
                .clickOnSelectedPhone()
                .validatePageProduct()
                .validateDiscountProduct();

    }
}
