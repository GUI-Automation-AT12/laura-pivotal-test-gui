package pivotal.stepDefs;

import core.utils.JsonDataReader;
import io.cucumber.java.en.Given;
import pivotal.context.Context;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.InitialPage;

public class LoginSteps {
    private InitialPage initialPage;
    private HomePage homePage;
    private Context context;

    /**
     * Instantiates a new Login steps.
     *
     * @param contextToSet the context to set
     */
    public LoginSteps(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Log in.
     *
     * @param userAlias the user alias
     */
    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logIn(final String userAlias) {
        JsonDataReader jsonDataReader = new JsonDataReader("users.json");
        String email = jsonDataReader.getValueData(userAlias, "email");
        String password = jsonDataReader.getValueData(userAlias, "password");
        initialPage = new InitialPage();
        homePage = initialPage.login().login(email).login(password);
        context.setUserEdited(userAlias);
    }
}
