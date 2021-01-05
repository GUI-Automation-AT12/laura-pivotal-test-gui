package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.ui.bares.TopNavigationBar;

public class MenuSteps {

    private TopNavigationBar topNavigationBar;

    /**
     * Instantiates a new Action steps.
     */
    public MenuSteps() {
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
