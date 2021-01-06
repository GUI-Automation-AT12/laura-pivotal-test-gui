package pivotal.stepDefs;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class WebsiteSteps {

    /**
     * Reload website.
     */
    @When("I reload the website")
    public void reloadWebsite() {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.get(webDriver.getCurrentUrl());
        webDriver.navigate().refresh();
    }
}
