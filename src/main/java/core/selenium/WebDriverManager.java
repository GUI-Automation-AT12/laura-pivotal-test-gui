package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverManager {
    private WebDriverWait driverWait;
    private static WebDriver webDriver;
    private static WebDriverManager webDriverManager;
    private static final int TIMEOUT = 10;

    /**
     * Instantiates a new Web driver manager.
     */
    private WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, TIMEOUT);
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * Gets driver wait.
     *
     * @return the driver wait
     */
    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Quit.
     */
    public static void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
