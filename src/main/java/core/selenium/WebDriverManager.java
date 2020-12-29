package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    private WebDriverWait webDriverWait;
    private static WebDriver webDriver;
    private static WebDriverManager webDriverManager;
  //  private static final int TIMEOUT = 10;

    /**
     * Instantiates a new Web driver manager.
     */
    private WebDriverManager() {
       /* System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, TIMEOUT);*/

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
     * Quit.
     */
    public static void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
