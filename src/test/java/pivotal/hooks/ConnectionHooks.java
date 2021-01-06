package pivotal.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;

public class ConnectionHooks {

    /**
     * Tear down.
     */
    @After (value = "@quitBrowser", order = 0)
    public void tearDown() {
        WebDriverManager.quit();
    }
}
