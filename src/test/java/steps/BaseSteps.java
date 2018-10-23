package steps;

import help.ShareData;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.steps.Steps;
import org.junit.After;
import org.junit.AfterClass;

public  class BaseSteps extends Steps {

    ShareData share;

    public BaseSteps(ShareData share) {
        this.share = share;
    }


    @AfterStory
    public void tearDown() {
        share.driver.quit();

    }
}
