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
                .fillSearchField(productName)
                .clickOnSearchButton()
                .verifySearchPageTitle(productName)
                .validateResults(productName)
                .clickOnFirstCorrectProduct(productName)
                .validatePageProduct()
                .validateDiscountProduct(oldPrice, newPrice, discount)
                .verifyThatTheProductIsInStock();

    }
}
