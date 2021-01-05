package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.context.Context;
import pivotal.ui.PageTransporter;

public class NavigationSteps {

    private PageTransporter pageTransporter;
    private Context context;

    /**
     * Instantiates a new Navigation steps.
     *
     * @param contextToSet the context to set
     */
    public NavigationSteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Navigate to page.
     *
     * @param pageName the page name
     */
    @When("^I navigate to (.*?)$")
    public void navigateToPage(final String pageName) {
        pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage(pageName);
    }
}
