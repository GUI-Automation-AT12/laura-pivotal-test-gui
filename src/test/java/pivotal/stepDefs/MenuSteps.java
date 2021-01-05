package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.context.Context;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.pages.HomePage;

public class MenuSteps {

    private Context context;
    private TopNavigationBar topNavigationBar;

    /**
     * Instantiates a new Action steps.
     */
    public MenuSteps() {
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
        topNavigationBar = new TopNavigationBar();
        topNavigationBar.openUserMenuDropdown();
    }
}
