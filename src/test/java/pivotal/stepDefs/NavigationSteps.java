package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.ui.PageTransporter;

public class NavigationSteps {

    private PageTransporter pageTransporter;

    /**
     * Navigate to page.
     *
     * @param pageName the page name
     */
    @When("^I navigate to (.*?)$")
    public void navigateToPage(final String pageName) {
        pageTransporter.getInstance().navigateToPage(pageName);
    }
}
