package steps;

import help.ShareData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.cel.CelHomePage;

public class CelUserStep extends BaseSteps {


    public CelUserStep(ShareData share) {
        super(share);
    }

    @Given("I go to Cel home page")
    public void goToCelHomePage() {
        CelHomePage homePage = new CelHomePage(share.driver).get();
    }

    @When("I SingUp on Cel and I complete the account details")
    public void singUpPage() {
        CelHomePage homePage = new CelHomePage(share.driver).get();
        homePage.singUpCellAccount()
                .fillFirstNameField(share.firstName)
                .fillLastNameField(share.lastName)
                .fillEmailAddressField(share.randomEmail)
                .clickGenderBox(share.gender)
                .fillTelephoneField(share.telephone)
                .fillStreetAddressField(share.streetAddress)
                .clickSuburb(share.suburb)
                .clickCity(share.city)
                .createAccountButton()
                .validationMessage()
                .clickOnContinueButton();
    }

    @When("I LogIn on Cel")
    public void singInPage() {
        CelHomePage homePage = new CelHomePage(share.driver).get();
        homePage.singInCellAccount()
                .fillEmailField(share.myCelEmailAccount)
                .fillPasswordField(share.myCelPasswordAccount)
                .singInButton()
                .welcomeMessage();

    }

    @Then("I LogOut from my Account")
    public void  logOutPage(){
        CelHomePage homePage = new CelHomePage(share.driver).get();
        homePage.logOutFromAccount();
    }
}