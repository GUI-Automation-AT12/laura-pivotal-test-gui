package pivotal.stepDefs;

import io.cucumber.java.en.Given;
import pivotal.config.Environment;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.InitialPage;

public class LoginSteps {
    private InitialPage initialPage;
    private HomePage homePage;

    /**
     * Log in.
     *
     * @param userAlias the user alias
     */
    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logIn(final String userAlias) {
        String email = Environment.getInstance().getProperties().get("email");
        String password = Environment.getInstance().getProperties().get("password");
        initialPage = new InitialPage();
        homePage = initialPage.login().login(email).login(password);
    }
}
