package help;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class BaseTest {


    public WebDriver driver = new FirefoxDriver();
    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);
    TestData testData = new TestData();
    protected String productName = testData.properties.getProperty("product.name");
    protected String oldPrice = testData.properties.getProperty("old.price");
    protected String newPrice = testData.properties.getProperty("new.price");
    protected String discount = testData.properties.getProperty("discount");
    protected String email = testData.properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";

    public BaseTest() throws IOException {
    }


    @Before
    public void setup() {
        driver.manage().window().maximize();
    }


}