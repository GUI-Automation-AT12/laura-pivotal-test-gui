package pivotal.stepDefs;

import io.cucumber.java.en.When;
import pivotal.ui.PageTransporter;
import pivotal.ui.Permalink;

public class NavigationSteps {

    private PageTransporter pageTransporter;

    /**
     * Navigate to page.
     *
     * @param pageName the page name
     */
    @When("^I navigate to (.*?)$")
    public void navigateToPage(final String pageName) {
        //profilePage = homePage.getProfileUser();
        //PageTransporter pageTransporter = new PageTransporter();
        //String link = Permalink.getPermalink(pageName.toUpperCase());
        pageTransporter.getInstance().navigateToPage(Permalink.getPermalink(pageName.toUpperCase()));
    }
}
