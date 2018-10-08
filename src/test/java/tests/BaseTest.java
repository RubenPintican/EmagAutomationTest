package help;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    TestData testData = new TestData();
    protected String productName = testData.properties.getProperty("product.name");
    protected String oldPrice = testData.properties.getProperty("old.price");
    protected String newPrice = testData.properties.getProperty("new.price");
    protected String discount = testData.properties.getProperty("discount");

    public BaseTest() throws IOException {
    }

    @Before
    public void setup ()

    {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
    }


}