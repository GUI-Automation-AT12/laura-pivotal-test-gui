package core.selenium.factory;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {

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
