package pivotal.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.ProfilePage;
import pivotal.ui.pages.ProjectForm;

import java.util.Map;

public class RequestStepDefs {

    /**
     * Instantiates a new Request step defs.
     */
    public RequestStepDefs() {
    }

    /**
     * Edit my profile with the following information.
     *
     * @param data the data
     */
    @And("^I edit My Profile with the following information$")
    public void editProfile(final Map<String, String> data) {
        ProfilePage profilePage = new ProfilePage();
        String username = (String) data.get("User name");
        String name = (String) data.get("Name");
        String initials = (String) data.get("Initials");
        profilePage.editProfile(username, name, initials);

    }

    /**
     * Open the create project dialog in projects tab.
     */
    @When("I open the create project dialog in projects tab")
    public void iOpenTheCreateProjectDialogInProjectsTab() {
        HomePage homePage = new HomePage();
        homePage.createProject();
    }

    /**
     * Edit the project name field with the following information.
     *
     * @param data the data
     */
    @And("^I edit the Project Form with the following information$")
    public void iEditTheProjectNameFieldWithTheFollowingInformation(final Map<String, String> data) {
        ProjectForm projectForm = new ProjectForm();
        projectForm.createProject(data);
        projectForm.clickCreateButton();
    }
}
