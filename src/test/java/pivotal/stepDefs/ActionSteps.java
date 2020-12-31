package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.context.Context;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.pages.HomePage;

public class ActionSteps {

    private Context context;
    private TopNavigationBar topNavigationBar = new TopNavigationBar();

    /**
     * Instantiates a new Action steps.
     */
    public ActionSteps() {
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
     * Open the user dropdown menu from top menu.
     */
    @When("I open the User Dropdown Menu from Top Menu")
    public void openTheUserDropdownMenuFromTopMenu() {
        topNavigationBar.openUserMenuDropdown();
    }
}
