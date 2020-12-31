package core.selenium.factory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    /**
     * Initializes Chrome driver.
     *
     * @return ChromeDriver
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(ChromeDriver.class).setup();
        return new ChromeDriver();
    }
}
