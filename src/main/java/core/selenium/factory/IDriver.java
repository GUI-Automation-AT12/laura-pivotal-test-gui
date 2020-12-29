package core.selenium.factory;

import org.openqa.selenium.WebDriver;

public interface IDriver {

    /**
     * Initialize web driver.
     *
     * @return Instance of Driver.
     */
    WebDriver initDriver();
}
