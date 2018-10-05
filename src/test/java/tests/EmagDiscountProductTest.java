package tests;

import help.BaseTest;
import help.TestData;
import org.junit.Test;
import pages.EmagHomePage;

import java.io.IOException;

public class EmagDiscountProductTest extends BaseTest {
    @Test

    public void discountProductTest() throws IOException {
        TestData testData = new TestData();
        String productName = testData.properties.getProperty("product.name");
        String oldPrice = testData.properties.getProperty("old.price");
        String newPrice = testData.properties.getProperty("new.price");
        String discount = testData.properties.getProperty("discount");
        EmagHomePage homePage = new EmagHomePage(driver);
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
