package tests.story;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;

import help.ScreenShotOnFailure;
import help.ShareData;
import steps.CelProductStep;
import steps.CelUserStep;

@RunWith(JUnitReportingRunner.class)
public class CelProductSearchStory extends JUnitStories {

    ShareData share = new ShareData();

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(share.driver);


    public CelProductSearchStory() throws IOException {
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
                .withFormats(Format.TXT, Format.CONSOLE, Format.HTML_TEMPLATE, Format.HTML, Format.XML, Format.XML_TEMPLATE))
        .useViewGenerator(new FreemarkerViewGenerator());
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new CelUserStep(share));
        stepFileList.add(new CelProductStep(share));
        return new InstanceStepsFactory(configuration(), stepFileList);
    }


    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("**/CelProductSearchStory.story"),
                        Arrays.asList(""));

    }


}
