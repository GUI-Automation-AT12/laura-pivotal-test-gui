package pivotal.stepDefs;

import io.cucumber.java.en.And;
import pivotal.context.Context;
import pivotal.entities.Project;
import pivotal.entities.User;
import pivotal.ui.forms.ProjectForm;
import pivotal.ui.pages.ProfilePage;

import java.util.Map;

public class FormSteps {

    private Context context;
    private Project project = new Project();
    private ProfilePage profilePage = new ProfilePage();;

    /**
     * Instantiates a new Form steps.
     *
     * @param contextToSet the context to set
     */
    public FormSteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Edit my profile with the following information.
     *
     * @param data the data
     */
    @And("^I edit My Profile with the following information$")
    public void editMyProfileWithTheFollowingInformation(final Map<String, String> data) {
        User user = new User();
        user.processInformation(data);
        context.setUser(user);
        profilePage.editProfile(data.keySet(), user);
    }

    /**
     * Edit the project name field with the following information.
     *
     * @param data the data
     */
    @And("^I edit the Project Form with the following information$")
    public void editTheProjectNameFieldWithTheFollowingInformation(final Map<String, String> data) {
        ProjectForm projectForm = new ProjectForm();
        projectForm.createProject(data);
        project.processInformation(data);
        projectForm.clickCreateButton();
    }
}
