package tests.story;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import help.ShareData;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import org.junit.runner.RunWith;
import steps.EmagProductStep;
import steps.EmagUserStep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class EmagProductSearchStory extends JUnitStories {

    ShareData share = new ShareData();


    public EmagProductSearchStory() throws IOException {
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new EmagProductStep(share));
        stepFileList.add(new EmagUserStep(share));


        return new InstanceStepsFactory(configuration(), stepFileList);
    }


    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/EmagProductSearchStory.story"),
                        Arrays.asList(""));

    }

}
