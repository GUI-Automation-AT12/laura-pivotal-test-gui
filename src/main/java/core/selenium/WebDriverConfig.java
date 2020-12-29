package core.selenium;

import pivotal.config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebDriverConfig {

    private static final String BROWSER = "browser";
    private static final String IMPLICIT_WAIT_TIME = "implicitWaitTime";
    private static final String TIMEOUT = "timeout";
    private static final String WAIT_SLEEP_TIME = "waitSleepTime";
    private static WebDriverConfig webDriverConfig;
    private String browser;
    private int implicitWaitTime;
    private int timeout;
    private int waitSleepTime;

    private WebDriverConfig() {
        WebDriverManager.chromedriver().setup();
        browser = Environment.getInstance().getProperties().get(BROWSER);
        implicitWaitTime = Integer.parseInt(Environment.getInstance().getProperties().get(IMPLICIT_WAIT_TIME));
        timeout = Integer.parseInt(Environment.getInstance().getProperties().get(TIMEOUT));
        waitSleepTime = Integer.parseInt(Environment.getInstance().getProperties().get(WAIT_SLEEP_TIME));
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static WebDriverConfig getInstance() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    /**
     * Gets browser.
     *
     * @return the browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets implicit wait time.
     *
     * @return the implicit wait time
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets timeout.
     *
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Gets wait sleep time.
     *
     * @return the wait sleep time
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
