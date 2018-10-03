package tests;

import pages.EmagCartShop;
import pages.EmagHomePage;
import help.BaseTest;
import org.junit.Test;
import pages.EmagPhonePage;
import pages.EmagSearchPage;

public class EmagFirstTest extends BaseTest {

    @Test

    public void firstTest ()
    {
        EmagHomePage homePage = new EmagHomePage(driver);
        EmagSearchPage searchPage = new EmagSearchPage(driver);
        EmagPhonePage phonePage = new EmagPhonePage(driver);
        EmagCartShop cartShop = new EmagCartShop(driver);

        homePage.verifyPageTitle();
        homePage.fillSearchButton("Samsung Galaxy S9");
        homePage.clickOnSearchButton();
        searchPage.verifySearchPageTitle();
        searchPage.validateResults();
        searchPage.clickOnSelectedPhone();
        phonePage.addPhoneToCart();
        phonePage.validateProductInCart();
        phonePage.clickOnDetailsButton();
        cartShop.validateOrderSummary();
    }
}
