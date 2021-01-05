package pivotal.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pivotal.context.Context;
import pivotal.entities.Project;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.forms.ProjectForm;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.ProjectPage;

import java.util.Map;

public class CreateProjectSteps {

    private Context context;
    private ProjectForm projectForm;

    /**
     * Instantiates a new Create project steps.
     *
     * @param contextToSet the context to set
     */
    public CreateProjectSteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Open the create project dialog in projects tab.
     */
    @When("I open the create project dialog in projects tab")
    public void openTheCreateProjectDialogInProjectsTab() {
        HomePage homePage = new HomePage();
        homePage.createProject();
    }

    /**
     * Edit the project name field with the following information.
     *
     * @param data the data
     */
    @And("^I edit the Project Form with the following information$")
    public void editTheProjectFormWithTheFollowingInformation(final Map<String, String> data) {
        Project project = new Project();
        this.projectForm = new ProjectForm();
        project.processInformation(data);
        context.setProject(project);
        projectForm.createProject(project.getProjectInfo());
        projectForm.clickCreateButton();
    }

    @Then("the user should be redirected to the created project dashboard")
    public void verifyUserIsRedirectedToTheCreatedProjectDashboard() {
        ProjectPage projectPage = new ProjectPage();
        Assert.assertTrue(projectPage.isPanelBacklogVisible());
    }

    @And("the name of created project should be visible in the header of the page")
    public void verifyNameOfCreatedProjectIsVisibleInTheHeaderOfThePage() throws InterruptedException {
        TopNavigationBar topNavigationBar = new TopNavigationBar();
        String nameProject = context.getProject().getProjectName();
        String actualValue = topNavigationBar.getTextFromProjectWorkspaceDropdown();
        Assert.assertEquals(actualValue, nameProject);
    }
}
