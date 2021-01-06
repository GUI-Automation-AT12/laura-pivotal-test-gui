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
     * Verify story is not in the current iteration backlog panel.
     */
    @Then("^Default Story should not be in the Current Iteration\\/Backlog Panel$")
    public void verifyStoryIsNotInTheCurrentIterationBacklogPanel() {
        String storyId = context.getStory().getId();
        Assert.assertTrue(!projectPage.isStoryInBacklogPanel(storyId));
    }

    /**
     * Verify story is in the icebox panel.
     */
    @And("^the Default Story should be in the Icebox Panel$")
    public void verifyStoryIsInTheIceboxPanel() {
        String storyId = context.getStory().getId();
        Assert.assertTrue(projectPage.isStoryInIceboxPanel(storyId));
    }

    /**
     * Open the default story from icebox panel.
     */
    @When("I open the Default Story from Icebox Panel")
    public void openTheDefaultStoryFromIceboxPanel() {
        projectPage.openDefaultStory();
    }

    /**
     * Verify story name is not changed.
     */
    @And("^the Default Story's name should not change$")
    public void verifyStoryNameIsNotChanged() {
        StoryComponent storyComponent = new StoryComponent();
        String actualValue = storyComponent.getTextFromStoryTitle();
        String storyId = context.getStory().getName();
        Assert.assertEquals(actualValue, storyId);
    }

    /**
     * Verify story id is not changed.
     */
    @And("^the Default Story's id should not change$")
    public void verifyStoryIdIsNotChanged() {
        StoryComponent storyComponent = new StoryComponent();
        String actualValue = storyComponent.getTextNumbersFromAttributeValueOfStoryId();
        String storyId = context.getStory().getId();
        Assert.assertEquals(actualValue, storyId);
    }
}
