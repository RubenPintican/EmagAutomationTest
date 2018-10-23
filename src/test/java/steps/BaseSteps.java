package steps;

import help.ShareData;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.steps.Steps;

public class BaseSteps extends Steps {

    ShareData share;


    public BaseSteps(ShareData share) {
        this.share = share;
    }


    @AfterStory()
    public void closeDriver() {
        share.driver.close();
    }


}


