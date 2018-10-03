package pages;

import help.HelperMethodes;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EmagSearchPage {
    WebDriver driver;

    public HelperMethodes functions = new HelperMethodes(driver);

    public void verifyPageTitle()
    {
        Assert.assertTrue(driver.getTitle().contains("eMAG.ro - Găsești mai mult decât crezi"));
    }

    
}
