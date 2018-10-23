package steps;

import help.ShareData;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.When;
import pages.emag.EmagHomePage;

public class EmagUserStep extends BaseSteps {
    public EmagUserStep(ShareData share) {
        super(share);
    }

    @Given("I go to eMag home page")
    public void goToEmagHomePage() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();

    }

    @When("I SingUp on eMag")
    public void singUpPage() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();
        homePage.goToSingUp()
                .fillEmailField(share.randomEmail)
                .clickOnContinueButton()
                .fillSingUpPage(share.name, share.password, share.confirmPassword)
                .clickOnAgreeTerms()
                .clickOnConfirmAgeButton()
                .clickonContinueButton();
    }

    @When("I LogIn on eMag and I complete my account details")
    public void setUpMyAccount() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();
        homePage.goToLogIn()
                .fillEmailField(share.myEmagEmailAccount)
                .clickOnContinueButton()
                .fillPasswordField(share.myEmagPasswordAccount)
                .clickOnContinueButton()
                .goToAccountPage()
                .clickGenderButton()
                .fillAccountDataPage(share.nickName, share.mobilePhone)
                .clickDayButton()
                .clickMonthButton()
                .clickYearButton()
                .clickEducationButton();
    }

    @When("I LogIn on eMag")
    public void logInToMyAccount() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();
        homePage.goToLogIn()
                .fillEmailField(share.myEmagEmailAccount)
                .clickOnContinueButton()
                .fillPasswordField(share.myEmagPasswordAccount)
                .clickOnContinueButton();
//                .welcomeMessage();
    }

    @BeforeScenario(uponType = ScenarioType.EXAMPLE)
    public void beforeEachExampleScenario() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();

        if (!homePage.checkIfLogedIn())
            logInToMyAccount();
    }
}
