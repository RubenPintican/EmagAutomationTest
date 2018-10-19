package steps;

import help.ShareData;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import pages.emag.EmagHomePage;

public class EmagUserStep extends BaseSteps {
    public EmagUserStep(ShareData share) {
        super(share);
    }
    @Step
    @Given("I go to eMag home page")
    public void goToEmagHomePage() {
        EmagHomePage homePage = new EmagHomePage(share.driver).get();

    }
    @Step
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
}
