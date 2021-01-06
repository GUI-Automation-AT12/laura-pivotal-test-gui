package core.selenium.factory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    private static final String CHROME_VERSION = "87.0.4280.88";

    /**
     * Initializes Chrome driver.
     *
     * @return ChromeDriver
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(ChromeDriver.class).version(CHROME_VERSION).setup();
        return new ChromeDriver();
    }
}
