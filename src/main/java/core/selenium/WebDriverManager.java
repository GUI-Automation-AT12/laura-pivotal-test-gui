package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    private WebDriverWait webDriverWait;
    private static WebDriver webDriver;
    private static WebDriverManager webDriverManager;

    /**
     * Instantiates a new Web driver manager.
     */
    private WebDriverManager() {
        this.webDriver = WebDriverFactory.getWebDriver(WebDriverConfig.getInstance().getBrowser());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(),
                TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getTimeout(),
                WebDriverConfig.getInstance().getWaitSleepTime());
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
     * Gets web driver.
     *
     * @return the web driver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Quit web driver session.
     */
    public static void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
