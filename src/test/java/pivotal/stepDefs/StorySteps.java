package pivotal.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pivotal.context.Context;
import pivotal.ui.components.StoryComponent;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.ProjectPage;

public class StorySteps {

    private ProjectPage projectPage;
    private Context context;

    /**
     * Instantiates a new Story steps.
     *
     * @param contextToSet the context to set
     */
    public StorySteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Open the default project in the dashboard.
     */
    @And("I open the Default project in the dashboard")
    public void openTheDefaultProjectInTheDashboard() {
        HomePage homePage = new HomePage();
        projectPage = homePage.openDefaultProject();
    }

    /**
     * Move a story from current iteration backlog panel to icebox panel.
     */
    @And("^I move Default Story from Current Iteration\\/Backlog Panel to Icebox Panel$")
    public void moveAStoryFromCurrentIterationBacklogPanelToIceboxPanel() {
        projectPage.moveStoryFromBacklogToIceboxPanel();
    }

    /**
     * Verify story is not in the given panel.
     */
    @Then("^the story should not be in the (.*?) Panel$")
    public void verifyStoryIsNotInPanel(final String panel) {
        String storyId = context.getStory().getId();
        Assert.assertFalse(projectPage.isStoryInPanel(storyId, panel));
    }

    /**
     * Verify story is in the given panel.
     */
    @And("^the story should be in the (.*?) Panel$")
    public void verifyStoryIsInThePanel(final String panel) {
        String storyId = context.getStory().getId();
        Assert.assertTrue(projectPage.isStoryInPanel(storyId, panel));
    }

    /**
     * Open the default story from icebox panel.
     */
    @When("I open the story from Icebox Panel")
    public void openTheDefaultStoryFromIceboxPanel() {
        projectPage.openDefaultStory();
    }


    /**
     * Verify story attribute is not changed.
     *
     * @param attribute the attribute
     */
    @And("^the story's (.*?) should not change$")
    public void verifyStoryAttributeIsNotChanged(final String attribute) {
        StoryComponent storyComponent = new StoryComponent();
        String actualValue = storyComponent.getTextFromAttribute(attribute);
        String storyAttribute = context.getStory().getAttribute(attribute);
        Assert.assertEquals(actualValue, storyAttribute);
    }
}
