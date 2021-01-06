package core.selenium.factory;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {

    private static final String FIREFOX_VERSION = "84.0.1";

    /**
     * Initializes Firefox driver.
     *
     * @return FirefoxDriver
     */
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FirefoxDriver.class).setup();
        return new FirefoxDriver();
    }
}
