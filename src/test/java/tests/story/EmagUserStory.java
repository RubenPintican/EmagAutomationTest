package tests.story;

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
import steps.EmagUserStep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmagUserStory extends SerenityStory {

    ShareData share = new ShareData();

    public EmagUserStory() throws IOException {
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new EmagUserStep(share));

        return new InstanceStepsFactory(configuration(), stepFileList);
    }


    public List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/EmagUserStory.story"),
                        Arrays.asList(""));

    }


}
