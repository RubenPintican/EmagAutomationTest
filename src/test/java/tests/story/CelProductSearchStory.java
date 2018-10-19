package tests.story;


import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import help.ScreenShotOnFailure;
import help.ShareData;
import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import org.junit.Rule;
import org.junit.runner.RunWith;
import steps.CelProductStep;
import steps.CelUserStep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CelProductSearchStory extends SerenityStories {

    ShareData share = new ShareData();

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(share.driver);


    public CelProductSearchStory() throws IOException {
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new CelUserStep(share));
        stepFileList.add(new CelProductStep(share));


        return new InstanceStepsFactory(configuration(), stepFileList);
    }


    public List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/CelProductSearchStory.story"),
                        Arrays.asList(""));

    }


}
