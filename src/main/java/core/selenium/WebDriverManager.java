package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
    private WebDriverWait driverWait;
    private WebDriver webDriver;
    private static final int TIMEOUT = 10;

    /**
     * Instantiates a new Web driver manager.
     */
    public WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, TIMEOUT);
    }

    /**
     * Instantiates a new Web driver manager.
     *
     * @param webDriverToSet  the web driver to set
     * @param driverWaitToSet the driver wait to set
     */
    public WebDriverManager(final WebDriver webDriverToSet, final WebDriverWait driverWaitToSet) {
        this.driverWait = driverWaitToSet;
        this.webDriver = webDriverToSet;
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

}
