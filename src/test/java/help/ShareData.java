package help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ShareData {

    public WebDriver driver;
    public Properties properties = new Properties();


    public String myCelEmailAccount, myCelPasswordAccount, randomEmail, firstName, lastName, suburb, gender, telephone, city, streetAddress;
    public String myEmagEmailAccount, myEmagPasswordAccount, name, password, confirmPassword, nickName, mobilePhone;

    public ShareData() throws IOException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        properties.load(new FileInputStream("testData.properties"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        this.load();

    }

    public void load() {

        myCelEmailAccount = properties.getProperty("cel.email.account");
        myCelPasswordAccount = properties.getProperty("cel.password.account");

        randomEmail = properties.getProperty("base.email.address") + System.currentTimeMillis() + "@yahoo.com";
        firstName = properties.getProperty("cel.first.name");
        lastName = properties.getProperty("cel.last.name");
        suburb = properties.getProperty("cel.suburb");
        gender = properties.getProperty("cel.gender");
        telephone = properties.getProperty("cel.telephone");
        city = properties.getProperty("cel.city");
        streetAddress = properties.getProperty("cel.street.address");


        myEmagEmailAccount = properties.getProperty("emag.email.account");
        myEmagPasswordAccount = properties.getProperty("emag.password.account");

        name = properties.getProperty("emag.name");
        password = properties.getProperty("emag.password");
        confirmPassword = properties.getProperty("emag.confirm.password");
        nickName = properties.getProperty("emag.nick.name");
        mobilePhone = properties.getProperty("emag.mobile.phone");


    }
}