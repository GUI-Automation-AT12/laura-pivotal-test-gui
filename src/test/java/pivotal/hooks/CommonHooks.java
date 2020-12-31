package pivotal.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;

public class CommonHooks {
    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        WebDriverManager.quit();
    }
}
