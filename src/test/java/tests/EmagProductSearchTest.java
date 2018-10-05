package tests;

import help.BaseTest;
import help.TestData;
import pages.EmagHomePage;
import org.junit.Test;

import java.io.IOException;


public class EmagProductSearchTest extends BaseTest {

    @Test

    public void productSearchTest() throws IOException {
        EmagHomePage homePage = new EmagHomePage(driver);
        TestData testData = new TestData();
        String productName = testData.properties.getProperty("product.name");
        homePage.verifyPageTitle()
                .fillSearchField("Samsung Galaxy S9")
                .clickOnSearchButton()
                .verifySearchPageTitle("Samsung Galaxy S9")
                .validateResults("Samsung Galaxy S9")
                .clickOnFirstCorrectProduct(productName)
                .validatePageProduct()
                .addPhoneToCart()
                .validateProductInCart()
                .clickOnDetailsButton()
                .validateOrderSummary();

    }
}
