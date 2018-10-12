package pages.emag;

import help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmagAccountPage extends BasePage<EmagAccountPage> {

    public HelperMethods helper = new HelperMethods(driver);

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement verifyNameAccount;
    @FindBy(how = How.XPATH, using = "//label[@for='accountGenderMale']")
    private WebElement genderButton;
    @FindBy(how = How.XPATH, using = ".//*[@name='nickname']")
    private WebElement nicknameBox;
    @FindBy(how = How.XPATH, using = ".//*[@name='telephone1']")
    private WebElement mobilephoneBox;
    @FindBy(how = How.XPATH, using = "//select[@name='ziua']")
    private WebElement dayButton;
    @FindBy(how = How.XPATH, using = "//select[@name='luna']")
    private WebElement monthButton;
    @FindBy(how = How.XPATH, using = "//select[@name='anul']")
    private WebElement yearButton;
    @FindBy(how = How.ID, using = "nivel_educatie")
    private WebElement educationButton;

    public EmagAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public EmagAccountPage validateNameAccount()
//    {
//        helper.waitExplicit(verifyNameAccount,driver);
//        Assert.assertTrue(verifyNameAccount.getText().contains("Ruben Pintican"));
//        return this;
//    }

    public EmagAccountPage clickGenderButton() {
        genderButton.click();
        return this;
    }

    public EmagAccountPage fillAccountDataPage(String nickname, String mobilephone) {
        nicknameBox.sendKeys(nickname);
        mobilephoneBox.sendKeys(mobilephone);
        return this;
    }

    public EmagAccountPage clickDayButton() {
        helper.selectByValue(dayButton, "21");
        dayButton.click();
        return this;

    }

    public EmagAccountPage clickMonthButton() {
        helper.selectByValue(monthButton, "2");
        monthButton.click();
        return this;
    }

    public EmagAccountPage clickYearButton()
    {
        helper.selectByValue(yearButton,"1995");
        yearButton.click();
        return this;
    }
    public EmagAccountPage clickEducationButton()
    {
        helper.selectByValue(educationButton,"4");
        educationButton.click();
        return this;
    }

    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {

    }
}
