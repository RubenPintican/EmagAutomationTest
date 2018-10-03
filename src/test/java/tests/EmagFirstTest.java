package tests;

import pages.EmagHomePage;
import help.BaseTest;
import org.junit.Test;

public class EmagFirstTest extends BaseTest {

    @Test

    public void firstTest ()
    {
        EmagHomePage homePage = new EmagHomePage(driver);

        homePage.fillSearchButton("Samsung");
        homePage.clickOnSearchButton();
        homePage.verifyPageTitle();
    }
}
