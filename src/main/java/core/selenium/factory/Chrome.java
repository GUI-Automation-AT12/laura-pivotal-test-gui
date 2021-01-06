package core.selenium.factory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {

    /**
     * Initializes Chrome driver.
     *
     * @return ChromeDriver
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(ChromeDriver.class).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
