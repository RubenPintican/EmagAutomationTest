package tests;

import pages.EmagCartShop;
import pages.EmagHomePage;
import help.BaseTest;
import org.junit.Test;
import pages.EmagPhonePage;
import pages.EmagSearchPage;

public class EmagProductSearchTest extends BaseTest {

    @Test

    public void productSearchTest ()
    {
        EmagHomePage homePage = new EmagHomePage(driver);
        homePage.verifyPageTitle();
        homePage.fillSearchButton("Samsung Galaxy S9").clickOnSearchButton();

        EmagSearchPage searchPage = new EmagSearchPage(driver);
        searchPage.verifySearchPageTitle();
        searchPage.validateResults();
        searchPage.clickOnSelectedPhone();

        EmagPhonePage phonePage = new EmagPhonePage(driver);
        phonePage.addPhoneToCart().validateProductInCart().clickOnDetailsButton();

        EmagCartShop cartShop = new EmagCartShop(driver);
        cartShop.validateOrderSummary();




    }
}
