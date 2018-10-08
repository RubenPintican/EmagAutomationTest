package tests.cel;

import help.BaseTest;
import org.junit.Test;
import pages.cel.CelHomePage;
import pages.cel.CelSearchPage;

import java.io.IOException;

public class CelProductSearchTest extends BaseTest {

    public CelProductSearchTest() throws IOException {
    }

    @Test
     public void productSearchTest ()
    {
        CelHomePage homePage = new CelHomePage(driver).get();
        homePage.verifyPageTitle()
                .fillSearchField(productName)
                .clickOnSearchButton()
//                .validateResults(productName)
                .clickOnFirstItems(productName);
    }
}
