package help;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup ()

    {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        driver = new FirefoxDriver();

        driver.get("https://www.emag.ro/");

        driver.manage().window().maximize();
    }


}