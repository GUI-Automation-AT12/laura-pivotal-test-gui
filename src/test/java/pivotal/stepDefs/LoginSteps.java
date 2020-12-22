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
  //  public void logIn() {
        String email = Environment.getInstance().getEmail();
        String password = Environment.getInstance().getPassword();
        initialPage = new InitialPage();
        homePage = initialPage.login().login(email).login(password);
    }
}
